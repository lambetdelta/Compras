

<%@page import="gob.tlajomulco.config.Estatus"%>
<%@page import="gob.tlajomulco.utiles.FormatosQPS"%>
<%@page import="gob.tlajomulco.ModelUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HttpSession s = request.getSession(false);

	ModelUsuario user = new ModelUsuario();
	String Mensaje = "";
	Estatus sts = new Estatus();
	
	if (s.getAttribute("user") != null)
		user = (ModelUsuario) s.getAttribute("user");
	
	if (request.getAttribute("msg") != null)
		Mensaje = request.getAttribute("msg").toString();
	
	if (request.getAttribute("estatus") != null) {
		sts = (Estatus) request.getAttribute("estatus");
	}
	
	if (sts.isActivo())
		sts.setTitulo("Ingreso Proveedores");
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

	<script src="js/jquery-1.11.3.min.js"></script>

	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/typeahead.min.js"></script>     
	<script src="js/jquery-ready-menu.js"></script>   
	<script src="js/validator.js"></script>
	<script src="js/jquery-barcode.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<!-- Menu -->
		<jsp:include page="menu.jsp"></jsp:include>
	
		<div class="container-fluid"> 
			<!-- Cuerpo -->
			<div class="row">
		 				 			 
		 			<div class="col-lg-8 hidden-sm hidden-xs">
		 			<div class="jumbotron">
		 				<h3>Bienvenido al portal de compras</h3> 
		 				<img alt="WebCompras" src="imagenes/compras-banner.png" class="pull-left Imagen-10">
		 				
  						<span class="text-justify">El sistema <strong>Web-Compras</strong> es la página en la que cualquier ciudadano podrá consultar en línea las 
  						requisiciones de los artículos que el Gobierno Municipal necesita adquirir.</span> <br />
  						<span> 
  						Si eres proveedor, podrás solicitar tu registro al sistema <strong>Web-Compras</strong>, con lo que tendrá acceso a:  
  						</span>
  						<ul>
  							<li>Enviar cotizaciones,</li>
  							<li>Revisar las requisiciones en las que participa y</li>
  							<li>Llevar un historial de sus participaciones</li>
  						</ul>
				
			 		</div></div>
		 			<div class="col-lg-4">
		 				<br />
		 				<div class="panel panel-default">
  							<div class="panel-heading">
  							<% if (user.getId().isEmpty()) { %>
    							<h3 class="panel-title"><%=sts.getTitulo() %></h3>
    						<%} else { %>
    							<h3 class="panel-title">Documentos:</h3>
    						<%} %>	
	  						</div>
  							<div class="panel-body">
  						<% if (user.getId().isEmpty()) { 
  								if (sts.isActivo()) {%>
    							<form id="loginForm" action="Login" method="post" drole="form" data-toggle="validator">
    								<div class="form-group">
    									<label for="usuario" >Usuario:</label>
    									<input name="usuario" id="usuario" class="form-control" placeholder="Usuario" required />
    									
    								</div>
    								<div class="form-group">
    									<label for="password" >Contraseña:</label>
    									<input name="password" id="password" class="form-control" type="password" 
    										placeholder="Password" required />
    									
    								</div>
    							<%if (!Mensaje.isEmpty()) {%>
    								<span class="label label-danger"><%=Mensaje %></span>
    								
    							<%} %>
    								<div class="text-right">
    									<button type="submit" class="btn btn-primary "><span class="glyphicon glyphicon-ok-sign"></span> Login</button>
    								</div>    								 
    							</form>
    							<%} else { %>
    							<!-- El Servicio no esta activo no esta activo -->
    							<span class="label label-danger"><%=sts.getMensaje() %></span>
    							<%} %>
    							<br>
    							<h4>Enlaces:</h4>
    					<% } %>
    							
    							
    							<div class="list-group">
  									<a href="http://tlajomulco.gob.mx/sites/default/files/transparencia/arboles/manualesogan/FormatoSolicitudAltaProveedor.pdf" class="list-group-item">
    									<span class="glyphicon glyphicon-cloud-download" aria-hidden="true"></span>
    									 Solicitud de alta como proveedor
  									</a>
  									<a href="http://www.tlajomulco.gob.mx/transparencia/articulo-8/Padron-provedores" class="list-group-item">
  										<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
  										Transparencia - Padron de Proveedores
  									</a>
  									<a href="http://www.tlajomulco.gob.mx/" class="list-group-item">
  										<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
  										Tlajomulco Gobierno Municipal
  									</a>
								</div>
  							</div>
						</div>
		 			</div>
		 		
		 	</div>			
			
			<!-- Pie -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="modal fade" id="modal-msj" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">	
</body>
</html>