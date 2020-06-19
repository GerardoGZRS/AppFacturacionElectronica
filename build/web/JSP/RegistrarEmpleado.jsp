<%-- 
    Document   : RegistrarEmpleado
    Created on : 11/08/2015, 04:45:25 PM
    Author     : JAANP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String idEmp=request.getParameter("idEmpre");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
       <form method="post" action="../ServletInsertarEmpleado">
        <table>
               
                <tr>
                    <td class="texto">Nombre</td>
                    <td><input type="text" name="nombre" id="nombre" class="caja" required=""></td>
                </tr>
                <tr>
                    <td class="texto">Apellido paterno</td>
                    <td><input type="text" name="paterno" id="paterno" class="caja" required=""></td>
                </tr>
                <tr>
                    <td class="texto">Apellido materno</td>
                    <td><input type="text" name="materno" id="materno" class="caja" required=""></td>
                </tr>
                <tr>
                    <td class="texto">Especialidad</td>
                    <td><input type="text" name="especialidad" id="especialidad" class="caja" required=""></td>
                </tr>
                <tr>
                    <td class="texto">Cargo</td>
                    <td><input type="text" name="cargo" id="cargo" class="caja" required=""></td>
                </tr>
                <tr>
                    <td class="texto">Correo</td>
                    <td><input type="text" name="correo" id="correo" class="caja" required=""></td>
                </tr>
                <tr>
                    <td class="texto">Contraseña</td>
                    <td><input type="password" name="contrasenia" id="contrasenia" class="caja" required=""></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="idEmpre" id="idEmpre" value="<%=idEmp%>"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Guardar">
                    </td>
                </tr>
        </table>
        </form>
    </body>
</html>
