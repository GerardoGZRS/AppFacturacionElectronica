<%-- 
    Document   : ADMMostrarEmpleado
    Created on : 12/08/2015, 05:48:03 AM
    Author     : JAANP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Conexion;" %>
<%@page import="java.sql.Connection;" %>
<%@page import="java.sql.Statement;" %>
<%@page import="java.sql.ResultSet;" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
        <table border="1">
            <tr>
                    <th>Id empleado</th>
                    <th>Nombre</th>
                    <th>Paterno</th>
                    <th>Materno</th>
                    <th>Especialidad</th>
                    <th>Cargo</th>
                    <th>Correo</th>
                    <th>Contraseña</th>
                    <th>Empresa</th>
            </tr>
<%
try{
    Conexion con=new Conexion();
    Connection c=con.getConexion();
    Statement st=c.createStatement();
    ResultSet rs=st.executeQuery("SELECT idempleado, nombre, paterno, materno, especialidad, cargo, empleado.correo, empleado.contrasenia, UPPER(nomempresa) FROM empleado inner join empresa on empleado.idempresa=empresa.idempresa");
while(rs.next()){
    int id=rs.getInt(1);
    String nombre=rs.getString(2);
    String paterno=rs.getString(3);
    String materno=rs.getString(4);
    String especialidad=rs.getString(5);
    String cargo=rs.getString(6);
    String correo=rs.getString(7);
    String contrasenia=rs.getString(8);
    String empresa=rs.getString(9);
%>                    
<tr>
    <td>
    <%= 
    id
    %>
    </td> 
    <td>
    <%= 
    nombre
    %>
    </td>
    <td>
    <%= 
    paterno
    %>
    </td> 
    <td>
    <%= 
    materno
    %>
    </td> 
    <td>
    <%= 
    especialidad
    %>
    </td> 
    <td>
    <%= 
    cargo
    %>
    </td>
    <td>
    <%= 
    correo
    %>
    </td> 
    <td>
    <%= 
    contrasenia
    %>
    </td> 
     <td>
    <%= 
    empresa
    %>
    </td>
    
</tr>      
    <%
}

}catch(Exception ex){
    ex.printStackTrace();
}
%>
        </table>

    </body>
</html>

