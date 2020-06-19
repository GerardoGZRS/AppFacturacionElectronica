<%-- 
    Document   : ADMmostrarDatos
    Created on : 12/08/2015, 02:30:13 AM
    Author     : JAANP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.BeanEmpleado" %>
<%@page import="Modelo.Empleado" %>
<%@page import="Modelo.Conexion" %>
<%
try{
Conexion con=new Conexion();
Connection c=con.getConexion();
Statement st=c.createStatement();
String consulta="SELECT nombre, paterno, materno, especialidad, cargo, correo, contrasenia FROM EMPLEADO WHERE idempleado=1;";
ResultSet rs=st.executeQuery(consulta);
while(rs.next()){
    String nombre=rs.getString(1);
    String paterno=rs.getString(2);
    String materno=rs.getString(3);
    String especialidad=rs.getString(4);
    String cargo=rs.getString(5);
    String correo=rs.getString(6);
    String contrasenia=rs.getString(7);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
        <fieldset style="width: 1000px;">
            <legend>Datos del Administrador General</legend>
            <div style="margin: auto">
        <label>Nombre:</label>
        <input type="text" name="nombre" id="nombre" style="margin-left: 70px;" value="<%=nombre%>">
        <label style="margin-left: 10px;">Cargo:</label>
        <input type="text" name="cargo" id="cargo" style="margin-left: 55px;" value="<%=cargo%>">
        <label style="margin-left: 10px;">Correo Electronico:</label>
        <input type="text" name="correo" id="correo" value="<%=correo%>">
        <br>
        <br>
        <label>Apellido Paterno:</label>
        <input type="text" name="paterno" id="paterno" style="margin-left: 14px;" value="<%=paterno%>">
        <label style="margin-left: 10px;">Especialidad:</label>
        <input type="text" name="especialidad" id="especialidad" style="margin-left: 12px;" value="<%=especialidad%>">
        <br>
        <br>
        <label>Apellido Materno:</label>
        <input type="text" name="materno" id="materno" style="margin-left: 10px;" value="<%=materno%>">
        <label style="margin-left: 10px;">Contraseña:</label>
        <input type="text" name="contrasenia" id="contrasenia" style="margin-left: 20px;" value="<%=contrasenia%>">
        </div>
        </fieldset>
        <!--
        <%
        
}
}catch(Exception ex){
    ex.printStackTrace();
}
        %>
        <%
        try{
Conexion con=new Conexion();
Connection c=con.getConexion();
Statement st=c.createStatement();
String consulta="SELECT rfc, municipio, UPPER(nomempresa), estado, calle, telefono, colonia, correo FROM EMPRESA WHERE idempresa=1;";
ResultSet rs=st.executeQuery(consulta);
while(rs.next()){
    String rfc=rs.getString(1);
    String municipio=rs.getString(2);
    String nombre=rs.getString(3);
    String estado=rs.getString(4);
    String calle=rs.getString(5);
    String telefono=rs.getString(6);
    String colonia=rs.getString(7);
    String correo=rs.getString(8);
        %>
        <fieldset style="width: 1000px;">
            <legend>Datos de la empresa</legend>
            <div style="margin: auto">
        <label>RFC:</label>
        <input type="text" name="rfc" id="rfc" style="margin-left: 135px;" value="<%=rfc%>">
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
        <%
}
        }catch(Exception ex){
            ex.printStackTrace();
        }
        %>
        -->
    </body>
</html>
