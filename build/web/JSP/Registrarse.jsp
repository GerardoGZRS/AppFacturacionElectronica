<%--
    Document   : Registrarse
    Created on : 19/07/2015, 02:53:57 PM
    Author     : JAANP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
        <script type="text/javascript" src="../JS/Validaciones.js"></script>
    </head>
      <body style="background: #efeff9">
        
        <form method="POST" action="ServletInsertarEmpresa">
            <h1>Contratar</h1>
            <fieldset>
              <label>*Nombre de la empresa:</label>
             <input type="text" name="idE" id="idE" placeholder="Identificador" size="44" required=""/>
		<br>
			<br>
                        <label>*Nombre de la empresa:</label>
                        <input type="text" name="Empresa" onkeypress="return soloLetras(event)" id="Empresa" placeholder="Nombre dela empresa" size="44" required=""/>
			<br>
			<br>
			<label>*Razon Social:</label>
                        <input type="text" name="Razon" onkeypress="return soloLetras(event)" id="Razon" placeholder="Razon Social" size="44" required=""/>
			<br>
			<br>
			 <label>*R.F.C.(en mayusculas y sin guiones ni espacios):</label> 
                         <input type="text" name="RFC" id="RFC" placeholder="RFC" size="44" title="El Rfc tiene que llevar 4 letras en mayuscula y 6 digitos" required="" pattern="[A-Z]{4}[0-9]{6}"/>
			<br />
			<br />
 			<label>*Regimen al que pertenece(tal y como esta en su cedula Fiscal):</label>
                        <input type="text" name="Regimen" onkeypress="return soloLetras(event)" id="Regimen" placeholder="Regimen al que pertenece" size="44" required=""/>
			<br />
			<br />
			<label>*Calle:</label>
                        <input type="text" name="Calle" onkeypress="return soloLetras(event)" id="Calle" placeholder="Calle" size="44" required=""/>
			<br />
			<br />
                        <label>*Numero Exterior:</label>
                        <input type="text" name="Exterior" onkeypress="return justNumbers(event);" id="Exterior" placeholder="Numero Exterior" required=""/>
                        <label>*Numero Interior:</label>
                        <input type="text" name="Interior" onkeypress="return justNumbers(event);" id="Interior" placeholder="Numero Interior" required=""/>
			<br />
			<br />
			<label>*Colonia:</label>
                        <input type="text" name="Colonia" onkeypress="return soloLetras(event)" id="Colonia" placeholder="Colonia" required=""/>
                        <label>*Codigo Postal:</label>
                        <input type="text" name="Codigo" onkeypress="return justNumbers(event);" id="Codigo" placeholder="Codigo" required="" onkeyup="codigo()"/>
			<br />
			<br />
			<label>*Estado:</label>
                        <select name="Estado" id="Estado" required="">
				<option>==Seleccione un Estado==</option>
                                <option>Aguascalientes</option>
				<option>Baja California</option>
				<option>Baja California Sur</option>
                                <option>Campeche</option>
				<option>Coahuila de Zaragoza</option>
				<option>Colima</option>
				<option>Chiapa</option>
				<option>Chihuahua</option>
				<option>Distrito Federal</option>
				<option>Durango</option>
				<option>Guanajuato</option>
				<option>Guerrero</option>
				<option>Hidalgo</option>
				<option>Jalisco</option>
				<option>México</option>
				<option>Michoacan de Ocampo</option>
				<option>Morelos</option>
				<option>Nayarit</option>
				<option>Nuevo León</option>
				<option>Oaxaca</option>
				<option>Puebla</option>
				<option>Queretaro</option>
				<option>Quintana Roo</option>
				<option>San Luis Potosil</option>
				<option>Sinaloa</option>
				<option>Tabasco</option>
				<option>Tamaulipas</option>
				<option>Tlaxcala</option>
				<option>Veracruz de Ignacio de la Llave</option>
				<option>Yucatan</option>
				<option>Zacatecas</option>
                        </select>
         		<label>*Municipio:</label>
                        <input type="text" onkeypress="return soloLetras(event)" name="Municipio" id="Municipio" placeholder="Municipio" required=""/>
                       <br><br>
                        	<label>*Paquete de Folios:</label>
                                <select name="Paquete" id="Paquete" required="">
				<option>==Seleccione un Paquete==</option>
                                <option>CFDI-50</option>
				<option>CFDI-100</option>
				<option>CFDI-200</option>
				<option>CFDI-300</option>
				<option>CFDI-400</option>
				<option>CFDI-500</option>
				<option>CFDI-800</option>
				<option>CFDI-1000</option>
				<option>CFDI-2000</option>
				<option>CFDI-3000</option>
				<option>CFDI-5000</option>
				<option>CFDI-10000</option>
			</select>
       
            </fieldset>
            <br>
            
            <fieldset>
            <legend>Datos de Contacto</legend>
            
<br><br>
			<label>*Nombre Completo(Persona a Contactar):</label>
                        <input type="text" onkeypress="return soloLetras(event)" name="Nombre" id="Nombre" placeholder="Nombre" size="44" required=""/>
			<br />
			<br />
			 <label>*Correo electronico de contacto:</label>
                         <input type="text" name="Correo" id="Correo" placeholder="Correo electronico de contacto" size="35" required=""/>
                        <label>*Contraseña:</label>
                        <input type="password" name="Contrasenia" id="Contrasenia" placeholder="Contraseña" size="35" required=""/>
                        <br />
			<br />
 			<label>*Telefono de Contacto:</label>
                        <input type="text" name="Telefono" onkeypress="return justNumbers(event);" id="Telefono" placeholder="Telefono de Contacto" size="35" required=""/>
			<br />
			<br />

<button>Enviar solicitud para contratar</button>
            </fieldset>
</form>
          
    </body>
</html>
