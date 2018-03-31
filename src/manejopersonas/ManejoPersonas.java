/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejopersonas;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.List;




/**
 *
 * @author Cefnar
 */
public class ManejoPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PersonaJDBC personasJDBC = new PersonaJDBC();
        
        //Prueba del metodo insert
        personasJDBC.insert("Alerberto", "Juarez");
        
        //Prueba del metodo update
        personasJDBC.update(2, "nombre3", "apellido3");
        
        //Preuba del metodo delete
        personasJDBC.delete(1);
        
        //Prueba del metodo select
        //USo de un objeto persona para encapsular la informacion 
        //de un registro de la base de datos
        
        List<Persona> personas = personasJDBC.select();
        
        for (Persona persona : personas){
            System.out.print(persona);
            System.out.println("");
        
        }
     
        
    }
    
}
