<%@page import="gob.tlajomulco.ModelUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	HttpSession s = request.getSession(false);

	ModelUsuario user = new ModelUsuario();
	
	if (s.getAttribute("user") != null)
		user = (ModelUsuario) s.getAttribute("user");
%>
	<header>
	<div class="hidden-sm hidden-xs">
		<img src="imagenes/Layuout-pagina.png" alt="Tlajomulco" class="" height="150">
		<div id="logoGde">		
			<img src="imagenes/compras-rm.png" id="sp1" class="" style="float: right;">
		</div>
	</div>
	<div class="hidden-lg hidden-md">
		<div class="hidden-lg hidden-md">
                <div id="logoChi">
                    <h2>
                        <img src="imagenes/tlj-logo.png" alt="tlajomulco" width="50">
                        &nbsp;&nbsp;
                        <span id="spCh1">Recursos <strong><span id="spCh2">Materiales</span></strong></span>
                        &nbsp;&nbsp;
                    </h2>
                </div>
            </div>
	</div>

	<nav class="navbar navbar-inverse" role="navigation" id="menu"> 
		<div class="container-fluid">
		 		<div class="navbar-header">     
		 			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-main">
        				<span class="sr-only">Toggle navigation</span>
        				<span class="icon-bar"></span>
        				<span class="icon-bar"></span>
        				<span class="icon-bar"></span>
      				</button> 				
      				<a class="navbar-brand" href="index.jsp"><img src="imagenes/compras.png" alt="Web-Compras" /></a>
    			</div>
		 		
        		<div class="collapse navbar-collapse" id="navbar-main">
        			<ul class="nav navbar-nav">          				
        			 	<li class="dropdown"> 
        			 		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" >Transparencia<span class="caret"></span></a>
        			 		<ul class="dropdown-menu" role="menu">
    	        				<li><a href="#" id="Comprando">¿Qué esta comprando el Municipio?</a></li>                       
          					</ul>
        			 	</li>        				
        				<!-- <li><a href="#" >Marco Legal</a></li>  -->
        			 
        			</ul>
        			
        			<!-- Menú Proveedores -->
        	<% if (!user.getId().isEmpty()) { %>
        			<ul class="nav navbar-nav navbar-right" id="menuLeft">
       					<li class="dropdown">
          					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" ><%=user.getUsuario() %> <span class="caret"></span></a>
	          				<ul class="dropdown-menu" role="menu">
    	        				<li><a href="#" id="cambiaPasswd">Cambiar contraseña</a></li>            
        	    				<li class="divider"></li>
            					<li><a href="Invitaciones">Mis invitaciones</a></li>            			
            					<li><a href="#" id="cierraSesion">Cerrar sesión</a></li>            
          					</ul>
        				</li>
      				</ul>
      		<% } %>
        		</div>        	        	
		 </div>
		 </nav>
	</header>
	 