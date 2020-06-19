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
public class Receptor {
     private static Conexion con;
    private String Rfc;
    private String Razon_Social;
    private String Calle;
    private String No_Int;
    private String No_Ext;
    private String Colonia;
    private String C_P;
    private String Municipio;
    private String Estado;
    private String Pais;

    public Receptor(String Rfc, String Razon_Social, String Calle, String No_Int, String No_Ext, String Colonia, String C_P, String Municipio, String Estado, String Pais) {
        this.Rfc = Rfc;
        this.Razon_Social = Razon_Social;
        this.Calle = Calle;
        this.No_Int = No_Int;
        this.No_Ext = No_Ext;
        this.Colonia = Colonia;
        this.C_P = C_P;
        this.Municipio = Municipio;
        this.Estado = Estado;
        this.Pais = Pais;
    }
    
    public Receptor(){
        this.Rfc = "";
        this.Razon_Social = Razon_Social;
        this.Calle = Calle;
        this.No_Int = No_Int;
        this.No_Ext = No_Ext;
        this.Colonia = Colonia;
        this.C_P = C_P;
        this.Municipio = Municipio;
        this.Estado = Estado;
        this.Pais = Pais;
    }
    //Metodo para insertar
    
public String guardar() {
    String sql = "INSERT INTO receptor(Rfc_Rec, Nombre, Calle, No_Int, No_Ext,"
            + "Colonia, C_P, Municipio, Estado, Pais) values ('"+ Rfc +"', '"+ Razon_Social +"', '"+ Calle +"', " + No_Int + ", " + No_Ext + ","
            + "'"+Colonia+"', '"+ C_P +"', '"+Municipio+"', '" + Estado + "', '" + Pais + "');";
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
    //Nos regresara los datos del receptor de acuerdo a un parametro a la factura
    
 public static String ReceptorDatos(String parametro){
    ResultSet data;
    String htmlTable;

    String consulta = "SELECT * from receptor  natural join factura where folio_fiscal='"+parametro+"' ";
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
                 + "" + data.getInt(7) + " "
                 + "" + data.getString(8) + " "
                 + "" + data.getString(9) + " "
                 + "" + data.getString(10) + " "
                 + "\n" + data.getString(1) + " "; 


   }
    table += "";
    
    return table;
}
}
