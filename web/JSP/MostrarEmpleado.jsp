<%-- 
    Document   : MostrarEmpleado
    Created on : 9/08/2015, 01:42:31 PM
    Author     : JAANP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Conexion;" %>
<%@page import="java.sql.Connection;" %>
<%@page import="java.sql.Statement;" %>
<%@page import="java.sql.ResultSet;" %>
<% 
String rfc=request.getParameter("rfc");
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
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
        <header>
        <nav class="menu">
        <ul>
            <li><a href="EMPMostrarDatos.jsp?rfc=<%=rfc%>">
            Inicio
        </a></li>
        <li><a href="../html/Factura/ConsultaFactura.html">
         Consultar CDFI
        </a></li>
        <li><a href="../html/Factura/FormularioComprobante.html">
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
                    <th></th>
                    <th></th>
                    <th></th>
            </tr>
<%
    
try{
    Conexion con=new Conexion();
    Connection c=con.getConexion();
    Statement st=c.createStatement();
    ResultSet rs=st.executeQuery("SELECT empresa.idempresa, idempleado, nombre, paterno, materno, especialidad, cargo, empleado.correo, empleado.contrasenia, UPPER(nomempresa) FROM empleado inner join empresa on empleado.idempresa=empresa.idempresa WHERE rfc='"+rfc+"'");
while(rs.next()){
    int idE=rs.getInt(1);
    int id=rs.getInt(2);
    String nombre=rs.getString(3);
    String paterno=rs.getString(4);
    String materno=rs.getString(5);
    String especialidad=rs.getString(6);
    String cargo=rs.getString(7);
    String correo=rs.getString(8);
    String contrasenia=rs.getString(9);
    String empresa=rs.getString(10);
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
    <td>
        <a href="../JSP/RegistrarEmpleado.jsp?idEmpre=<%=idE%>">Registar</a>
    </td>
    <td>
        <a href="../JSP/ActualizarEmpleado.jsp?idEmpl=<%=id%>">Actualizar</a>
    </td>

    <td>
        
        <a href="../ServletEliminarEmpleado?idEmpl=<%=id%>">Eliminar</a>

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
