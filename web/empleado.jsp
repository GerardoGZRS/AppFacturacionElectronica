<%-- 
    Document   : empleado
    Created on : 13/08/2015, 01:17:24 PM
    Author     : JAANP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String correo=request.getParameter("correo");
try{
    
Conexion con = new Conexion();
Connection c= con.getConexion();
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT nombre FROM EMPLEADO WHERE correo='"+correo+"'");
while(rs.next()){
    String nombre=rs.getString(1);
%>
<html>
    <head>
        <title>
            Factufacil
        </title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script src="JS/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="JS/Resultado.js"></script>
       
        <meta charset="UTF-8"/>
    </head>  
    <body style="background: #efeff9">
        <img src="Imagenes/factufacil.png">
    <header>
        <nav class="menu">
        <ul>
            <li><a href="JSP/inicioempleado.jsp?correo=<%=correo%>">
            Inicio
        </a></li>
        <li><a href="html/Factura/FormularioComprobanteEmpleado.html">
         Generación de CDFI
        </a></li>
        <li><a href="index.html">
         Cerrar Sesión
        </a></li>
       
        </ul>
        </nav>
    </header>

    <div class="contenedor1">
       <h1>Bienvenid@<%=" "+nombre
    
    %></h1> 
    </div>
    
    <%
}
}catch(Exception ex){
    ex.printStackTrace();
}
    %>
     </body>
</html>