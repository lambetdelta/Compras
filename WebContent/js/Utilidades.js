var Utilidades={
	
	agregarEventoPorClase:function(clase){
		var classname = document.getElementsByClassName(clase);
		if(classname != null){
			Array.from(classname).forEach(function(element) {
		      element.addEventListener('click', myFunction);
			});
			return true;
		}else
			return false;
	},
	iniciarPopUp:function(){
		document.getElementById('fondo-emergente').onclick=Utilidades.ocultarPopUp;
		$('body').on('click','.close',Utilidades.ocultarDiv);
	},
	ocultarPopUp:function(e){
		if(e.target != this) 
			return false;
		document.getElementById('fondo-emergente').style.display='none';
	},
	mostrarPopUp:function(){
		document.getElementById('fondo-emergente').style.display='block';
	},
	ocultarPopUpCargando:function(){
		document.getElementById('fondo-emergente-cargando').style.display='none';
	},
	mostrarPopUpCargando:function(){
		document.getElementById('fondo-emergente-cargando').style.display='block';
	},
	ocultarDiv:function(){
		var target=this.dataset.target;
		document.getElementById(target).style.display='none';
	},
	recortarNumero:function(numero,decimales){
		var array=numero.split('.');
		if(array.length == 2){
			var entero=array[0];
			var array_decimal=array[1].split('');
			var decimal = '';
			var length=array_decimal.length;
			if(length >= decimales){
				for (var i = 0; i < decimales; i++) {
					decimal += array_decimal[i];
				}
			}else
				decimal = array[1];
			return entero + '.' + decimal;
		}
		return numero;
	},
	validateDecimal:function(valor) {
	    var RE = /^d*.?d*$/;
	    if (RE.test(valor)) {
	        return true;
	    } else {
	        return false;
	    }
	}
}