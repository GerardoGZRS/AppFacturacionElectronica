/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//

    function justNumbers(e)
    {
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 8) || (keynum == 46))
    return true;
     
    return /\d/.test(String.fromCharCode(keynum));
    }

function soloLetras(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false
       for(var i in especiales){
            if(key == especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
        }
        
        
        function codigo(){
		var numero=document.getElementById('Codigo').value;
		var numeroCorrecto=/^[0-9-.]+$/;

		if(numero.search(numeroCorrecto)==0 && numero.length!=0){//si es correcto devuelve o
			document.getElementById("Codigo").innerHTML="<style type='text/css'> #Codigo{border-color: green;}</style>";
		}else if(numero.length==0){
			document.getElementById("Codigo").innerHTML="<style type='text/css'> #Codigo{border-color: none;}</style>";
		}else{
			document.getElementById("Codigo").innerHTML="<style type='text/css'> #Codigo{border-color: red;}</style>";
		}
	}