/**
 * Cotización de Items
 */

$(document).ready(function() {
	
	$("#cotiza-item").validator();
		
	$("#cotiza-item").validator().on("change", "#precio", function(e){
		
		if (e.isDefaultPrevented()) {
		    $("#total").val("0.0000");
		    //alert("Que que que que que que que...");
		} else {
				    	
			if (!$("#precio").val().trim() == "") {
			    calculaTotales();
			}		    					   
		}			
	});
	
	$("#cotiza-item").validator().on("change", "#iva", function(e){
		
		if (e.isDefaultPrevented()) {
		    $("#iva").val("0.0000");
		    //alert("Que que que que que que que...");
		} else {
				    	
			if (!$("#iva").val().trim() == "") {
			    calculaTotales();
			}		    					   
		}			
	});
	
	$("#cotiza-item").validator().on("change", "#ieps", function(e){
		
		if (e.isDefaultPrevented()) {
		    $("#ieps").val("0.0000");
		    //alert("Que que que que que que que...");
		} else {
				    	
			if (!$("#ieps").val().trim() == "") {
			    calculaTotales();
			}		    					   
		}			
	});
	
	$("#fechaShow").datetimepicker({
		locale: "es",	
		format: "DD/MM/YYYY"
	});
	
	$("#cotiza-item").validator().on("submit", "", function(e){
		if (!e.isDefaultPrevented()) {
			//alert("Formulario OK guardamos..." + $("#idItem").val());		
			e.preventDefault();
			
			var filaCot = "#det_" + $("#cotId").val();
			filaCot = $(filaCot).children(".agrupador").children("#detalle");
			
			var terminado = $("#terminado").val();
			var cotId = $("#cotId").val();
			
			var param = {idItem: $("#idItem").val(),
						precio: $("#precio").val(),
						total: $("#total").val(),
						garantia: $("#garantia").val(),
						cantidad: $("#cantidad").val(),
						terminado: $("#terminado").val(),
						cotId: $("#cotId").val(),
						iva: $("#iva").val(),
						ieps: $("#ieps").val(),
						observaciones: $("#observaciones").val()
					};
			
			$.post("InvitacionItemSave", param,	function(data, textStatus) {
				if (data.EXITO)	{							
					$("#modal-msj").modal("hide"); // Ocultamos formulario
					
					actualizaPartida(filaCot,cotId,terminado);
				} else {
					alert("No se fue posible actualizar el registro..." + "\n\n" + data.MENSAJE);
					
					$("#modal-msj").modal("hide"); // Ocultamos formulario...
				}
			});
			
			
		}
	});
	
	
	function calculaTotales() {
		cantidad = parseFloat($("#cantidad").val());
		precio = parseFloat($("#precio").val());
    	subtotal = 0;
    	ivaP = 0;
    	iva = 16;
    	ieps = 0;
    	total = 0;
    	
    	if (!isNaN(precio)) {
    		ieps = parseFloat($("#ieps").val());
    		
        	subtotal = (cantidad * precio);
        	iva = parseFloat($("#iva").val()); 
        	ivaP = subtotal *  (iva / 100);
        	total = subtotal + ivaP + ieps ;
        	
        	
    		$("#precio").val(precio.toFixed(4));
    	} else {
    		total = 0;
    		$("#precio").val("");
    	}
    	
    	$("#subtotal").val(subtotal.toFixed(4));
    	$("#ivaP").val(ivaP.toFixed(4));
    	$("#total").val(total.toFixed(4));
	}
	
	function actualizaPartida(contenedor, cotId, terminado) {
		//contenedor = $(contenedor).children("#detalle");
		
		$.ajax({
			url: "InvitacionDet",
			data: {"PK": cotId, "terminado" : terminado },
			type: "get",
			beforeSend: function() {
				$(contenedor).html("<div class='text-center'><br><br><img src='imagenes/preload.gif' alt='Cargando, espere por favor...'>" +
				"<br><br></div>");
			},
			success : function(data) {										
				$(contenedor).html(data);
			},
			error: function(){					
				$(contenedor).html(
					"<div class='text-center'><br><br><span class='label label-danger'>Ocurrio un error al obtener el detalle, de la cotización...</span>" +
					"<br><br></div>");
			}
		});
	}
});