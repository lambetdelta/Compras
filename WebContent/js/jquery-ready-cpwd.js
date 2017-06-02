/**
 * Administra las acciones del menú
 */

$(document).ready(function() {	 
	
	$("#myForm").validator();
	
	$("#PasswdForm").validator().on("submit", "", function (e) {	
		
		if (!e.isDefaultPrevented()) {
			$.getJSON('CambiaPassword',{passwdact : $("#passwdact").val(), passwdnew : $("#passwdnew").val()},
					function(res, textStatus, jqXHR) {
				
				if (res.exito) {
					$("#msj").html("<span class='label label-info'>Password cambiado correctamente</span>");	
					$("#btn-cpok").hide();
					$("#passwdact").prop( "disabled", true );
					$("#passwdnew").prop( "disabled", true );
					$("#passwdnew2").prop( "disabled", true );

					$("#modal-msj").modal("hide");
				} else {
					$("#msj").html("<span class='label label-danger'>"+ res.mensaje+"</span>");
				}
			});
		}
		
		
	});		
	
});