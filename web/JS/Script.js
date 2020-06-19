/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function lanzadera(){
   
    getList();
    getFacturaLista();

}

function lanzadera2(){
    getBusquedaFactura();
}

function lanzadera3(){
    formulario();
    getEmisor();
    getList();
    getComprobante();
    
}
function createRequest(){
    request = false;
    if(window.XMLHttpRequest){
     request = new XMLHttpRequest();
    }
    return request;
}
//
var reqList = createRequest();

function getList(){
    
    reqList.open("GET", "/Factufacil/ComboReceptor",true);
    
    reqList.onreadystatechange = reciveList;
    
    reqList.send(null);
    
}

function reciveList(){
    
    if(reqList.readyState == 4){
        select = document.getElementById("comboDinamico");
     if(reqList.status == 200){
         
         select.innerHTML = reqList.responseText;

     }else{
         select.innerHTML = "Error!!: "+ reqList.status + "----" +reqList.statusText;
     }

    }
}
var reqBusquedaFactura = createRequest();
function getBusquedaFactura(){
    reqBusquedaFactura.open("GET", "/Factufacil/BusquedaRfc",  true);
    reqBusquedaFactura.onreadystatechange = receiveBusquedaFactura;
    receiveBusquedaFactura.send(null);
    
}

function receiveBusquedaFactura(){
    if(reqBusquedaFactura.readyState == 4){
        div = document.getElementById("txtTabla");
     if(reqBusquedaFactura.status == 200){
         
         div.innerHTML = reqBusquedaFactura.responseText;

     }else{
         div.innerHTML = "Error!!: "+ reqBusquedaFactura.status + "----" +reqBusquedaFactura.statusText;
     }

    } 
}

//Nos imprimira una tabla de acuerdo a los registros existentes
var reqListaFactura = createRequest();
 function getFacturaLista(){
     reqListaFactura.open("GET", "/Factufacil/ListaFactura", true);
    
     reqListaFactura.onreadystatechange = receiveListFactu;
     
     reqListaFactura.send(null);
   
 }
 //Recibira la lista 
 function receiveListFactu(){
    if(reqListaFactura.readyState == 4){
        div = document.getElementById("ListaFactura");
     if(reqListaFactura.status == 200){
         
         div.innerHTML = reqListaFactura.responseText;

     }else{
         div.innerHTML = "Error!!: "+ reqListaFactura.status + "----" +reqListaFactura.statusText;
     }

    } 
 }
 
function displayForm(event, element){
    if(event.target.innerHTML == "CFDI"){
       event.target.innerHTML = "Regresar"; //event = donde se hizo el evento, target = seleccion del elemento donde se hizo elevento, hinner = contenido
       document.getElementById(element).setAttribute("style","display: auto;");
    }else{
        event.target.innerHTML = "CFDI";
        document.getElementById(element).setAttribute("style","display: none;");
       
    }
}

//Datos
var reqDates = createRequest();
function formulario(){
     reqDates.open("GET", "/Factufacil/FormularioFactura", true);

     reqDates.onreadystatechange = receiveFormulario;

     reqDates.send(null);

 }
 //Recibira la lista
 function receiveFormulario(){
    if(reqDates.readyState == 4){
        table = document.getElementById("frComprobante");
     if(reqDates.status == 200){

         table.innerHTML = reqDates.responseText;

     }else{
         table.innerHTML = "Error!!: "+ reqDates.status + "----" +reqDates.statusText;
     }

    }
 }

//ComboEmisor
var reqEmisor = createRequest();

function getEmisor(){
    
    reqEmisor.open("GET", "/Factufacil/ComboEmisor",true);
    
    reqEmisor.onreadystatechange = reciveEmisor;
    
    reqEmisor.send(null);
    
}

function reciveEmisor(){
    
    if(reqEmisor.readyState == 4){
        select = document.getElementById("comboEmisor");
     if(reqEmisor.status == 200){
         
         select.innerHTML = reqEmisor.responseText;

     }else{
         select.innerHTML = "Error!!: "+ reqEmisor.status + "----" +reqEmisor.statusText;
     }

    }
}
//Comprobante
var reqComprobante = createRequest();

function getComprobante(){
    
    reqComprobante.open("GET", "/Factufacil/comboComprobante",true);
    
    reqComprobante.onreadystatechange = reciveComprobante;
    
    reqComprobante.send(null);
    
}

function reciveComprobante(){
    
    if(reqComprobante.readyState == 4){
        select = document.getElementById("comboComprobante");
     if(reqComprobante.status == 200){
         
         select.innerHTML = reqComprobante.responseText;

     }else{
         select.innerHTML = "Error!!: "+ reqComprobante.status + "----" +reqComprobante.statusText;
     }

    }
}



function displayForm1(event, element){
    if(event.target.innerHTML == "Factura"){
       event.target.innerHTML = "Regresar"; //event = donde se hizo el evento, target = seleccion del elemento donde se hizo elevento, hinner = contenido
       document.getElementById(element).setAttribute("style","display: auto;");
    }else{
        event.target.innerHTML = "Factura";
        document.getElementById(element).setAttribute("style","display: none;");
       
    }
}