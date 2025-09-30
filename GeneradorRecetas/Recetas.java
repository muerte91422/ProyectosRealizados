/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creadorrecetas;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Hermi
 */
public class Recetas implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private ArrayList<String> ingredientes;
    private ArrayList<String> pasos;
    private int tiempo;
    
    public Recetas(String nombre, ArrayList<String> ingredientes, ArrayList<String> pasos, int tiempo){
        this.nombre = nombre;
        this.ingredientes = ingredientes;//ArrayList con el valor ya definido antes
        this.pasos = pasos;////ArrayList con el valor ya definido antes
        this.tiempo = tiempo;
        
    }
    
    public void setnombre(String nombre){
        this.nombre = nombre;
   
    }
    public String getnombre(){
        return nombre;
    }
    
    public ArrayList<String> getingredientes(){
        return ingredientes;
    }
    
    public ArrayList<String> getpasos(){
        return pasos;
    }
     public void settiempo(int tiempo){
        this.tiempo = tiempo;
   
    }
    public int gettiempo(){
        return tiempo;
    }
    
    
}
