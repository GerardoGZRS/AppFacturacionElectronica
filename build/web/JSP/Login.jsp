<%-- 
    Document   : Login
    Created on : 12/08/2015, 01:32:53 AM
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
        <h1>Acceso de Empresa</h1>
        <fieldset style="width: 300px; height: 200px; border-radius: 7px;">
            <form method="post" action="ValidarEmpresa.jsp">
            <br>
            RFC:
            <br>
            <input type="text" id="rfc" name="rfc" size="40" placeholder="RFC" required=""/>
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
