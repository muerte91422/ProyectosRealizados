import json
import boto3 #libreria de AWS que permite conectar python y la bdd



def  sys_battery_lambda(event, context):
    
    print(f"El evento es: {json.dumps(event)}") #Tranforma  un json a un string 
    
    dynamodb = boto3.resource("dynamodb") #Aqui te conectas a la bdd 
    tabla = dynamodb.Table("battery-catalog-demo")# Se conecta  a la tabla de la bdd
    
    http_method = (event.get("httpMethod").lower())
    

    respuesta = {#Esta diccionario respuesta es para cuando hay algun error y detecte la variable respuesta
        "mensaje": "Método no soportado o error",
        "metodo_recibido": http_method
    }
    parametros = event.get("pathParameters") or {} #Parametros que le pasas por la uRL 
    #si no lo encuentra nos pone un {} y esto funciona en local
    bateria_id = parametros.get("id")
    
    if http_method=="get": #Cuando el metodo sea get entra ahi 
        
        if bateria_id is None: #Entra cuando no hemos puesto id
            try:
                informacion = tabla.scan() #busca la informacion que hay en la tabla y la pasa a un Json
                datos = informacion.get("Items", []) #Acceder a Items donde estan  datos de la bdd
                #salida del get general
                
                respuesta = {
                    "mensaje" : "La informacion de la base de datos sys_battery",
                    "metodo" : http_method,
                    "ruta" : event.get("path"),
                    "bateria": datos
                    
                        
                    }
            except Exception as e:
                
                respuesta = {
                    "error": "No se pudo leer la tabla",
                    "detalle": str(e)
                }
                
            
        else:   #Cuando tiene id entra aqui  
              
           
            informacion_datos = tabla.get_item(Key={"batt_id": bateria_id})# Muestra datos que coinciden con el id
            bateria_filtrada = informacion_datos.get("Item")# Te quedas solo con los datos que te interesen de la bdd
           
            respuesta = {
                    "mensaje" : f"La informacion del id: {bateria_id}",
                    "metodo" : http_method,
                    "ruta" : event.get("path"),
                    "bateria": bateria_filtrada
                    
                        
                    }
                
        
    elif http_method=="post":
        datos_a_meter =event.get("body") or {}      
        datos_a_meter_dicc=json.loads(datos_a_meter)# el json lo pasamos a diccionario
        introducidos= tabla.put_item(Item = datos_a_meter_dicc) # Item --> Especifica al valor que vamos a meter
        respuesta = {
            "mensaje" : "La informacion se ha mandado a la tabla sys_battery ",
            "metodo" : http_method,
            "ruta" : event.get("path"),
            "bateria" : datos_a_meter_dicc
            }
        
    elif http_method=="delete":
        try:
            
            
            eliminado =  tabla.delete_item(Key = {"batt_id": bateria_id})
            respuesta = {
                "mensaje" : f"La informacion con id {bateria_id} se ha eliminado de la tabla sys_battery ",
                "metodo" : http_method,
                "ruta" : event.get("path")
                
                }
        except KeyError:
            return {
                "statusCode": 400,
                "headers": {"Content-Type": "application/json"},
                "body": json.dumps({"error": "Falta el ID en la ruta"})
            }
        except Exception as e:
            return {
                "statusCode": 500,
                "headers": {"Content-Type": "application/json"},
                "body": json.dumps({
                    "error": "Error al eliminar el ítem",
                    "detalle": str(e)
                })
            }
    elif http_method=="put":
        datos_actualizar = event.get("body") or {}
        datos_actulizar_dicc = json.loads(datos_actualizar)#json a diccionario 
        
        batt_id= datos_actulizar_dicc.get("batt_id", "")#Comprobar si el id que le hemos dado existe o no en los datos 
        actualizar = tabla.put_item(Item= datos_actulizar_dicc)
        respuesta={
            
                "mensaje" : f"La informacion con id {batt_id} se ha  creado/actualizado en  la tabla sys_battery ",
                "metodo" : http_method,
                "ruta" : event.get("path"),
                "bateria" : datos_actulizar_dicc
        }
    return {
        "statusCode": 200,
        "headers": {
            "Content-Type" :"application/json"
        },
        "body": json.dumps(respuesta)
            
    }
   


