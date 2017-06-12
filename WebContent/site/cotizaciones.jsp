<%@page import="gob.tlajomulco.utiles.Formatos"%>
<%@page import="java.io.File"%>
<%@page import="gob.tlajomulco.config.Estatus"%>
<%@page import="gob.tlajomulco.utiles.Base64Coder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="gob.tlajomulco.utiles.FormatosQPS"%>
<%@page import="org.tempuri.ModelCotizacionProveedor"%>
<%@page import="gob.tlajomulco.ModelUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HttpSession s = request.getSession(false);

	ModelUsuario user = new ModelUsuario();
	ModelCotizacionProveedor invitacion[] = null;
	Estatus portalSts = new Estatus();
	
	if (s.getAttribute("user") != null)
		user = (ModelUsuario) s.getAttribute("user");
	
	if (request.getAttribute("invitacion") != null) {
		invitacion = (ModelCotizacionProveedor[]) request.getAttribute("invitacion");
		
		//System.out.println("No de invitaciones: " + invitacion.length);
	}
	
	if (request.getAttribute("estatus") != null) {
		portalSts = (Estatus) request.getAttribute("estatus"); 	
	}
			
%>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Portal de compras :: Tlajomulco Gobierno Municipal</title>
<link rel="shortcut icon" href="imagenes/ico/favicon.ico" type="image/x-icon">

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="font-awesome-4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="iconFonts/material-icons.css">
<link href="css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="css/compras.css">
<link rel="stylesheet" href="css/popUpCargando.css">


</head>
<body>
	<div id="fondo-emergente-cargando" class="fondo-emergente">
		<img src="imagenes/preload.gif" >
	</div>
	<div id="wrapper">
		<!-- Menu -->
		<jsp:include page="../menu.jsp"></jsp:include>
		<div class="container-fluid"> 
			<!-- Cuerpo -->
			<div class="row">
		 		<div class="page-header">		 			 
		 			<div class="col-lg-12">
		 				<br />
		 				<div class="panel panel-default">		 					
		 					<div class="panel-heading"><strong><%=user.getNombre() %></strong></div>
		 					<div class="panel-body">
		 					<%if (invitacion != null) { %>		 						
		 					
		 						<!-- Inicia Grid de datos -->
		 						<table class="table table-striped" id="table-invitaciones">
		 						<thead>
	                			<tr>       	                				         		
    	            				<th></th>         		
    	            				<th class="text-center">Concurso</th>
        	        				<th class="text-center">Fecha</th>            	    				
                					<th class="text-center">Dependencia</th>                					                					
                					<th class="text-center">Término</th>
	                			</tr>
    	            			</thead>
        	        			<tbody>
            	    		
	                		<%	for (int i = 0; i < invitacion.length; i++) {
    	            				ModelCotizacionProveedor inv = invitacion[i];
    	            				String sts = "PENDIENTE";
    	            				
    	            				if (inv.getTERMINADO().equals("T"))
    	            					sts = "TERMINADO";
        	        		%>
        	        				<input type="hidden" value="<%=inv.getLIST_ID() %>">
        	        				<tr id="<%=inv.getLIST_ID() %>">
        	        					<td class="text-center">
        	        						<div data-show="true" class="idcotiza" id="<%=inv.getLIST_ID() %>" cotId="<%=inv.getLIST_ID() %>" terminado="<%=inv.getTERMINADO() %>">
        	        							<span id="ico_cotiza" class="ico_cotiza glyphicon glyphicon-circle-arrow-right" aria-hidden="true"></span>
        	        						</div>
        	        					</td>
            	    					<td class="text-center"><strong><%=inv.getNUM_CONCURSO() %></strong></td>
                						<td class="text-center"><%=FormatosQPS.getFechaCorta(inv.getFECHAACTUAL()) %></td>	                					
    	            					<td><%=inv.getCENTROCOSTOS() %></td>	    	            				
    	    	        				<td class="text-center"><%=FormatosQPS.getFechaLarga(inv.getFECHATERMINACION()) %></td>
    	    	        				
    	            				</tr>
    	            		<%
    	            			String classInfo = "default";
    	            			boolean terminado = inv.getTERMINADO().equals("T");
    	            				
    	            			if (terminado)
    	            				classInfo = "warning";
    	            		%>
    	            				<tr id="det_<%=inv.getLIST_ID() %>" class="detalles <%=classInfo %>">
        	        					<td></td>
        	        					<td class="agrupador" colspan="6">
        	        						<div class="col-lg-12">
												<div class="col-lg-6">
													<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">Moneda:</div>
													<div class="col-lg-6"><%=inv.getMONEDA() %></div>
													<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">Contacto:</div>
													<div class="col-lg-6"><%=inv.getCOMPRADOR() %></div>
													<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">Teléfono:</div>
        	        								<div class="col-lg-6"><%=inv.getTELEFONO_COMPRADOR() %></div>
        	        								<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">Cot #:</div>
        	        								<div class="col-lg-6"><%=inv.getNUMERO() %></div>
												</div>
												<div class="col-lg-6">													
        	        								<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">Anticipo:</div>
													<div class="col-lg-6"><%=FormatosQPS.getBooleano(inv.getREQUIEREANTICIPO()) %></div>
													<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">% Ant:</div>
													<div class="col-lg-6"><%=FormatosQPS.getPorcentaje(inv.getPORCENTAJEANTICIPO()) %></div>
													<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;">Observaciones:</div>
        	        								<div class="col-lg-6"><%=inv.getOBSERVACIONESGENERALES() %></div>
												</div>   
											<%	String adjunto = portalSts.getRepositorio() + inv.getNUM_CONCURSO() + "_" + FormatosQPS.getAxo(inv.getFECHAACTUAL()) + ".pdf"; 
												
												String local = "/var/www/compras/documentos/Temp/DOCUMENTOADJUNTOINVITACION/" + inv.getNUM_CONCURSO() + "_" + FormatosQPS.getAxo(inv.getFECHAACTUAL()) + ".pdf";
												System.out.println("Adjunto: " + adjunto);
												if (Formatos.existeArchivo(local)) {
											%>
												<div class="col-lg-6">
													<div class="col-lg-4 text-right"  style="background-color: #F5F5F5;"><i class="fa fa-file-pdf-o"></i> Bases:</div>
													<div class="col-lg-6"><a href="<%=adjunto %>" download="<%=adjunto %>" target="_blank">Descarga las bases aquí</a></div>
												</div>     	        
											<% } %>							
        	        						</div>
        	        						
        	        						<!-- Aquí se llena el detalle -->        	        						
        	        						<div id="detalle" class="detalle col-lg-12"></div>        	
        	        						
        	        						<div class="row">
        	        							<div class="col-lg-8 text-right">
        	        						<% if (!inv.getCOTIZADOR().isEmpty()) {%>
        	        								<strong>Cotizó:</strong> <span><%=inv.getCOTIZADOR() %></span>
        	        						<% } %>	
        	        							</div>
        	        							<div class="col-lg-2 text-right" >
        	        								<!-- <a id="btn-print" href="PrintCotizacion.pdf?pk=<%=inv.getID() %>" class=" btn btn-default" target="_blank" title="Imprimir"><span class="glyphicon glyphicon-print"></span></a>  -->
        	        								<div id="btn-print" cotNo="<%=inv.getNUMERO() %>" idCotizacion="<%=inv.getID() %>" class="adjuntos-frm btn btn-default" title="Adjuntar archivos"><span class="glyphicon glyphicon-paperclip"></span></div>
        	        							</div>
        	        							<div class="col-lg-2 text-center">        	        							        	        					        	        							
        	        						<% 	Gson gson = new Gson();
        	        							String data = gson.toJson(inv);
        	        							data = inv.getID();
        	        							
        	        							if (!terminado) {         	        								        	        							        	        							
        	        						%>
        	        								<div id="btn-ok" data_item="<%=data.replace("\"", "\'") %>" class="finaliza-frm btn btn-default" ><span class="glyphicon glyphicon-log-out"></span> Enviar</div>
        	        						<%} %>
        	        								
        	        							</div>
        	        						</div>      						        	        			
        	        					</td>
        	        				</tr>      
        	        		<%	}	 %>       
        	        				   				                				                	
            	    			</tbody>
		 					</table>
		 					<%} else { %>
		 						<div class="alert alert-info" role="alert">
			 						<strong>Disculpa:</strong>
			 						No tienes asignada ninguna invitación pendiente a cotizar
			 					</div>
		 				<%} %>	
        
      						</div>
		 				</div>		 						 					 					 						 				
		 			</div>		 			
		 		</div>
		 	</div>			 			 		
		
			<!-- Pie -->
			<jsp:include page="../footer.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="modal fade" id="modal-msj" tabindex="0" role="dialog" aria-labelledby="" aria-hidden="true">
	<div class="modal fade" id="modal-msj2" tabindex="0" role="dialog" aria-labelledby="" aria-hidden="true">
</body>
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/Utilidades.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/typeahead.min.js"></script>
<script src="js/jquery-ready-cotiza.js"></script>     
<script src="js/jquery-ready-menu.js"></script>   
<script src="js/validator.js"></script>
<script src="js/moment-with-locales.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/jquery-barcode.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		Cotizaciones.init();
	});
</script>
</html>