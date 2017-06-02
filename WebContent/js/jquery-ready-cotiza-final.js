/**
 * 
 */

$(document).ready(function() {
	
	/*
	$("#tipo-pago option[value='pleaseSelect']").attr({
		'disabled': 'true',
		'selected': 'true'
	});*/

	$("#cotiza-finaliza").validator();
	$("#cotiza-finaliza").validator().on("submit", function(e) {
		if (!e.isDefaultPrevented()) {
			e.preventDefault();
			
			//Obtenemos que boton presionó
			var target = e.explicitOriginalTarget || e.relatedTarget ||
		        document.activeElement || {};
		    
		        //alert(target.type + ' ' + target.value);
		        
			var fin = target.value;
			var guardar = false;
			if (fin == "true")
				guardar = confirm("¿Realmente deseas Finalizar esta cotización?");
			else
				guardar = true;

			if (guardar) {
				var params = {
						nombreTipoPago: $("#tipo-pago option:selected").html(),
						idTipoPago: $("#tipo-pago").val(),
						fechaEntrega: $("#fechaEntrega").val(),
						cotizador: $("#cotizador").val(),
						cotId: $("#cotId").val(),
						cotNo: $("#cotNo").val(),
						boExtencionId: $("#boExtencionId").val(),
						finalizar: fin,
						terminado: $("#terminado").val(),
						observaciones: $("#observaciones").val(),
						disculpa: $("#disculpa").val(),
						garantia: $("#garantia").val(),
						dias: $("#dias").val()

				};

				//alert("Enviamos a guardar... " + $("#finalizar").prop("checked"));

				$.post("CotizaFinalizaSave", params, function(data, status){
					if (data.EXITO)	{
						//alert("Guardado...");
						$("#modal-msj").modal("hide"); // Ocultamos formulario

						if (data.MENSAJE == "T")
							window.open("PrintCotizacion.pdf?pk=" + $("#cotIdInvitacion").val(),"_blank");

						location.reload(); // Recargamos página...										

					} else {
						alert("No se fue posible actualizar el registro..." + "\n\n" + data.MENSAJE);

						$("#modal-msj").modal("hide"); // Ocultamos formulario...
					}

				});
			} else
				$("#modal-msj").modal("hide"); // Ocultamos formulario...
		
		} 
	});
	
	$("#fechaShow").datetimepicker({
		locale: "es",	
		format: "DD/MM/YYYY"
	});
	
	$("#finalizar").change(function(e){
		
		if ($(this).prop("checked")) {
			var res = confirm("¿Realmente desea finalizar esta cotización?");
		
			if (!res)
				$(this).prop("checked", false);
		}
	});
	
	$("#tipoPago").change(function(e){
		alert($(this).val());
		$("#tipoPagoTxt").val();
	})
});