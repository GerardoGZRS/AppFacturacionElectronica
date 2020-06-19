/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import BaseDatos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nuevo
 */
public class Emisor {
    private static Conexion con;
    private String Rfc;
    private String Razon_Social;
    private String Regimen;
    private String Calle;
    private String No_Int;
    private String No_Ext;
    private String Colonia;
    private String C_P;
    private String Municipio;
    private String Estado;
    private String Pais;

    public Emisor(String Rfc, String Razon_Social, String Regimen ,String Calle, String No_Int, String No_Ext, String Colonia, String C_P,String Municipio,  String Estado, String Pais) {
        this.Rfc = Rfc;
        this.Razon_Social = Razon_Social;
        this.Regimen = Regimen;
        this.Calle = Calle;
        this.No_Int = No_Int;
        this.No_Ext = No_Ext;
        this.Colonia = Colonia;
        this.C_P = C_P;
        this.Municipio = Municipio;
        this.Estado = Estado;
        this.Pais = Pais;
    }
    public Emisor() {
        this.Rfc = "";
        this.Razon_Social = "";
        this.Regimen = "";
        this.Calle = "";
        this.No_Int = "";
        this.No_Ext = "";
        this.Colonia = "";
        this.C_P = "";
        this.Municipio = "";
        this.Estado = "";
        this.Pais = "";
    }
    public String guardar() {
    String sql = "INSERT INTO emisor(Rfc, Razon_Social, Regimen, Calle, No_Int, No_Ext, "
            + "Colonia, C_P, Municipio, Estado, Pais) values ('"+ Rfc +"', '"+ Razon_Social +"', '"+ Regimen + "', '"+ Calle +"', '" + No_Int + "', '" + No_Ext + "',"
            + "'"+Colonia+"', "+ C_P +" , '"+Municipio+"', '" + Estado + "', '" + Pais + "');";
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
    //Nos regresara los datos del emisor de acuerdo a un parametro a la factura
    
 public static String EmisorDatos(String parametro){
    ResultSet data;
    String htmlTable;
 
    String consulta = "SELECT * from emisor  natural join factura  where folio_fiscal='"+parametro+"'";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printTable(data);
    }else{
        return "Error: Not conected to DB. ";
    }
    }catch(ClassNotFoundException ex){
        return "Error: Driver not loaded.";
    }
    catch(SQLException ex){
        return "Error: " + ex.getMessage();
    }
        return htmlTable;
}
private static  String printTable(ResultSet data)
                throws SQLException{
    String table="\n";
    while(data.next()){
        table +=""
                
                + "" + data.getString(2) + " "
                + "\n" + data.getString(3) + " "
                + "" + data.getString(4) + " "
                + "" + data.getString(5) + " ";
         table += "\n"
                 + data.getString(6) + " "
                 + data.getString(7) + " "
                 + "" + data.getInt(8) + " "
                 + "" + data.getString(9) + " "
                 + "" + data.getString(10) + " "
                 + "" + data.getString(11) + " "
                 + "\n" + data.getString(1) + " "; 


   }
    table += "";
    
    return table;
}

public static String llenarCombo(){
   ResultSet data;
    String htmlTable;
    String consulta = "select * from emisor";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printCombo(data);
    }else{
        return "Error: Not conected to DB. ";
    }
    }catch(ClassNotFoundException ex){
        return "Error: Driver not loaded.";
    }
    catch(SQLException ex){
        return "Error: " + ex.getMessage();
    }

    return htmlTable;
} 

//nos imprimira un combo con todos los datos 
private static  String printCombo(ResultSet data)
                throws SQLException{
    String table="<select name=\"comboEmisor\" id=\"comboEmisor\">"
            + "<option value=\"\">Seleccione...</option>";
    while(data.next()){
        table +=""
                + "<option value="+data.getString(1)+">"+data.getString(1)+"</option>";



       


   }
    table += "</select>";
    
    return table;
}
}
