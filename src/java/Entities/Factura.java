/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import BaseDatos.Conexion;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import java.util.Random;

/**
 *
 * @author nuevo
 */
public class Factura {
    private static Conexion con;
    private String folio_fiscal;
    private int no_SerCertificado;
   private String LugarExpedicion;
   private String Hora_FechaExpedicion;
   private String no_CertDigital;
   private String Hora_FechaCerti;
   private String Rfc;
   private String Rfc_Rec;
   private String id_comprobante;

    public Factura(String folio_fiscal, int no_SerCertificado, String LugarExpedicion, String Hora_FechaExpedicion, String no_CertDigital, String Hora_FechaCerti, String Rfc, String Rfc_Rec, String id_comprobante) {
        this.folio_fiscal = folio_fiscal;
        this.no_SerCertificado = no_SerCertificado;
        this.LugarExpedicion = LugarExpedicion;
        this.Hora_FechaExpedicion = Hora_FechaExpedicion;
        this.no_CertDigital = no_CertDigital;
        this.Hora_FechaCerti = Hora_FechaCerti;
        this.Rfc = Rfc;
        this.Rfc_Rec = Rfc_Rec;
        this.id_comprobante = id_comprobante;
    }


    public Factura() {
        this.folio_fiscal = getCadenaAlfanumAleatoria();
        this.no_SerCertificado = NoSerieCertificado();
        this.LugarExpedicion = "";
        this.Hora_FechaExpedicion = "";
        this.no_CertDigital = "";
        this.Hora_FechaCerti = getFechaHoraCertificacion();
        this.Rfc = "";
        this.Rfc_Rec = "";
        this.id_comprobante = "";
    }

   

    
    
    public static String getCadenaAlfanumAleatoria(){
        int longitud= 10;

String cadenaAleatoria = "";
long milis = new java.util.GregorianCalendar().getTimeInMillis();
Random r = new Random(milis);
int i = 0;
while ( i < longitud){
char c = (char)r.nextInt(255);
if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
cadenaAleatoria += c;
i ++;
}
}
return cadenaAleatoria;


}

    public static String getFechaHoraExpedicion(){
        Calendar fecha = Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
    String CondicionFech=String.valueOf((año+"-"+mes+"-"+dia));
            //Hora
   Calendar calendario = Calendar.getInstance();
   int hora, minutos, segundos;
   hora =calendario.get(Calendar.HOUR_OF_DAY);
minutos = calendario.get(Calendar.MINUTE);
segundos = calendario.get(Calendar.SECOND);
        String formato =  CondicionFech +  " "  + hora + ":"  +minutos + ":" + segundos;
    return  formato;
    }
    
    public static int NoSerieCertificado(){
        int cadena = 0;
        
        Random rnd = new Random();
        for(int i = 1; i<=5; i++){
          cadena = rnd.nextInt();          
        
        }
        return  cadena;
    }

    public static int NoCertDigital(){
        int cadena = 0;

        Random rnd = new Random();
        for(int i = 1; i<=5; i++){
          cadena = rnd.nextInt();

        }
        return  cadena;
    }
    
    public static String getFechaHoraCertificacion(){
        Calendar fecha = Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
    String CondicionFech=String.valueOf((año+"-"+mes+"-"+dia));
            //Hora
   Calendar calendario = Calendar.getInstance();
   int hora, minutos, segundos;
   hora =calendario.get(Calendar.HOUR_OF_DAY);
minutos = calendario.get(Calendar.MINUTE);
segundos = calendario.get(Calendar.SECOND);
        String formato =  CondicionFech +  " "  + hora + ":"  +minutos + ":" + segundos;
    return  formato;
    }

    public static String formulario(){
        String cadena = "<tr><td><label for='txtLE'>Lugar de Expedición: </label></td>"
                + "<td><input type='text' id='txtLE' name='txtLE' required=''></td></tr>"
                + "<tr><td><label for='txtFecha'>Fecha de Expedicion: </label></td>"
                + "<td><input type='text' name='txtFecha' id='txtFecha' value='"+getFechaHoraExpedicion()+"'></td></tr>"
                
                + "<tr>" +
"                        <td><label for='comboEmisor'>Seleccione el Rfc: </label></td>" 
                + "<td><select id=\"comboEmisor\" name=\"comboEmisor\">"
                + "</select></td>"
                + "</tr> "
                + "<tr><td><label for='comboDinamico'>Seleccione el Rfc Receptor: </td>"
                + "<td><select id=\"comboDinamico\" name=\"comboDinamico\">"
                + "</select></td></tr>"
                + "<tr><td><label for='comboComprobante'>Seleccione el id Comprobante: </td>"
                + "<td><select id=\"comboComprobante\" name=\"comboComprobante\">"
                + "</select></td></tr>";
        return  cadena;
    }

    //Lista general
    
    public static String getTable(){
    ResultSet data;
    String htmlTable;
    String consulta = "select folio_fiscal, Rfc_Rec, Nombre, Hora_FechaExpedicion, Hora_FechaCerti from factura natural join receptor";
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
    String table="<form>"
             +"<fieldset>"
            +" <legend>Consulta</legend>"
            + "<table border='1'>"
            + "<tr>"
            + "<th>Folio Fiscal</th><th>Rfc Receptor</th><th>Nombre o Razon Social Receptor</th>"
            + "<th>Fecha de emisión</th>"
            + "<th>Fecha de Certificación</th>"
            + "<th>Generar CFDI</th>"
            + "<th>Generar XML</th>"
            + "</tr>";
    while(data.next()){
        table +="<tr>"
                + "<td>" + data.getString(1)+ "</td> "
                + "<td>" + data.getString(2) + "</td> "
                + "<td>" + data.getString(3) + "</td>"
                + "<td>" + data.getString(4)+ "</td>"
                + "<td>" + data.getString(5) + "</td>"
                
                
                + "<td><button type='submit' value='"+ data.getString(1)+"'  name='btnCFDI' id='btnCFDI' formaction='/Factufacil/FacturaCFDI'>CFDI PDF</button></td>"
                + "<td><button type='submit' value='"+ data.getString(1)+"'  name='btnXML' id='btnXML' formaction='/Factufacil/FacturaXML' title='Para descargar su xml de click derecho a su mouse, y seleccione guardar como'>CFDI XML</button></td>";



         table += "</tr>";


   }
    table += "</table>"
            + "</fielsed>"
            + "</form>";
    
    return table;
}

//Lista por busqueda
    public static String getTableList(String Rfc_Rec){
    ResultSet data;
    String htmlTable;
    String consulta = "select folio_fiscal, Rfc_Rec, Nombre, Hora_FechaExpedicion, Hora_FechaCerti from factura natural join receptor where Rfc_Rec='"+ Rfc_Rec +"'";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printTableList(data);
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

private static  String printTableList(ResultSet data)
                throws SQLException{
    String table="<form>"
             +"<fieldset>"
            +" <legend>Consulta</legend>"
            + "<table border='1'>"
            + "<tr>"
            + "<th>Folio Fiscal</th><th>Rfc Receptor</th><th>Nombre o Razon Social Receptor</th>"
            + "<th>Fecha de emisión</th>"
            + "<th>Fecha de Certificación</th>"
            + "<th>Generar CFDI</th>"
            + "<th>Generar XML</th>"
            + "</tr>";
    while(data.next()){
        table +="<tr>"
                + "<td>" + data.getString(1)+ "</td> "
                + "<td>" + data.getString(2) + "</td> "
                + "<td>" + data.getString(3) + "</td>"
                + "<td>" + data.getString(4)+ "</td>"
                + "<td>" + data.getString(5) + "</td>"
                
                
                + "<td><button type='submit' value='"+ data.getString(1)+ "'  name='btnCFDI' id='btnCFDI' formaction='/Factufacil/FacturaCFDI'>CFDI PDF</button></td>"
                + "<td><button type='submit' value='"+ data.getString(1) +"'  name='btnXML' id='btnXML' formaction='/Factufacil/FacturaXML'>CFDI XML</button></td>";



         table += "</tr>";


   }
    table += "</table>"
            + "</fielsed>"
            + "</form>";
    
    return table;
}
//Cadena original 
public static String CadenaOriginal(){
    String sql="|3.2|2013-12-02T22:18:24|ingreso|PAGO EN UNA SOLA EXHIBICION|1000.00|1160.00|TRANSFERENCIA ELECTRONICA|D.F.,MEXICO|DESCONOCIDO|AAA010101AAA|EMPRESA DEMO|REFORMA|BENITO "
            + "JUAREZ|DISTRITO FEDERAL|MEXICO|34343|PERSONA FISCA|XAXX010101000|PUBLICO EN GENERAL|INSURGENTES|MEXICO|1|CANT|PZA|1000.00|1000.00|IVA|160.00|160.00||~";
    return sql;
}

public static String llenarCombo(){
   ResultSet data;
    String htmlTable;
    String consulta = "select * from receptor";
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
    String table="<select name=\"comboDinamico\" id=\"comboDinamico\">"
            + "<option value=\"\">Seleccione...</option>";
    while(data.next()){
        table +=""
                + "<option value="+data.getString(1)+">"+data.getString(1)+"</option>";



       


   }
    table += "</select>";
    
    return table;
}
//FolioFiscal
//Generara el xml
public static String getXMLFactura(String FolioFiscal){
ResultSet data;
    String htmlTable;
    String consulta = "select * from emisor natural join factura where folio_fiscal='"+ FolioFiscal +"'";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printXMLFactura(data);
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


public static String getCabeceraXML(){
        int noCertificado = NoSerieCertificado();
        String certificado = getCadenaAlfanumAleatoria();
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "<cfdi:Comprobante xmlns:terceros=\"http://www.sat.gob.mx/terceros\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
            + "xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3"
            + " http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd http://www.sat.gob.mx/terceros"
            + "http://www.sat.gob.mx/sitio_internet/cfd/terceros/terceros11.xsd\" noCertificado='"+noCertificado+"' certificado='"+certificado+"'>";
    return xml;
}
private static  String printXMLFactura(ResultSet data)
                throws SQLException{
    String table="";
    while(data.next()){
        table +="<cfdi:Emisor Rfc='"+data.getString(1)+"' Nombre='"+data.getString(2)+"'>"
                + "<cfdi:DomicilioFiscal calle='"+data.getString(4)+"' noExterior='"+data.getString(6)+"' noInterior='"+data.getString(5)+"'"
                + " colonia='"+data.getString(7)+"' municipio='"+data.getString(9)+"' estado='"+data.getString(10)+"' pais='"+data.getString(11)+"' codigoPostal='"+data.getString(8)+"'>"
                + "</cfdi:DomicilioFiscal>"
                + "<cfdi:RegimenFiscal Regimen='"+data.getString(3)+"'></cfdi:RegimenFiscal>"
                + "</cfdi:Emisor>";



    
   }
   
    
    return table;
}
//Receptor

public static String getXMLReceptor(String FolioFiscal){
ResultSet data;
    String htmlTable;
    String consulta = "select * from receptor natural join factura where folio_fiscal='"+ FolioFiscal +"'";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printXMLReceptor(data);
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

private static  String printXMLReceptor(ResultSet data)
                throws SQLException{
    String table="";
    while(data.next()){
        table +="<cfdi:Receptor Rfc='"+data.getString(1)+"' Nombre='"+data.getString(2)+"'>"
                + "<cfdi:Domicilio calle='"+data.getString(4)+"' noExterior='"+data.getString(6)+"' noInterior='"+data.getString(5)+"'"
                + " colonia='"+data.getString(7)+"' municipio='"+data.getString(9)+"' estado='"+data.getString(10)+"' pais='"+data.getString(11)+"' codigoPostal='"+data.getString(8)+"'>"
                + "</cfdi:Domicilio>"
                + "</cfdi:Receptor>";



    
   }
    
    
    return table;
}

public static String printXMLConcepto(String FolioFiscal){
    ResultSet data;
    String htmlTable;
    String consulta = "select * from comprobante natural join factura where folio_fiscal='"+ FolioFiscal +"'";
    try{
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         htmlTable = printXMLConcepto(data);
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

private static  String printXMLConcepto(ResultSet data)
                throws SQLException{
    String table ="";
    while(data.next()){
        table +=
                "<cfdi:Concepto cantidad='"+6+"' unidad='"+5+"' descripcion='"+4+"' valorUnitario='"+4+"' importe='"+3+"'/>";



    
   }
    
    
    
    return table;
}


public static String printXMLComplemento(){
    String complemento = "<cfdi:Complemento>"
            + "<tfd:TimbreFiscalDigital xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" FechaTimbrado=\"2015-07-24T05:40:48\" UUID=\"882AC803-3A3C-4C50-AAAF-8136423ACB38\" "
            + "noCertificadoSAT=\"00001000000301927035\" "
            + "selloCFD=\"tF/sFCYmDuA6pkzkhHM7nLkoCk/L2fTDeu08yz97y6OsQRmtGXgyfdXvalFdms30p215uTS0EfXPDWyrsLtD4jvvfYei5ivcUyS84r0QGJlGCv/Rbp37P6RntLrlqhDCBPnxp76OhsPIoYg9QeAJVl0sOxbeQRDSlY6yu8gKsvo=\" "
            + "selloSAT=\"iHP6pzClawb3aDj7iUC3lfr2aCJsSJIjCcmZAVxFrTIA5lek7eCU1ApYLPO2kNk2WdY8S1XZbnC+AQXGi3SOy+BVJJAa0AKR/1RfKO+RDx3TU6ne/f+0ofpelV8rT0WS/fdt8YD/Lqznbqv0+VU3zbOsGuCnoDgcup2LwjuanNk=\" "
            + "version=\"1.0\""
            + " xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/TimbreFiscalDigital/TimbreFiscalDigital.xsd\"/>"
            + "</cfdi:Complemento>";
    return complemento;
}
public  String guardarFactura(){
    String Fecha, folio_fisc;
    int noSerieCerti, noCerti;
        Fecha = getFechaHoraCertificacion();
        folio_fisc = getCadenaAlfanumAleatoria();
        noSerieCerti = NoSerieCertificado();
        noCerti = NoCertDigital();
    String procedure = "insert into factura(folio_fiscal, no_SerCertificado, LugarExpedicion, Hora_FechaExpedicion, no_CertDigital, Hora_FechaCerti, Rfc, Rfc_Rec, id_comprobante) values('"+folio_fisc+"', "+noSerieCerti+", '"+LugarExpedicion+"', '"+Hora_FechaExpedicion+"',"
            + ""+noCerti+", '"+Fecha+"', '"+Rfc+"', '"+Rfc_Rec+"', '"+id_comprobante+"' )";
    try{
    con =  Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        con.updateData(procedure);
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




