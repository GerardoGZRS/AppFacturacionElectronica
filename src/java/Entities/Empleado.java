/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import BaseDatos.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class Empleado {
    private static Conexion con;
    private String idempleado;
    private String nombre;
    private String paterno;
    private String materno;
    private String especialidad;
    private String cargo;
    private String correo;
    private String contrasenia;
    private String idempresa;

    public Empleado(String idempleado, String nombre, String paterno, String materno, String especialidad, String cargo, String correo,String contrasenia, String idempresa) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.especialidad = especialidad;
        this.cargo = cargo;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.idempresa = idempresa;
    }
    public Empleado() {
        this.idempleado = "";
        this.nombre = "";
        this.paterno = "";
        this.materno = "";
        this.especialidad = "";
        
        this.cargo = "";
        this.correo = "";
        this.contrasenia = "";
        this.idempresa = "";
    }
    
    public String guardar() {
    String sql = "INSERT INTO empleado(idempleado, nombre, paterno, materno, especialidad,"
            + "cargo, correo, contrasenia, Rfc) values ("+idempleado+", '"+nombre+"', '"+paterno+"', '"+materno+"', '"+especialidad+"',"
            + "'"+cargo+"', '"+correo+"', '"+contrasenia+"', '"+idempresa+"');";
    System.out.println(sql);
    try{
    con =  Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        con.updateData(sql);
    } else{
       return "Error: Not conected to DB. "; 
    }
    } catch(ClassNotFoundException ex){
        return "Error: No se cargó el Driver.";
    } catch(SQLException ex){
        return "Error" + ex.getMessage();
    }
    return "Guardado.";
        }
    
    
    
}
