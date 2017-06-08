

<%@page import="org.tempuri.ModelRUBROS"%>
<%@page import="gob.tlajomulco.config.Estatus"%>
<%@page import="gob.tlajomulco.utiles.FormatosQPS"%>
<%@page import="gob.tlajomulco.ModelUsuario"%>
<%@page import="gob.tlajomulco.utiles.Utilidades"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ModelRUBROS[] rubros = null;
	String [] id_rubros =new String[1];
	if (request.getAttribute("rubros") != null)
		rubros = (ModelRUBROS[]) request.getAttribute("rubros");
	Estatus status=new Estatus();
	if (request.getAttribute("status") != null) {
		status = (Estatus) request.getAttribute("status"); 	
	}
%>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<title>Portal de compras :: Tlajomulco Gobierno Municipal</title>
	<link rel="shortcut icon" href="imagenes/ico/favicon.ico" type="image/x-icon">

	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="font-awesome-4.6.1/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="iconFonts/material-icons.css">
	<link rel="stylesheet" href="css/compras.css">
	<link rel="stylesheet" href="css/comprando.css">
	<link rel="stylesheet" type="text/css" href="js/multiselectBootstrap/css/bootstrap-multiselect.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
</head>
<body>
	<div id="fondo-emergente-cargando" class="fondo-emergente">
		<img src="imagenes/preload.gif" >
	</div>
	<div id="fondo-emergente" class="fondo-emergente">
		<div id="contenedor-emergente" class="contenedor-emergente">
		</div>
	</div>
	<div id="wrapper">
		<!-- Menu -->
		<jsp:include page="menu.jsp"></jsp:include>
		<!-- Cuerpo -->	
		<div class="container-fluid">
			<div class="row">		
				<div class="" id="pnBusqueda">
					<div class="container">	
						<div class="row">
							<div class=col-lg-12"">
								<h3>Formulario de búsqueda</h3>	
							</div>
						</div>
						<form action="" id="buscaRubro" class="form-horizontal"  role="form" method="post">
							<div class="display-flex-end">						
			   						<div class="flex-width-6">	
			   							<label class="control-label" for="articulo">Seleccione el rubro:</label>
			   								<select id="rubros" name="rubros[]"  class="form-control" multiple="multiple" autocomplete="off">
			   								<% 	
			   								String selected="";
			   								if(Utilidades.isArray(rubros)){
			   									for (int i = 0; i < rubros.length; i++) { 
			   										ModelRUBROS rubro =  rubros[i];	
			   										selected=Utilidades.asignarCadenaPorCoincidencia(rubro.getCODIGO(), id_rubros ,"selected");%>
			   										<option value="'<%=rubro.getID() %>'" <%=selected%>><%=rubro.getDETALLE() %></option>
			   								<%	}
			   								}else{ %>
			   									<option value="null">Sin rubros disponibles</option>
			   								<%} %>
			   								</select>  							
			   						</div>    					
									<div class="flex-width-2">
										<label>Fecha de vigencia:</label>
										<div class='input-group date' id='fecha-publicacion'>
						                    <input type='text' class="form-control" autocomplete="off" readonly="readonly"/>
						                    <span class="input-group-addon">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
									</div>
									<div class="flex-width-2" style="display:none">
										<label>Fecha de vencimiento:</label>
										<div class='input-group date' id='fecha-vencimiento' >
						                    <input type='text' class="form-control" autocomplete="off" readonly="readonly"/>
						                    <span class="input-group-addon">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
									</div>
									<div class="flex-width-1">
										<button id="solicitar-concursos" type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Buscar</button>
									</div>
									<div class="flex-width-2" id="alert-rubros">
										<div class="alert alert-warning" role="alert">
										  Selecciona al menos un rubro
										</div>
									</div>
							</div>	
						</form>				
					</div>					
				</div>								
				<div class="panel">				
					<div class="container-fluid">
						<div class="panel" id="contenedor-resultados">
							<img id="cargando-concurso" src="imagenes/preload.gif" class="cargando">
							<table id="tabla-concursos" class="table table-striped table-hover text-center">
								<thead>
									<tr class="text-center">
										<td>Convocatoria</td>
										<td>Fecha Publicacion</td>
										<td>Rubro</td>
										<td>Bases</td>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>																			
			</div>
		</div>
		<!-- Pie -->
		<div class="container-fluid">	
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	<script src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/Utilidades.js"></script>
	<script src="js/moment.min.js"></script>
	<script src="js/moment.local.es.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="js/multiselectBootstrap/js/bootstrap-multiselect.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="js/typeahead.min.js"></script>     
	<script src="js/jquery-ready-menu.js"></script>   
	<script src="js/validator.js"></script>
	<script src="js/jquery-barcode.min.js"></script>
	<script type="text/javascript" src="js/modeloDetalleConcurso.js"></script>
	<script type="text/javascript" src="js/Concurso.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			Concurso.inicio();
			Concurso.setUrlConcursos("<%=status.getRespositorioUrl()%>");
		})
	</script>
</body>
</html>