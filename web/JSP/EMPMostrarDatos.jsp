<%-- 
    Document   : EMPMostrarDatos
    Created on : 12/08/2015, 05:58:15 AM
    Author     : JAANP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion" %>
<%  
String rfc=request.getParameter("rfc");

        try{
Conexion con=new Conexion();
Connection c=con.getConexion();
Statement st=c.createStatement();
String consulta="SELECT rfc, municipio, UPPER(nomempresa), estado, calle, telefono, colonia, correo FROM EMPRESA WHERE rfc='"+rfc+"'";
ResultSet rs=st.executeQuery(consulta);
while(rs.next()){
    String rfc1=rs.getString(1);
    String municipio=rs.getString(2);
    String nombre=rs.getString(3);
    String estado=rs.getString(4);
    String calle=rs.getString(5);
    String telefono=rs.getString(6);
    String colonia=rs.getString(7);
    String correo=rs.getString(8);
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Factufacil
        </title>
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
        <script type="text/javascript" src="../jquery-2.1.4.min.js"></script>
        <script src="../JS/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="../JS/Resultado.js"></script>
    </head>
    <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
    <header>
        <nav class="menu">
        <ul>
            <li><a class="inicioemp">
            Inicio
        </a></li>
        <li><a class="consultaremp">
         Consultar CDFI
        </a></li>
        <li><a class="generaremp">
         Generación de CDFI
        </a></li>
        <li><a href="MostrarEmpleado.jsp?rfc=<%=rfc%>">
         Empleados 
        </a></li>
        <li><a href="../index.html">
         Cerrar Sesión
        </a></li>
       
        </ul>
        </nav>
    </header>
    <center>
        <div>
        <fieldset style="width: 1000px;">
            <legend>Datos de la empresa</legend>
            <div style="margin: auto">
        <label>RFC:</label>
        <input type="text" name="rfc" id="rfc" style="margin-left: 135px;" value="<%=rfc1%>">
        <label style="margin-left: 10px;">Municipio:</label>
        <input type="text" name="municipio" id="municipio" style="margin-left: 68px;" value="<%=municipio%>">
        <br>
        <br>
        <label>Nombre o Razon social:</label>
        <input type="text" name="nombre" id="nombre" style="margin-left: 14px;" value="<%=nombre%>">
        <label style="margin-left: 10px;">Estado:</label>
        <input type="text" name="estado" id="estado" style="margin-left: 90px;" value="<%=estado%>">
        <br>
        <br>
        <label>Calle:</label>
        <input type="text" name="calle" id="calle" style="margin-left: 130px;" value="<%=calle%>">
        <label style="margin-left: 10px;">Telefono:</label>
        <input type="text" name="telefono" id="telefono" style="margin-left: 80px;" value="<%=telefono%>">
        <br>
        <br>
        <label>Colonia:</label>
        <input type="text" name="colonia" id="colonia" style="margin-left: 110px;" value="<%=colonia%>">
        <label style="margin-left: 10px;">Correo Electronico:</label>
        <input type="text" name="correo" id="correo" style="margin-left: 20px;" value="<%=correo%>">
        </div>
        </fieldset>
        </div>
        </center>
        <%
}
        }catch(Exception ex){
            ex.printStackTrace();
        }
        %>
    </body>
</html>
