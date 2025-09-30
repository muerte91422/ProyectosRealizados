/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.creadorrecetas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Crear la opcion de que el usuario pueda consultar las recetas
 * Poner una opcion de busqueda conjunta de ingredientes y tiempo a la vez
 * Poder modificar o eliminar una receta
 * Ponerle a las recetas el atributo de si es para el desayuno, comida o cena(esto hay que mirarlo)
 * 
 * 
 */
public class OrganizadorRecetas {

    /**
     * 
     * 
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        File directorio = new File("Recetas");
        if(!directorio.exists()){
            if(directorio.mkdir()){
                System.out.println("Carpeta 'recetas' creada.");
            }else{
                System.out.println("Error al crear la carpeta 'recetas'.");
            }
        }else{
            System.out.println("La carpeta 'recetas' ya existe.");
        }
        
        System.out.println();
        
        Scanner escribir = new Scanner(System.in); 
        Boolean salida=true;
       
        int opciones=0;
        
        
        // Ruta del archivo
        String rutaarchivo = directorio.getPath() + File.separator + "recetas.ser";
        
        List<Recetas> listaReceta =new ArrayList<>();
        File archivo = new File(rutaarchivo);
        //Leer la carpeta con todas las recetas guardadas
        if (archivo.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                listaReceta = (List<Recetas>) ois.readObject();
                System.out.println("Recetas cargadas desde " + rutaarchivo);
            
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar las recetas: " + e.getMessage());
                listaReceta = new ArrayList<>(); // Inicializa lista vacía en caso de error
            }
            
        } else {
            System.out.println("El archivo 'recetas.ser' no existe, inicializando lista vacía.");
        }
        
        
        
        do{
        System.out.println("Opciones a realizar: ");
        System.out.println("1.Anadir Receta ");
        System.out.println("2.Mostrar lista de recetas ");
        System.out.println("3.Modificar receta ");
        System.out.println("4.Eliminar receta ");
        System.out.println("5.Busqueda de alimentos ");
        System.out.println("6.Busqueda por tiempo ");
        System.out.println("7.Busqueda alimentos y tiempo ");
        System.out.println("8.Salir ");
        
        
                
            while(true){
                try{
                    System.out.print("\nElige la opcion que quieres realizar:  ");
                    opciones = escribir.nextInt();
                    escribir.nextLine();
                    System.out.println();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("\nError: Por favor, ingresa un número entero válido.");
                    escribir.nextLine();
                        }
                }

        
    
        switch(opciones){
            case 1:
                ArrayList<String> listaIngredientes =new ArrayList<>();
                ArrayList<String> listaPasos =new ArrayList<>();
                
                
                Boolean salida2=true;
                Boolean salida3=true;
                
                
                System.out.print("Nombre de la receta: ");
                String nombre=escribir.nextLine();
                do{
                System.out.print("\nEscribe los ingredientes(Al terminar escribe fin): ");
                String ingrediente=escribir.nextLine();
                
                    if (ingrediente.equalsIgnoreCase("fin")){
                        salida2=false;
                    }else{
                        listaIngredientes.add(ingrediente);
                        
                    }
                    
                
                    
                }while(salida2==true);
                
                do{
                
                System.out.print("\nIngresa los pasos de la receta(Al terminar escribe fin): ");
                String pasos = escribir.nextLine();
                
                if(pasos.equalsIgnoreCase("fin")){
                    salida3=false;    
                }else{
                    listaPasos.add(pasos);
                }
                }while(salida3==true);
                System.out.print("\nDame  el tiempo  en  minutos para la preparacion: ");
                int tiempo = escribir.nextInt();
                
                    
                Recetas receta = new Recetas(nombre,listaIngredientes, listaPasos, tiempo);
                
                listaReceta.add(receta);
                
                String ruta = "recetas/recetas.ser";
                
                //Guardamos la receta en nuestra carpeta
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){
                    oos.writeObject(listaReceta);  // Serializa la lista completa
                    System.out.println("\nRecetas guardadas en " + ruta);
                }catch (IOException e) {
                    System.out.println("\nError al guardar: " + e.getMessage());
                }
                System.out.println();
                break;
                
            case 2:
                int contador2=0;
                System.out.println("\nLas recetas que hay guardadas son:");
                
                for(int i=0; i<(listaReceta.size()+2)/3;i++){
                  
                    for (int j = 0; j < 3; j++) {
                        int index = i * 3 + j;
                    if (index < listaReceta.size()) {
                        System.out.printf("%3d. %-40s", index + 1, listaReceta.get(index).getnombre());
                    } else {
                        System.out.print("                                                                 "); // 3 (número) + 1 (punto) + 40 (nombre) + 1 (espacio extra)
                    }
                    
                    
                }
                    System.out.println();//Salto de linea en cada uno
                    
                }
                
                int opcion=0;
                while(true){
                    try{
                        System.out.print("\nElija la receta que le guste mas: ");
                        opcion = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                
                
                if(opcion-1>listaReceta.size()&&opcion-1<0){
                    System.out.println("\nEl numero de rango para las recetas no existe coge un numero que este dentro del rango de recetas\n");
                }else{
                System.out.println("\nNombre: "+ listaReceta.get(opcion-1).getnombre());
                
                System.out.println("\nIngredientes: ");
                
                for(int i=0;i<listaReceta.get(opcion-1).getingredientes().size();i++){
                    
                    System.out.println((i+1)+". "+listaReceta.get(opcion-1).getingredientes().get(i));
                }
                
                System.out.println("\nPasos: ");
                
                for(int i=0;i<listaReceta.get(opcion-1).getpasos().size();i++){
                    
                    System.out.println((i+1)+". "+listaReceta.get(opcion-1).getpasos().get(i));
                }
                System.out.println("\nTiempo: "+ listaReceta.get(opcion-1).gettiempo()+" minutos");
                
                }
                System.out.println();
                break;
            case 3:
                contador2=0;
                System.out.println("\nLas recetas que hay guardadas son:");
                
                for(int i=0; i<(listaReceta.size()+2)/3;i++){
                  
                    for (int j = 0; j < 3; j++) {
                        int index = i * 3 + j;
                    if (index < listaReceta.size()) {
                        System.out.printf("%3d. %-40s", index + 1, listaReceta.get(index).getnombre());
                    } else {
                        System.out.print("                                                                 "); // 3 (número) + 1 (punto) + 40 (nombre) + 1 (espacio extra)
                    }
                    
                    
                }
                    System.out.println();//Salto de linea en cada uno
                    
                }
                
                System.out.println();
                
                
                int modificar=0;
                
                while(true){
                    try{
                        System.out.print("Elija el numero de la receta que quiera modificar (Si no quieres modificar nada, "
                        + "introduce 0): ");
                        modificar = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                
                if(modificar==0){
                    System.out.println("\nNo se ha modificado ninguna receta \n");
                }else{
                    if(modificar-1>listaReceta.size()&&modificar-1<-1){
                        System.out.println("\nEl numero de rango para las recetas no existe coge un numero que este dentro del rango de recetas\n");
                    }else{

                    System.out.println("\nVas a crear los datos de nuevo de la receta "+listaReceta.get(modificar-1).getnombre()+"\n");
                    
                    ArrayList<String> listaIngredientes2 =new ArrayList<>();
                    ArrayList<String> listaPasos2 =new ArrayList<>();
                
                
                salida2=true;
                salida3=true;
                
                
                System.out.print("Nombre de la receta: ");
                nombre=escribir.nextLine();
                do{
                System.out.print("\nEscribe los ingredientes(Al terminar escribe fin): ");
                String ingrediente=escribir.nextLine();
                
                    if (ingrediente.equalsIgnoreCase("fin")){
                        salida2=false;
                    }else{
                        listaIngredientes2.add(ingrediente);
                        
                    }
                    
                
                    
                }while(salida2==true);
                
                do{
                
                System.out.print("\nIngresa los pasos de la receta(Al terminar escribe fin): ");
                String pasos = escribir.nextLine();
                
                if(pasos.equalsIgnoreCase("fin")){
                    salida3=false;    
                }else{
                    listaPasos2.add(pasos);
                }
                }while(salida3==true);
                System.out.print("\nDame  el tiempo  en  minutos para la preparacion: ");
                tiempo = escribir.nextInt();
                
                    
                Recetas receta2 = new Recetas(nombre,listaIngredientes2, listaPasos2, tiempo);
                    
                    System.out.println("\nSe ha modificado la receta: "+listaReceta.get(modificar-1));
                    listaReceta.set(modificar-1, receta2);
                    
                    
                    ruta = "recetas/recetas.ser";
                    
                    //Guardamos la receta en nuestra carpeta
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){
                        oos.writeObject(listaReceta);  // Serializa la lista completa
                        System.out.println("\nRecetas guardadas en " + ruta);
                    }catch (IOException e) {
                        System.out.println("\nError al guardar: " + e.getMessage());
                    }
                }
                }
                break;
            case 4:
                contador2=0;
                System.out.println("\nLas recetas que hay guardadas son:");
                
                for(int i=0; i<(listaReceta.size()+2)/3;i++){
                  
                    for (int j = 0; j < 3; j++) {
                        int index = i * 3 + j;
                    if (index < listaReceta.size()) {
                        System.out.printf("%3d. %-40s", index + 1, listaReceta.get(index).getnombre());
                    } else {
                        System.out.print("                                                                 "); // 3 (número) + 1 (punto) + 40 (nombre) + 1 (espacio extra)
                    }
                    
                    
                }
                    System.out.println();//Salto de linea en cada uno
                    
                }
                System.out.println();
                
                
              
                int eliminar=0;
                while(true){
                    try{
                        System.out.print("Elija el numero de la receta que quiera eliminar (Si no quieres eliminar nada, "
                        + "introduce 0): ");
                        eliminar = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                if(eliminar==0){
                    System.out.println("\nNo se ha eliminado ninguna receta \n");
                }else{
                    if(eliminar-1>listaReceta.size()&&eliminar-1<-1){
                        System.out.println("\nEl numero de rango para las recetas no existe coge un numero que este dentro del rango de recetas\n");
                    }else{
                    System.out.println("\nSe ha eliminado la receta: "+listaReceta.get(eliminar-1).getnombre()+"\n");
                    listaReceta.remove(eliminar-1);
                    
                    
                    ruta = "recetas/recetas.ser";
                    
                    //Guardamos la receta en nuestra carpeta
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){
                        oos.writeObject(listaReceta);  // Serializa la lista completa
                        System.out.println("\nRecetas guardadas en " + ruta);
                    }catch (IOException e) {
                        System.out.println("\nError al guardar: " + e.getMessage());
                    }
                   
                    }
                }
                break;
            case 5:
                
                System.out.print("Busca el alimento que quieras: ");
                String  busquedaalimentos =escribir.nextLine();
                
                ArrayList<String> buscaralimento = new ArrayList<>();
                ArrayList<String> nombresalimentos = new ArrayList<>();
                ArrayList<String> listarepetidos = new ArrayList<>();
                
                for(int i=0;i<listaReceta.size();i++){
                    
                    
                    for(int j=0;j<listaReceta.get(i).getingredientes().size();j++){
                        
                        if ((listaReceta.get(i).getingredientes().get(j).toLowerCase().contains(busquedaalimentos.toLowerCase()))==true){
                           buscaralimento.add(listaReceta.get(i).getingredientes().get(j));
                           nombresalimentos.add(listaReceta.get(i).getnombre());
                           
                        }
                    }
                }
                
                for(int i=0;i<buscaralimento.size();i++){
                    if(listarepetidos.contains(buscaralimento.get(i))==false){
       
                        listarepetidos.add(buscaralimento.get(i));
                        //estamos poniendo los elementos en una lista para que por codigo solo se muestre una vez los alimentos pero nuestra lista si contiene
                        // todos estos alimentos con la receta de la que procede 
                    }
                    
                }
                if (listarepetidos.size()==0){
                    System.out.println("\nNo hay ingredientes que coincidan con su busqueda");
                }else{
                    System.out.println("\nElige el alimento que buscas:\n");
                    for(int i=0;i<listarepetidos.size();i++){
                        System.out.println((i+1)+". "+listarepetidos.get(i));
                    }
                     
                    
                    int numero =0;
                    
                    
                    while(true){
                        
                    try{
                        System.out.print("\nElige un numero: ");
                        numero = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                    
                    if(numero-1>listaReceta.size()&&numero-1<0){
                    System.out.println("\nEl numero de rango para las recetas no existe coge un numero que este dentro del rango de recetas\n");
                    }else{
                    
                    System.out.println("Las recetas que contienen al ingrediente: "+buscaralimento.get(numero-1)+"\n");
                    int j=0;
                    for(int i=0;i<buscaralimento.size();i++){
                        
                        if(buscaralimento.get(i).toLowerCase().equalsIgnoreCase(buscaralimento.get(numero-1).toLowerCase())){
                            System.out.println((j+1)+". "+ nombresalimentos.get(i));
                            j++;
                        }

                    }
                }
                }
                System.out.println();
            break;
            case 6:
                
                ArrayList<String> listanombres = new ArrayList<>(); 
                
                System.out.println("Para buscar las recetas el tiempo que nos des,"
                        + " saldran las recetas que duren este tiempo o mas en realizarse");
                
                int tiempominutos = 0;
               
           
                
                  while(true){
                        
                    try{
                        System.out.print("Dame el tiempo(en minutos) que quieres buscar para la receta: ");
                       
                        tiempominutos = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                
                for(int i=0;i<listaReceta.size();i++){
                    if(listaReceta.get(i).gettiempo()>=tiempominutos){
                        
                        listanombres.add(listaReceta.get(i).getnombre());
                    } 
                }
                if(listanombres.size()==0){
                    System.out.println("No hay recetas que cumplan con el tiempo introducido\n");
                }else{
                    System.out.println("Las recetas que tienen un tiempo mayor que "+tiempominutos+" minutos son: \n");
                    for(int i=0; i<listanombres.size();i++){
                   System.out.println((i+1)+". "+listanombres.get(i));
                    }
                }
                System.out.println();
                break;
            case 7:
                
                   System.out.print("Busca el alimento que quieras: ");
                busquedaalimentos =escribir.nextLine();
                
                ArrayList<String> buscaralimento2 = new ArrayList<>();
                ArrayList<String> nombresalimentos2 = new ArrayList<>();
                ArrayList<String> listarepetidos2 = new ArrayList<>();
                
                System.out.println("\nPara buscar las recetas el tiempo que nos des,"
                        + " saldran las recetas que duren este tiempo o mas en realizarse");
               
                  while(true){
                        
                    try{
                        System.out.print("Dame el tiempo(en minutos) que quieres buscar para la receta: ");
                       
                        tiempominutos = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                
                for(int i=0;i<listaReceta.size();i++){
                    
                    
                    for(int j=0;j<listaReceta.get(i).getingredientes().size();j++){
                        
                        if ((listaReceta.get(i).getingredientes().get(j).toLowerCase().contains(busquedaalimentos.toLowerCase()))==true){
                           if(listaReceta.get(i).gettiempo()>=tiempominutos){
                                buscaralimento2.add(listaReceta.get(i).getingredientes().get(j));
                                nombresalimentos2.add(listaReceta.get(i).getnombre());
                           }
                        }
                    }
                }
                
                for(int i=0;i<buscaralimento2.size();i++){
                    if(listarepetidos2.contains(buscaralimento2.get(i))==false){
       
                        listarepetidos2.add(buscaralimento2.get(i));
                        //estamos poniendo los elementos en una lista para que por codigo solo se muestre una vez los alimentos pero nuestra lista si contiene
                        // todos estos alimentos con la receta de la que procede 
                    }
                    
                }
                if (listarepetidos2.size()==0){
                    System.out.println("\nNo hay ingredientes que coincidan con su busqueda");
                }else{
                    System.out.println("\nElige el alimento que buscas:\n");
                    for(int i=0;i<listarepetidos2.size();i++){
                        System.out.println((i+1)+". "+listarepetidos2.get(i));
                    }
                  

                    System.out.println();
                    
                    int numero = 0;
                    
                      while(true){
                        
                    try{
                        System.out.print("\nElige un numero: ");
                        numero = escribir.nextInt();
                        escribir.nextLine();
                        System.out.println();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: Por favor, ingresa un número entero válido.");
                        escribir.nextLine();
                            }
                    }
                    
                    if(numero-1>listaReceta.size()&&numero-1<0){
                    System.out.println("\nEl numero de rango para las recetas no existe coge un numero que este dentro del rango de recetas\n");
                    }else{
                        System.out.println("Las recetas que contienen al ingrediente: "+buscaralimento2.get(numero-1)+"\n");
                        int j=0;
                    for(int i=0;i<buscaralimento2.size();i++){
                        
                        if(buscaralimento2.get(i).toLowerCase().equalsIgnoreCase(buscaralimento2.get(numero-1).toLowerCase())){
                            System.out.println((j+1)+". "+ nombresalimentos2.get(i));
                            j++;
                        }

                    }
                }
                }
                System.out.println();
                break;
            
            case 8:
                
                salida=false;
            break;
        }
        }while(salida==true);
           
    
    }   
}
