<%-- 
    Document   : ValidarEmpleado
    Created on : 14/08/2015, 09:32:35 AM
    Author     : JAANP
--%>

<%@page import="Modelo.Conexion"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String correo=request.getParameter("correo");
String contrasenia=request.getParameter("pass");
try{
Conexion con=new Conexion();
Connection c=con.getConexion();
Statement st=c.createStatement();
String consulta="SELECT correo, contrasenia FROM EMPLEADO WHERE correo='"+correo+"' AND cargo='Empleado'";
ResultSet rs=st.executeQuery(consulta);
while(rs.next()){
    String correo1=rs.getString(1);
    String contrasenia1=rs.getString(2);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
    if(correo.equals(correo1) && contrasenia.equals(contrasenia1)){
        response.sendRedirect("../empleado.jsp?correo="+correo+"");
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
