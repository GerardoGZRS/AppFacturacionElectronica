/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
/**
 *
 * @author FORZEN
 */
public class Conexion {
    
    private Connection con = null;
    
    public Conexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/factufacil","root","");
   
    }catch(Exception ex){
        ex.printStackTrace();
    }    
    }
    public Connection getConexion(){
        return con;
    }
    public void cerrarConexion(){
        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
