document.getElementById('enviados').style.visibility === 'hidden';
document.getElementById('recibidos').style.visibility === 'hidden';

function ver_enviados(){
		 if (document.getElementById('enviados').style.visibility != 'visible'){
			 document.getElementById('enviados').style.visibility= 'visible' ;
			 document.getElementById('boton_enviados').innerHTML= 'ocultar enviados' ;
			 document.getElementById('boton_enviados').style.backgroundColor = 'red' ;
			 document.getElementById('enviados').style.height= 'auto' ;
		 }
		 else{
			 document.getElementById('enviados').style.visibility= 'hidden' ;
			 document.getElementById('boton_enviados').innerHTML= 'mostrar enviados' ;
			 document.getElementById('boton_enviados').style.backgroundColor = 'DodgerBlue' ;
			 document.getElementById('enviados').style.height= '0px' ;
		 }
	
	}

function ver_recibidos(){
		if (document.getElementById('recibidos').style.visibility != 'visible'){
		  document.getElementById('recibidos').style.visibility= 'visible' ;
		  document.getElementById('boton_recibidos').innerHTML= 'ocultar recibidos' ;
		  document.getElementById('boton_recibidos').style.backgroundColor  = 'red' ;
		  document.getElementById('recibidos').style.height= 'auto' ;
		}

	else{
		 document.getElementById('recibidos').style.visibility= 'hidden' ;
		 document.getElementById('boton_recibidos').innerHTML= 'mostrar recibidos' ;
		 document.getElementById('boton_recibidos').style.backgroundColor  = 'DodgerBlue' ;
		 document.getElementById('recibidos').style.height= '0px' ;
	}
}


function mostrar_recibidos(id_pulsado) {
	if (document.getElementById("texto_recibidos"+id_pulsado.toString()).style.visibility !=  'visible'){
		document.getElementById("texto_recibidos"+id_pulsado.toString()).style.visibility= 'visible' ;
	    document.getElementById(id_pulsado.toString()).innerHTML= 'ocultar texto';
	    document.getElementById(id_pulsado.toString()).style.backgroundColor = 'red' ;
	}
	else{
		document.getElementById("texto_recibidos"+id_pulsado.toString()).style.visibility= 'hidden' ;
	    document.getElementById(id_pulsado.toString()).innerHTML= 'mostrar texto';
	    document.getElementById(id_pulsado.toString()).style.backgroundColor = 'DodgerBlue' ;
		
	}
}

/*funcion a cambiar*/

function mostrar_enviados(boton_pulsado) {
	if (document.getElementById("texto_enviados"+boton_pulsado.toString()).style.visibility !=  'visible'){
		document.getElementById("texto_enviados"+boton_pulsado.toString()).style.visibility= 'visible' ;
	    document.getElementById(boton_pulsado).innerHTML= 'ocultar texto';
	    document.getElementById(boton_pulsado).style.backgroundColor = 'red' ;
	}
	else{
		document.getElementById("texto_enviados"+boton_pulsado).style.visibility= 'hidden' ;
	    document.getElementById(boton_pulsado).innerHTML= 'mostrar texto';
	    document.getElementById(boton_pulsado).style.backgroundColor = 'DodgerBlue' ;
		
	}
}
