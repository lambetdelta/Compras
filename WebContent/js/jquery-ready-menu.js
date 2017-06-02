/**
 * Administra las acciones del menú
 */

$(document).ready(function() {	 
	//var $modal = $("#modal-msj");
	
	// Cierra sesion
	$("#cierraSesion").click(function(e){
		e.preventDefault();
		
		$("#modal-msj").load('site/cierra-sesion.html', '', function(){
			$("#modal-msj").modal();
		});
		
	});

	// Cambiar password
	$("#cambiaPasswd").click(function(e){
		e.preventDefault();
		
		$("#modal-msj").load('site/cambia-password.jsp', '', function(){
			$("#modal-msj").modal();
		});
	
	});
	
	// Compras en proceso
	$("#Comprando").click(function(e){
		e.preventDefault();
		
		$(location).attr('href', 'Comprando')
	
	});
});