/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//contenedor inicial
$(document).ready(function(){
    $.ajax({
        url: "JSP/botoncontenedorinicial.jsp",
        success: function (data){
            $('#registro').html(data);
        }
    });
});


         //Llamar slider
  $(function(){
  $(".slides").slidesjs({
    play: {
      active: true,
      effect: "slide",
      interval: 3000,
      auto: true,
      swap: true,
      pauseOnHover: false,
      restartDelay: 2500
    }
  });
});


//Registro de empresa por opcion del boton
$(document).on('click','#boton',function(){
    $('.slides').html("");
    $('.contenedor1').html("");
    $('.contenedor2').html("");
    $('.slides').load('JSP/Registrarse.jsp');
    
});
$(document).on('click','#inicio',function(){
    $('.slides').html("");
    $('.contenedor1').html("");
    $('.contenedor2').html("");
    $('.contenedor3').html("");
    $('#registro').html("");
    $('.contenedor1').load('JSP/BotonesLogin.jsp');  
});
$(document).on('click','#logempresa',function(){
    $('.slides').html("");
    $('.contenedor1').html("");
    $('.contenedor2').html("");
    $('.contenedor3').html("");
    $('#registro').html("");
    $('.contenedor1').load('JSP/Login.jsp');
    
});

$(document).on('click','#contrata',function(){
    $('.slides').html("");
    $('.slides').load('JSP/Registrarse.jsp');
});

//llamar a la tabla empresa
            $(document).on('click','#enviarE',function (){
                $('#contenedor').html("");
                $('#contenedor').load("ServletConsultarEmpresa",function (){});
                
            });
            
//llamar a la tabla precio
            $(document).on('click','.precio',function (){
                $('.slides').html("");
                $('.contenedor1').html("");
                $('.contenedor2').html("");
                $('.slides').load("ServletConsultaPrecio",function (){});
                
            });
            
            $(document).on('click','.caracteristica',function (){
                $('.slides').html("");
                $('.contenedor1').html("")
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.contenedor1').load("html/Caracteristicas.html",function (){});
                
            });
            $(document).on('click','.ComoContratar',function (){
                $('.slides').html("");
                $('.contenedor1').html("");
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.contenedor1').load("html/ComoContratar.html",function (){});
                
            }); 
            $(document).on('click','.empresass',function (){
                $('.contenedor1').html("");
                $('.contenedor1').load("ServletConsultarEmpresa",function (){});
            }); 
             $(document).on('click','.empleado',function (){
                $('.contenedor1').html("");
                $('.contenedor1').load("JSP/ADMMostrarEmpleado.jsp",function (){});
            }); 
            $(document).on('click','.empeadoempre',function (){
                $('.contenedor1').html("");
                $('.contenedor1').load("JSP/MostrarEmpleado.jsp",function (){});
            }); 
            $(document).on('click','.inicioemp',function (){
                $('.contenedor1').html("");
                $('.contenedor1').load("JSP/EMPMostrarDatos.jsp",function (){});
            }); 
           
            
            $(document).on('click','.inicioadmi',function (){
                $('.contenedor1').html("");
                $('.contenedor1').load("JSP/ADMmostrarDatos.jsp",function (){});
            }); 
            
             $(document).on('click','.Nosotros',function (){
                $('.slides').html("");
                $('.contenedor1').html("")
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.contenedor1').load("html/Nosotros.html",function (){});
                
            });
               $(document).on('click','.Contacto',function (){
                $('.slides').html("");
                $('.contenedor1').html("")
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.contenedor1').load("html/Contacto.html",function (){});
                
            });
               $(document).on('click','termino',function (){
                $('.slides').html("");
                $('.contenedor1').html("")
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.slides').load("html/terminos.html",function (){});
                
            });
            $(document).on('click','.btncontactar',function (){
                $('.slides').html("");
                $('.contenedor1').html("")
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.slides').load("JSP/Registrarse.jsp",function (){}); 
            });
             $(document).on('click','#enviarcurso',function (){
                
                         load("ServletInsertarComentario",function (){}); 
            });
            
            $(document).on('click','#precio',function (){
                $('.slides').html("");
                $('.contenedor1').html("")
                $('.contenedor2').html("");
                $('.contenedor3').html("");
                $('.slides').load("ServletConsultaPrecio",function (){});
            });
            //evaluar el registro que se hizo clic
            $(document).on('click','#tbem tbody tr',function (){
                var nTds= $('td',this);
                var idE;
                idE=$(nTds[0]).text();
                //alert(idF);
                //cargar la capa div_Contacto
                
            });
            
            
      

