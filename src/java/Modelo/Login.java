/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author JAANP
 */
public class Login {
    public Boolean Empresa(String rfc, String contrasenia){
        try{
        boolean estado= false;
        Conexion con= new Conexion();
        Connection c=con.getConexion();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select rfc, contrasenia from empresa where rfc='"+rfc+"' AND contrasenia='"+contrasenia+"'");
        while(rs.next()){
                estado= true;
            }
            if(estado){
                return estado;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public Boolean Administrador(String correo, String contrasenia){
        try{
        boolean estado= false;
        Conexion con= new Conexion();
        Connection c=con.getConexion();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select correo, contrasenia from empresa where correo='"+correo+"' AND contrasenia='"+contrasenia+"' AND cargo=Administrador general");
        while(rs.next()){
                estado= true;
            }
            if(estado){
                return estado;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public Boolean Empleado(String correo, String contrasenia){
        try{
        boolean estado= false;
        Conexion con= new Conexion();
        Connection c=con.getConexion();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select correo, contrasenia from empresa where correo='"+correo+"' AND contrasenia='"+contrasenia+"' AND cargo=Empleado");
        while(rs.next()){
                estado= true;
            }
            if(estado){
                return estado;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
