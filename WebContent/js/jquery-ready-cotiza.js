/***************************************************
 * Ready para contizaciones.jsp
 */
var Cotizaciones={
		modal:$("#modal-msj"),
		init:function(){
			$("#table-invitaciones").on("click", "div.partida-link",Cotizaciones.requestCotizaPartida);
			$("#table-invitaciones").on("click", "div.adjuntos-frm",Cotizaciones.requestCotizacionesAdjuntos);
			$("#table-invitaciones").on("click", "div.finaliza-frm",Cotizaciones.requestCotizaFinalizaLoad);
			$("#table-invitaciones").on("click", "div.idcotiza",Cotizaciones.showInvDetalle);
		},
		requestCotizaPartida:function(){
			// **** Aquí editaremos la Partida
			Utilidades.mostrarPopUpCargando();
			$.post("CotizaPartida",{item: $(this).attr("data_partida"), 
				cot: $(this).attr("cotId"),
				term: $(this).attr("terminado")}).
			done(function(html){
				Cotizaciones.modal.html(html);
			}).
			fail(function(){
				Cotizaciones.modal.html("Error interno");
			}).
			always(function(){
				Utilidades.ocultarPopUpCargando();
				Cotizaciones.modal.modal();
			});
		},
		requestCotizacionesAdjuntos:function(){
			Utilidades.mostrarPopUpCargando();
			$.post("site/cotizaciones_adjuntos.jsp",{cotNo: $(this).attr("cotNo"), idCotizacion : $(this).attr("idCotizacion")})
			.done(function(data){
				Cotizaciones.modal.html(data);
			})
			.fail(function(){
				Cotizaciones.modal.html("Error interno");
			})
			.always(function(){
				Utilidades.ocultarPopUpCargando();
				Cotizaciones.modal.modal();
			});
		},
		requestCotizaFinalizaLoad:function(){
			/**
			Esta función habre la ventana de finalización de una cotización...
			 */
			Utilidades.mostrarPopUpCargando();
			$.post("CotizaFinalizaLoad",{id:$(this).attr("data_item")})
			.done(function(data){
				Cotizaciones.modal.html(data);
			})
			.fail(function(){
				Cotizaciones.modal.html("Error interno");
			})
			.always(function(){
				Utilidades.ocultarPopUpCargando();
				Cotizaciones.modal.modal();
			});
		},
		showInvDetalle:function(){
			var children=$(this).children('span');
			children[0].classList.toggle("glyphicon-circle-arrow-down");
			children[0].classList.toggle("glyphicon-circle-arrow-right");
			var objCotiza = $(this);		
			var objFila = $(this).parents().get(1);
			var fila = $(objFila).next();
			$(fila).show(); // Muestro la fila
			var show = this.dataset.show;
			if (show == "true") {
				this.dataset.show = "false";
				Cotizaciones.requestInvitacionDet($(objCotiza).attr("cotId"),$(objCotiza).attr("terminado"),fila);
			} else {									
				$(fila).hide();
				this.dataset.show = "true";					
			}
		},
		requestInvitacionDet:function(cotId,terminado,fila){
			var contenedor = fila.children(".agrupador").children("#detalle");
			$.ajax({
				url: "InvitacionDet",
				data: {PK: cotId, terminado : terminado },
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
}
