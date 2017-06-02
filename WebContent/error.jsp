<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page isErrorPage="true"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
		<div class="container"> 
			<!-- Cuerpo -->
			<div class="row">
		 		<div class="page-header ">		 			 
		 			<div class="col-xs-12">
		 				<br />
		 				<div class="alert alert-danger">
		 					<h2>Disculpe las molestias</h2> 
		 					<h3 class="text-danger"><%=exception%></h3>
		 					<p>Error ocurrido: <br />
		 						<pre>
		 							<code><%exception.printStackTrace(new java.io.PrintWriter(out)); %></code>
		 						</pre>
		 					</p>		
			 			</div>		 			
		 			</div>
		 		</div>
		 	</div>			
			
			<!-- Pie -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="modal fade" id="modal-msj" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">	
</body>
</html>