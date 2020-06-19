<%-- 
    Document   : ValidarEmpresa
    Created on : 13/08/2015, 10:09:20 PM
    Author     : JAANP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String rfc=request.getParameter("rfc");
String contrasenia=request.getParameter("pass");

 try{
Conexion con=new Conexion();
Connection c=con.getConexion();
Statement st=c.createStatement();
String consulta="SELECT idempresa, rfc, contrasenia FROM EMPRESA WHERE rfc='"+rfc+"'";
ResultSet rs=st.executeQuery(consulta);
while(rs.next()){
    String idempresa=rs.getString(1);
    String rfc1=rs.getString(2);
    String contrasenia1=rs.getString(3);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
    if(rfc.equals(rfc1) && contrasenia.equals(contrasenia1)){
        response.sendRedirect("../empresa.jsp?rfc="+rfc+"");
    }else{
        %>
        <script>alert("No estas registrado en factufacil")</script>
        <%
        out.println("<center><h1><a href=\"../index.html\">Regresar al inicio</a></h1></center>");
    }
}
 }catch(Exception ex){
     ex.printStackTrace();
 }
 
        %>
    </body>
</html>
