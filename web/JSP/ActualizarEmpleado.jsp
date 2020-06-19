<%--
    Document   : ActualizarEmpleado
    Created on : 9/08/2015, 02:42:44 PM
    Author     : JAANP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.BeanEmpleado" %>
<%@page import="Modelo.Empleado" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css">
        <title>JSP Page</title>
    </head>
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
        <%
        String idemp=request.getParameter("idEmpl");
   String nombre="";
   String paterno="";
   String materno="";
   String especialidad="";
   String cargo="";
   String correo="";
   String contrasenia="";
   String idempresa="";
   int id=0;
   
   if(idemp!=null){
       if(Integer.parseInt(idemp)==0){
           id=0;
           
       }else{
            BeanEmpleado emple = Empleado.Buscarempresa(Integer.parseInt(idemp));
   if(emple== null){
    out.println("No se encontro el registro");
       }else{
       id=emple.getIdEmpleado();
       nombre=emple.getNombre();
       paterno=emple.getPaterno();
       materno=emple.getMaterno();
       especialidad=emple.getEspecialidad();
       cargo=emple.getCargo();
       correo=emple.getCorreo();
       contrasenia=emple.getContrasenia();
       idempresa=Integer.toString(emple.getIdEmpresa());
       }
   }
   }
        %>
        <form method="post" action="../ServletActualizarEmpleado">
        <table>
                <tr>
                    <td><input type="hidden" name="idEmple" id="idEmple" value="<%=idemp%>"></td>
                </tr>
                <tr>
                    <td class="texto">Nombre</td>
                    <td><input type="text" name="nombre" id="nombre" value="<%=nombre%>" class="caja"></td>
                </tr>
                <tr>
                    <td class="texto">Apellido paterno</td>
                    <td><input type="text" name="paterno" id="paterno" value="<%=paterno%>" class="caja"></td>
                </tr>
                <tr>
                    <td class="texto">Apellido materno</td>
                    <td><input type="text" name="materno" id="materno" value="<%=materno%>" class="caja"></td>
                </tr>
                <tr>
                    <td class="texto">Especialidad</td>
                    <td><input type="text" name="especialidad" id="especialidad" value="<%=especialidad%>" class="caja"></td>
                </tr>
                <tr>
                    <td class="texto">Cargo</td>
                    <td><input type="text" name="cargo" id="cargo" value="<%=cargo%>" class="caja"></td>
                </tr>
                <tr>
                    <td class="texto">Correo</td>
                    <td><input type="text" name="correo" id="correo" value="<%=correo%>" class="caja"></td>
                </tr>
                <tr>
                    <td class="texto">Contraseña</td>
                    <td><input type="text" name="contrasenia" id="contrasenia" value="<%=contrasenia%>" class="caja"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="idEmpre" id="idEmpre" value="<%=idempresa%>"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Guardar">
                    </td>
                </tr>
                
        </table>
                
        </form>
                <br>
                <br>
                <form method="post" action="../empresa.jsp">
                    <input type="submit" value="cancelar">
                </form>
    </body>
</html>
