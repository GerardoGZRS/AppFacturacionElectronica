<%-- 
    Document   : ActualizarEmpresa
    Created on : 8/08/2015, 10:04:16 PM
    Author     : JAANP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Empresa" %>
<%@page import="Vista.BeanEmpresa" %>
<%
String idEmp=request.getParameter("idE");
String nomempresa="";
   String razon="";
   String rfc="";
   String regimen="";
   String calle="";
   String numexterior="";
   String numinterior="";
   String colonia="";
   String codigo_postal="";
   String estado="";
   String municipio="";
   String paquete="";
   String persona="";
   String correo="";
   String contrasenia="";
   String telefono="";
   int id=0;
   
   if(idEmp!=null){
       if(Integer.parseInt(idEmp)==0){
           id=0;
           
       }else{
            BeanEmpresa empresa = Empresa.buscarEmpresa(Integer.parseInt(idEmp));
   if(empresa== null){
    out.println("No se encontro el registro");
       }else{
       id=empresa.getIdempresa();
       nomempresa=empresa.getEmpresa();
       razon=empresa.getRazon();
       rfc=empresa.getRFC();
       regimen=empresa.getRegimen();
       calle=empresa.getCalle();
       numexterior=Integer.toString(empresa.getExterior());
       numinterior=Integer.toString(empresa.getInterior());
       colonia=empresa.getColonia();
       codigo_postal=empresa.getCodigo_postal();
       estado=empresa.getEstado();
       municipio=empresa.getMunicipio();
       paquete=empresa.getPaquete();
       persona=empresa.getNombre();
       correo=empresa.getCorreo();
       contrasenia=empresa.getContrasenia();
       telefono=empresa.getTelefono();
       }
   }
   }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
    </head>
      <body style="background: #efeff9">
        <img src="../Imagenes/factufacil.png">
        <form method="POST" action="../ServletActualizarEmpresa">
            <h1>Contratar</h1>
            <fieldset>
            <legend>Datos fiscales</legend>
            <input type="text" name="idEmp" id="idEmp" class="texto" value="<%=id%>"/>
			<br>
			<br>
                        <label>*Nombre de la empresa:</label>
			<input type="text" name="Empresa" id="Empresa" size="44" value="<%=nomempresa%>"/>
			<br>
			<br>
			<label>*Razon Social:</label>
                        <input type="text" name="Razon" id="Razon" size="44" value="<%=razon%>">
			<br>
			<br>
			 <label>*R.F.C.(en mayusculas y sin guiones ni espacios):</label>
                         <input type="text" name="RFC" id="RFC" size="44" value="<%=rfc%>"/>
			<br />
			<br />
 			<label>*Regimen al que pertenece(tal y como esta en su cedula Fiscal):</label>
                        <input type="text" name="Regimen" id="Regimen" size="44" value="<%=regimen%>"/>
			<br />
			<br />
			<label>*Calle:</label>
                        <input type="text" name="Calle" id="Calle" value="<%=calle%>"/>
			<br />
			<br />
                        <label>*Numero Exterior:</label>
                        <input type="text" name="Exterior" id="Exterior" value="<%=numexterior%>"/>
                        <label>*Numero Interior:</label>
                        <input type="text" name="Interior" id="Interior" value="<%=numinterior%>"/>
			<br />
			<br />
			<label>*Colonia:</label>
                        <input type="text" name="Colonia" id="Colonia" value="<%=colonia%>"/>
                        <label>*Codigo Postal:</label>
                        <input type="text" name="Codigo" id="Codigo" value="<%=codigo_postal%>"/>
			<br />
			<br />
			<label>*Estado:</label>
                        <input type="text" name="estad" id="estad" value="<%=estado%>">
                        <select name="Estado" id="Estado">
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
                        <input type="text" name="Municipio" id="Municipio" value="<%=municipio%>"/>
                       <br><br>
                        	<label>*Paquete de Folios:</label>
                                <input type="text" name="paque" id="paque" value="<%=paquete%>">
                       <select name="Paquete" id="Paquete">
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
                        <input type="text" name="Nombre" id="Nombre" size="44" value="<%=persona%>"/>
			<br />
			<br />
			 <label>*Correo electronico de contacto:</label>
                         <input type="text" name="Correo" id="Correo" size="35" value="<%=correo%>"/>
                         <label>*Contraseña:</label>
                         <input type="text" name="Contrasenia" id="Contrasenia" size="35" value="<%=contrasenia%>"/>
                        <br />
			<br />
 			<label>*Telefono de Contacto:</label>
                        <input type="text" name="Telefono" id="Telefono" size="35" value="<%=telefono%>"/>
			<br />
			<br />

<button>Enviar solicitud para contratar</button>
            </fieldset>
</form>
    </body>
</html>
