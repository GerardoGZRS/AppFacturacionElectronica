<%-- 
    Document   : empresa
    Created on : 13/08/2015, 12:27:46 AM
    Author     : JAANP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
String rfc=request.getParameter("rfc");
try{
    
Conexion con = new Conexion();
Connection c= con.getConexion();
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT UPPER(nomempresa) FROM EMPRESA WHERE rfc='"+rfc+"'");
while(rs.next()){
    String nombre=rs.getString(1);

%>
<!DOCTYPE html>
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
            <li><a href="JSP/EMPMostrarDatos.jsp?rfc=<%=rfc%>">
            Inicio
        </a></li>
        <li><a class="consultaremp" href="html/Factura/ConsultaFactura.html">
         Consultar CDFI
        </a></li>
        <li><a class="generaremp"  href="html/Factura/FormularioComprobante.html">
         Generación de CDFI
        </a></li>
        <li><a href="JSP/MostrarEmpleado.jsp?rfc=<%=rfc%>">
         Empleados 
        </a></li>
        <li><a href="index.html">
         Cerrar Sesión
        </a></li>
       
        </ul>
        </nav>
    </header>

    <div class="contenedor1">
        <h1>Bienvenido<%=" "+nombre%></h1>
    </div>

       </body>
    <%
    
}
    }catch(Exception ex){
        ex.printStackTrace();
    }

    %>    
</html>