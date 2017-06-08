/**
 * clase para manejar mediante solicitud ajax las Concursos actuales 
 */

var Concurso={
		arreglo_detalle_concurso:new Array(),
		url_concursos:null,
		inicio:function(){
//			iniciar aspectos visuales y ligar eventos
			Concurso.inicioMultiselect();
			Concurso.inicioFechaVencimiento();
			Concurso.inicioFechaPublicacion();
			document.getElementById('solicitar-concursos').onclick=Concurso.solicitarConcursos;
			Utilidades.iniciarPopUp();
			$('#tabla-concursos').on('click','.Concurso',Concurso.solicitarDetalleConcurso);
		},
		inicioMultiselect:function(){
//			iniciar multiselect, con su configuarción
			$("#rubros").multiselect({
				onChange: this.filter_,
				includeSelectAllOption: true,
				onSelectAll:this.showAll,
				onDeselectAll:this.hideAll,
				allSelectedText: 'Todos seleccionados',
				nonSelectedText: 'Ninguno selecionado',
				nSelectedText: 'Seleccionados',
				selectAllText: 'Todos'
			});
		},
		inicioDatepicker:function(obj,dia_inicio){
//			iniciar calendario
			return obj.datetimepicker({
				format: 'DD/MM/YYYY',
				locale: 'es',
				defaultDate:dia_inicio,
				ignoreReadonly:true
			});
		},
		inicioFechaVencimiento:function(){
//			calcular y asignar  fecha de vencimiento
			var mañana=moment().add(1, 'days');
			var obj_vencimiento=Concurso.inicioDatepicker($('#fecha-vencimiento'),mañana);
			obj_vencimiento.on('dp.change',Concurso.verificarFechaVencimiento);
		},
		inicioFechaPublicacion:function(){
//			calcular y asignar fecha de inicio
			var hoy=moment();
			var obj_publicacion=Concurso.inicioDatepicker($('#fecha-publicacion'),hoy);
			obj_publicacion.on('dp.change',Concurso.verificarFechaInicio);
		},
		setUrlConcursos:function(url){
			Concurso.url_concursos=url;
		},
		obtenerIdRubros:function(multiselect){
			return Concurso.getAllOptionSeleted($("#rubros"),',');
		},
		solicitarConcursos:function(){
//			solicitar con ajax lista de concursos con el id de los rubros de seleccionados y la fecha de inicio
			var idRubros=Concurso.obtenerIdRubros($('#rubros'));
			if(idRubros.length > 0){
				Concurso.desactivarBoton();
				var fecha_publicacion=Concurso.obtenerFecha($('#fecha-publicacion')).format('YYYY-MM-DD');
				var fecha_vencimiento=Concurso.obtenerFecha($('#fecha-vencimiento')).format('YYYY-MM-DD');
				$('#cargando-concurso').show();
				$('#tabla-concursos').hide();
				$.post('ComprandoAjax',{idRubros:idRubros,fecha_publicacion:fecha_publicacion,fecha_vencimiento:fecha_vencimiento})
				.done(function(data){
					Concurso.manejarRespuesta(data);
				})
				.always(function(){
					Concurso.desactivarBoton();
					$('#cargando-concurso').hide();
					$('#tabla-concursos').show();
				});
			}else
				Utilidades.mostrarYDesvanecer('alert-rubros',400);
		},
		solicitarDetalleConcurso:function(){
//			solicitar con ajax los detalles de un concurso en base al ID del mismo(solo se solicita una vez por concurso)
			var tag_name=arguments[0].target.tagName;
			var registro=this.dataset.registro;
			if(tag_name != 'IMG' && registro != null){
				Utilidades.mostrarPopUpCargando();
				var detail_concurso=Concurso.buscarArrayDetalleConcursoPorIdReferencia(registro);
				if(detail_concurso === false){
					$.post('ConcursoDetalleAjax',{idConcurso:registro}).
					done(function(data){
						Concurso.manejarRespuestaDetalleConcurso(data,registro);
					})
					.fail(function(){
						Utilidades.ocultarPopUpCargando();
						alert('Error al solicitar datos');
					});
				}else{
					Concurso.mostrarDetalleConcurso(detail_concurso);
				}
			}
		},
		mostrarDetalleConcurso:function(data){
//			generar HTML del detalle de un concurso
			var length = data.length;
			var boton = Concurso.plantillaBotonCerrar('fondo-emergente') + '<h2 class="text-center">Detalles</h2>';
			var html="";
			var contenedor=document.getElementById('contenedor-emergente');
			var encabezado='';
			if(data.length > 0){
				for (var i = 0; i < length; i++){
					if(i == 0)
						encabezado = Concurso.plantillaEncabezadoDetallesConcurso(data[i].PROYECTO);
					else
						html += Concurso.plantillaSeparadorDetalleConcurso();
					html += Concurso.plantillaItemDetalleConcurso(data[i].DESCRIPCION,data[i].PRIORIDAD,
							data[i].CANTIDAD,data[i].DETALLES,data[i].UNIDAD_MEDIDA);
				} 
			}else
				html = Concurso.plantillaConcursoSinItem()
			contenedor.innerHTML = boton + '<table class="table table-striped table-hover text-center">' + encabezado + html + "</table>";
			Utilidades.ocultarPopUpCargando();
			Utilidades.mostrarPopUp();
		},
		guardarDetalleConcurso:function(data,registro){
//			Para mejor performance se guardan los detalles de un concurso para no solicitarlos mas que una vez
			var length = data.length;
			if(data.length > 0){
				for (var i = 0; i < length; i++) {
					var obj_detalle = new ModeloDetalleConcurso(data[i].REFERENCIA,data[i].DESCRIPCION,data[i].PRIORIDAD,
							data[i].CANTIDAD,data[i].PROYECTO,data[i].DETALLES,data[i].UNIDAD_MEDIDA,registro);
					Concurso.arreglo_detalle_concurso.push(obj_detalle);
				}
			}
		},
		manejarRespuestaDetalleConcurso:function(data,registro){
			Concurso.mostrarDetalleConcurso(data);
			Concurso.guardarDetalleConcurso(data,registro);
		},
		obtenerFecha:function(obj){
			return obj.data("DateTimePicker").date();
		},
		verificarFechaVencimiento:function(e){
//			la fecha de vecimeinto no puede ser inferior a la de publicacion
			var fecha_inicio=Concurso.obtenerFecha($('#fecha-publicacion'));
			var fecha_fin=Concurso.obtenerFecha($('#fecha-vencimiento'));
			var dias_diferencia=Concurso.calcularDiasDiferenciaConMoment(fecha_inicio,fecha_fin);
			if( dias_diferencia >= 0 )
				$('#fecha-vencimiento').data("DateTimePicker").date(e.oldDate);
		},
		verificarFechaInicio:function(e){
//			la fecha de inicio no puede ser superior de la de vencimiento
			var fecha_inicio = Concurso.obtenerFecha($('#fecha-publicacion'));
			var fecha_fin = Concurso.obtenerFecha($('#fecha-vencimiento'));
			var dias_diferencia = Concurso.calcularDiasDiferenciaConMoment(fecha_inicio,fecha_fin);
			if( dias_diferencia >= 0 )
				Concurso.cambiarFechaVencimiento(e);
		},
		cambiarFechaVencimiento:function(e){
			var new_date = moment(e.date).add(1, 'days');
			$('#fecha-vencimiento').data("DateTimePicker").date(new_date);
		},
		calcularDiasDiferenciaConMoment:function(fecha_1,fecha_2){
			return fecha_1.diff(fecha_2, 'days');
		},
        getAllOptionSeleted:function(obj,glue=''){
//        	Obtener todos valores del multiselect seleccionados
        	var result = new Array();
        	obj.find("option:selected").each(function(index, el) {
        			result.push(this.value);
    		});
    		return result.join(glue);
        },
        plantillaConcursoItem:function(id_Concurso,fecha_publicacion,rubro,documento,requerimiento,disponibilidad_pdf){
        	var img_pdf=Concurso.disponibilidadDePDF(disponibilidad_pdf,documento);
        	return '<tr class="Concurso cursor" data-registro="' + id_Concurso + '"><td>' + requerimiento + 
        	'</td><td>' + fecha_publicacion.slice(0,10) + '</td><td>' + rubro + 
        	'</td><td>' + img_pdf + '</td></tr>';
        },
        disponibilidadDePDF:function(disponibilidad_pdf,documento){
        	if(disponibilidad_pdf){
        		var url_file=Concurso.url_concursos + documento + ".pdf";
        		return "<a href='" + url_file + "' target='_blank'><img src='imagenes/ico/pdf.png' class='cursor pdf'/></a>";
        	}else
        		return "";
        },
        manejarRespuesta:function(data){
//        	Generar html de los concursos solicitados
        	var d=document.getElementById('tabla-concursos').getElementsByTagName('tbody');
        	var contenedor=d[0];
        	var lenght_data=data.length -1;
        	var html="";
        	if(lenght_data >= 0){
        		for (var i = 0; i <= lenght_data; i++) 
					html += Concurso.plantillaConcursoItem(data[i].ID,data[i].FECHAVIGENCIA,data[i].NOMBRERUBRO,
							data[i].NUMERODOCUMENTO,data[i].REQUERIMIENTO,data[i].ARCHIVO_DISPONIBLE);
        	}else
        		html = Concurso.sinItems();
        	contenedor.innerHTML=html;
    		
        },
        isEmptyJSON:function(obj) {
    	  for(var i in obj) { return false; }
        	  return true;
        },
        sinItems:function(){
        	return Concurso.plantillaConcursoSinItem();
        },
        plantillaConcursoSinItem:function(){
        	return '<tr><td colspan="4">Sin coincidencias</td></tr>';
        },
        plantillaItemDetalleConcurso:function(descripcion,prioridad,cantidad,detalles,unidad_medida){
    		detalles=(detalles.length > 5) ? detalles : 'Sin detalles'; 
    		cantidad = Utilidades.recortarNumero(cantidad,2);
    		return '<tr><td class="detalle-concepto">Descripción</td><td class="detalle-valor">' + descripcion + '</td>' +
        			'<tr><td class="detalle-concepto">Cantidad</td><td class="detalle-valor">' + cantidad + ' ' + unidad_medida + '</td></tr>'+
        			'<tr><td class="detalle-concepto">Detalles</td>' +
        			'<td class="detalle-valor">' + detalles + '</td></tr>'+
        			'<tr><td class="detalle-concepto">Prioridad</td><td class="detalle-valor">' + prioridad + '</td>' +
        			'</tr>';
        },
        plantillaEncabezadoDetallesConcurso:function(proyecto){
        	return "<tr class='header'><td colspan='2'>" + proyecto+ "</td></tr>";
        },
        plantillaBotonCerrar:function(target){
        	return '<button type="button" data-target="' + target + '" class="close" aria-hidden="true">x</button>';
        },
        plantillaSeparadorDetalleConcurso:function(){
        	return "<tr class='separador-concurso-detalle'><td colspan='2'></td></tr>";
        },
        desactivarBoton:function(){
        	var boton = document.getElementById('solicitar-concursos');
        	if(boton.disabled)
        		boton.disabled=false;
        	else
        		boton.disabled=true;
        },
        buscarArrayDetalleConcursoPorIdReferencia:function(referencia){
//        	Buscar un concurso con su ID(Se usa para evitar solicitar al servidor un mismo registro dos veces)
        	var cache=Concurso.arreglo_detalle_concurso;
        	var length=cache.length;
        	var detail_concurso=new Array();
        	for (var i = 0; i < length; i++) {
				if(cache[i].id_referencia == referencia)
					detail_concurso.push(cache[i]);
			}
        	if(detail_concurso.length > 0)
        		return detail_concurso;
        	else
        		return false;
        }
}