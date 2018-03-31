/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Cefnar
 */
public class Persona {
    
    private int id_persona;
    private String nombre;
    private String apellido;
    
    public int getId_persona (){
        return id_persona;
    
    }
    
    public void setId_persona (int idPersona){
        id_persona = idPersona;
    
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre (String NuevoNombre){
        nombre = NuevoNombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido (String Apellido){
        this.apellido = Apellido;
    }
    
    
    public String toString(){
        return "Persona{" + "id_persona=" + id_persona + ",nombre=" + nombre + ", apellido=" + apellido + ')';
    
    }
    
    
    
    
    
    
    
}
