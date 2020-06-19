<%-- 
    Document   : inicioempleado
    Created on : 13/08/2015, 01:41:40 PM
    Author     : JAANP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String correo=request.getParameter("correo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
        <script type="text/javascript" src="../jquery-2.1.4.min.js"></script>
        <script src="../JS/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="../JS/Resultado.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <img src="../Imagenes/factufacil.png">
        <nav class="menu">
        <ul>
            <li><a href="EMPMostrarDatos.jsp?correo=<%=correo%>">
            Inicio
        </a></li>
       
        <li><a class="generaremp" href="../html/Factura/FormularioComprobanteEmpleado.html">
         Generación de CDFI
        </a></li>
        
        <li><a>
         Cerrar Sesión
        </a></li>
       
        </ul>
        </nav>
    </header>
      
<%
    
try{
    Conexion con=new Conexion();
    Connection c=con.getConexion();
    Statement st=c.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM empleado WHERE correo='"+correo+"'");
while(rs.next()){
    int id=rs.getInt(1);
    String nombre=rs.getString(2);
    String paterno=rs.getString(3);
    String materno=rs.getString(4);
    String especialidad=rs.getString(5);
    String cargo=rs.getString(6);
    String correo1=rs.getString(7);
    String contrasenia=rs.getString(8);
    String empresa=rs.getString(9);
%>                    
<center>
    <div class="contenedor1">
        <fieldset style="width: 1000px;">
            <legend>Datos del empleado</legend>
            <div style="margin: auto">
        <label>Nombre:</label>
        <input type="text" name="rfc" id="rfc" style="margin-left: 135px;" value="<%=nombre%>">
        <label style="margin-left: 10px;">Apellido paterno:</label>
        <input type="text" name="municipio" id="municipio" style="margin-left: 68px;" value="<%=paterno%>">
        <br>
        <br>
        <label>Apellido materno:</label>
        <input type="text" name="nombre" id="nombre" style="margin-left: 14px;" value="<%=materno%>">
        <label style="margin-left: 10px;">Especialidad:</label>
        <input type="text" name="estado" id="estado" style="margin-left: 90px;" value="<%=especialidad%>">
        <br>
        <br>
        <label>Cargo:</label>
        <input type="text" name="calle" id="calle" style="margin-left: 130px;" value="<%=cargo%>">
        <label style="margin-left: 10px;">Correo:</label>
        <input type="text" name="telefono" id="telefono" style="margin-left: 80px;" value="<%=correo%>">
        <br>
        <br>
        <label>Contraseña:</label>
        <input type="text" name="colonia" id="colonia" style="margin-left: 110px;" value="<%=contrasenia%>">
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