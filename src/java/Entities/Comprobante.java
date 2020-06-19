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
 * @author DIN
 */
public class Comprobante {
    
    private static Conexion con;
    private String id_comprobante;
    private String concepto;
    private String valorUnitario;
    private String descripcion;
    private String unidad;
    private String cantidad;
    private String IEPS;
    private String Subtotal;
    private String Iva;
    private String Total;

    public Comprobante(String id_comprobante, String concepto, String valorUnitario, String descripcion, String unidad, String cantidad, String IEPS, String Subtotal, String Iva, String Total) {
        this.id_comprobante = id_comprobante;
        this.concepto = concepto;
        this.valorUnitario = valorUnitario;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.IEPS = IEPS;
        this.Subtotal = Subtotal;
        this.Iva = Iva;
        this.Total = Total;
    }
    
   public Comprobante() {
        this.id_comprobante = "";
        this.concepto = "";
        this.valorUnitario = "";
        this.descripcion = "";
        this.unidad = "";
        this.cantidad = "";
        this.IEPS = "";
        this.Subtotal = "";
        this.Iva = "";
        this.Total = "";
    } 
    public String save(){
        String sql = "INSERT INTO comprobante(id_comprobante, concepto_importe, valorUnitario, descripcion, unidad, cantidad,"
            + "IEPS, Subtotal, Iva, Total) values ('"+ id_comprobante +"', '"+ concepto +"', '"+ valorUnitario + "', '"+ descripcion +"', '" + unidad + "', '" + cantidad + "',"
            + "'"+IEPS+"', '"+ Subtotal +"' , '"+Iva+"', '" + Total + "');";
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
    
    public static String llenarCombo(){
   ResultSet data;
    String htmlTable;
    String consulta = "select * from comprobante";
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
    String table="<select name=\"comboComprobante\" id=\"comboComprobante\">"
            + "<option value=\"\">Seleccione...</option>";
    while(data.next()){
        table +=""
                + "<option value="+data.getInt(1)+">"+data.getInt(1)+"</option>";



       


   }
    table += "</select>";
    
    return table;
}
  public static String llenarCombo1(){
   ResultSet data;
    String htmlTable;
    String consulta = "select * from comprobante";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printCombo1(data);
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
private static  String printCombo1(ResultSet data)
                throws SQLException{
    String table="PdfPTable table = new PdfPTable(5);"
            + "table.addCell(\"Cantidad\");\n" +
"            table.addCell(\"Unidad de medida\");\n" +
"            table.addCell(\"Descripción\");\n" +
"            \n" +
"            table.addCell(\"Precio unitario\");\n" +
"            table.addCell(\"Importe\");";
    while(data.next()){
        table +=""
                + "table.addCell(\"\");\n" +
"            table.addCell(\"\");\n" +
"            table.addCell(\"\");\n" +
"            table.addCell(\"\");\n" +
"            table.addCell(\"celda 10\");"
                + ""
                + "dfPCell celdaFinal = new PdfPCell(new Paragraph(\"Total con letra: \"));\n" +
"            \n" +
"            // Indicamos cuantas columnas ocupa la celda\n" +
"            celdaFinal.setColspan(4);\n" +
"            table.addCell(celdaFinal);\n" +
"            table.addCell(\"Subtotal: \");\n" +
"            \n" +
"            PdfPCell celda2 = new PdfPCell(new Paragraph(\"\"));\n" +
"            celda2.setColspan(4);\n" +
"            table.addCell(celda2);\n" +
"            table.addCell(\"Iva: \");";



       


   }
    
    return table;
    
}

public static String tabla(){
    String tabla = "<table><tr><td>hola</td></tr></table>";
    return tabla;
}
//consulta

}


