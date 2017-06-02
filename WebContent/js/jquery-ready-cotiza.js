/***************************************************
 * Ready para contizaciones.jsp
 */


$(document).ready(function() {
		
	$(".default").hide(); // Ocultamos toda la información...
	$(".warning").hide(); // Ocultamos todo
	
	$("#table-invitaciones").on("click", ".idcotiza", function(e){
		e.preventDefault();
		
		$(".default").hide(); // Ocultamos todo	
		$(".warning").hide(); // Ocultamos todo
		$(".ico_cotiza").removeClass("glyphicon-circle-arrow-down");
		$(".ico_cotiza").addClass("glyphicon-circle-arrow-right");		
		
		var objCotiza =$(this);		
		var objFila = $(this).parents().get(1);
		var fila = $(objFila).next();
				
		$(fila).show(); // Muestro la fila
			
		// Mostramos detalle de la cotización seleccionada
		if (!$(objCotiza).children("#ico_cotiza").hasClass("muestra")) {
			$(".ico_cotiza").removeClass("muestra"); // Remuevo todo los muestra de otras selecciones
			$(objCotiza).children("#ico_cotiza").removeClass("glyphicon-circle-arrow-right");
			$(objCotiza).children("#ico_cotiza").addClass("glyphicon-circle-arrow-down");
			$(objCotiza).children("#ico_cotiza").addClass("muestra");
			
			//Cargamos información Ajax... ***************						
			var contenedor = $(fila).children(".agrupador").children("#detalle");
			
			$.ajax({
				url: "InvitacionDet",
				data: {"PK": $(objCotiza).attr("cotId"), "terminado" : $(objCotiza).attr("terminado") },
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
		} else {									
			if ($(fila).is(":visible"))
				$(fila).hide();
			
			$(".ico_cotiza").removeClass("muestra");					
		}		
	});	
	
	// **** Aquí editaremos la Partida
	$("#table-invitaciones").on("click", "a.partida-link", function(e){
	//$("#table-inv-det").on("click", "a.partida-link", function(e){
		e.preventDefault();			
		
		var click = $(this)		
		// Obtenemos valores a enviar...
		var itemId = $(click).attr("data_partida"); //.replace(/'/g, "\"");
		var cotId = $(click).attr("cotId");
		var terminado = $(click).attr("terminado");
		
		//alert("Iniciando " + itemId );
		var param = {item: $(click).attr("data_partida"), 
				cot: $(click).attr("cotId"),
				term: $(click).attr("terminado")};
		
		//alert("Segundo");
		//data =  data + "|" + cotId + "|" + terminado + "|"; 
		//data = cotId + "|" + itemId + "|" + terminado;
		
		//alert("A mostrar el modal: \n" + data);
		//alert("Abriendo Modal... " + param);
		$("#modal-msj").load("CotizaPartida", param, function(){			
			$("#modal-msj").modal();
		});
		
	});
	
	/**
	 * Esta función habre la ventana de finalización de una cotización...
	 */
	$("#table-invitaciones").on("click", "a.finaliza-frm", function(e){
		e.preventDefault();
		
		var click = $(this);
		var data = $(click).attr("data_item").replace(/'/g, "\"");
			
		//alert("A mostrar el modal: \n" + data);
		$("#modal-msj").load("CotizaFinalizaLoad", data, function(){			
			$("#modal-msj").modal();			
		});
			
	});
	
	
	$("#table-invitaciones").on("click", "a.adjuntos-frm", function(e){
		e.preventDefault();
				
		var click = $(this);
		var cotNo = $(click).attr("cotNo");
		var idCotizacion = $(click).attr("idCotizacion");
		

		$("#modal-msj").load("site/cotizaciones_adjuntos.jsp", {"cotNo": cotNo, "idCotizacion" : idCotizacion}, function(){					
			$("#modal-msj").modal();
		});
	});
	
});
