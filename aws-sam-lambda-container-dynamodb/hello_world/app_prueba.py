import json
import boto3


dynamodb = boto3.resource("dynamodb")
tabla = dynamodb.Table("sys_battery4")


def  prueba (event, context):
    parametros = event.get("pathParameters")
    id = parametros.get("id")
    informacion = tabla.get_item(Key={"batt_id" : id})
    datos = informacion.get("Item")
    
    respuesta = {
        "ruta" : event.get("path"),
        "mensaje" : "hola, que tal",
        "metodo": event.get("httmethod"),
        "informacion" : datos 
    }
    return {
        "statusCode":  200,
        "headers" : {"context-type" / "aplication/json"},
        "body" : json.dumps(respuesta)
    }