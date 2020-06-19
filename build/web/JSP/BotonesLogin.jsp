<%-- 
    Document   : BotonesLogin
    Created on : 12/08/2015, 10:18:47 AM
    Author     : JAANP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css">
        <title>JSP Page</title>
    </head>
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
    <center>
        <form method="post" action="JSP/Login.jsp">
        <input type="submit" class="botoneslog" value="Empresa">
        </form>
        <form method="post" action="JSP/LoginAdministrador.jsp">
        <input type="submit" class="botoneslog" value="Administrador">
        </form>
        <form method="post" action="JSP/LoginEmpleado.jsp">
        <input type="submit" class="botoneslog" value="Empleado">
        </form>
    </center>
    </body>
</html>
