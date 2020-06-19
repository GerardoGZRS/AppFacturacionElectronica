<%-- 
    Document   : LoginEmpleado
    Created on : 13/08/2015, 01:24:13 PM
    Author     : JAANP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

</head>
    <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
    <center>
        <br>
        <br>
        <br>
        <h1>Acceso de Empleado</h1>
        <fieldset style="width: 300px; height: 200px; border-radius: 7px;">
            <form method="post" action="ValidarEmpleado.jsp">
            <br>
            Correo:
            <br>
            <input type="text" id="correo" name="correo" size="40" placeholder="Correo" required=""/>
            <br>
            Contraseña:
            <br>
            <input type="password" id="pass" name="pass" size="40" placeholder="Contraseña" required=""/>
            <br>
            <br>
            <input type="submit" id="btnenviar" name="btnenviar" value="Entrar"/>
            
        </form>
            <br>
            <form method="post" action="../index.html">
                <input type="submit" name="btnenviar" value="Cancelar" />
            </form>
            </fieldset>
    </center>
    </body>
</html>