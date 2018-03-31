/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import domain.Persona;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Cefnar
 */
public class PersonaJDBC {
    //Nos apoyamos de la llave primaria autoincremente de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un PreparedStatement por lo que podemos 
    //utilizar parametros (signos ?)
    //los cuales posteriormente seran sustituidos por los parametros respectivos 
    
    private final String  SQL_INSERT = "INSERTO INTO persona(nombre, apellido) VALUES (?,?)";
    private final String  SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?";
    private final String  SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    private final String  SQL_SELECT = "SELECT id_persona, nombre, apellido FROM persona ORDER BY id_persona";
    
    public int insert(String nombre, String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; //no se utiliza en este ejercicio
        
        int rows = 0; //Para ver el numero de registros (filas) afectados
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1; //indicando el numero columna 
            stmt.setString(index++, nombre);// param 1 => ?
            stmt.setString(index++, apellido);// param 2 => ?
            System.out.println("Ejecutando Query: " + SQL_INSERT);
            rows = stmt.executeUpdate();//cargando numeros de registros afectados
            System.out.println("Registros afectados: " +  rows);
        
        }catch(SQLException e){
            e.printStackTrace();
            
        }finally{
            //si hubo un error se va a catch, y luego todavia pasa aqui para cerrar la conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows; //Enviamos el numero de registros (filas) afectadas
        
    
    }//End Insert
    
    public int update(int id_persona, String nombre, String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            stmt.setInt(index, id_persona);
            rows = stmt.executeUpdate();
            System.out.println("Registros Actualizados: " +  rows);
        
        }catch(SQLException e){
            e.printStackTrace();
        
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        
        } 
        
        return rows;
  
    }//End update
    
    public int delete(int id_persona){
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_persona);
            rows = stmt.executeUpdate();
            System.out.println("Registros Eliminados: " + rows);
      
        }catch(SQLException e){
            e.printStackTrace();
        
        }finally{
        
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    
    
    }//End Delete
    
    public List<Persona> select (){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            
            }//End while
        
        }catch(SQLException e){
            e.printStackTrace();
        
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        
        }
        return personas;
        
    
    
    
    
    }//End Select Persona    
    
    
    
    
    
    
    
}
