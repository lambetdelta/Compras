<%@page import="gob.tlajomulco.ModelUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HttpSession s = request.getSession(false);

	ModelUsuario user = new ModelUsuario(); 
	
	if (s.getAttribute("user") != null)
		user = (ModelUsuario) s.getAttribute("user");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cambiar password</title>
<script src="js/jquery.bdt.js" type="text/javascript"></script>
<script src="js/jquery-ready-cpwd.js" type="text/javascript"></script>
</head>
<body>

<div class="modal-dialog" id="dialog-pass">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3>Cambiar contraseña</h3>
		</div>
						
		<div class="modal-body">
			<form id="PasswdForm" class="form-horizontal"  role="form" data-toggle="validator" data-disable="true" action="#" method="get" >	
			<div class="form-group">
    			<label class="control-label col-md-4" for="usuario">Usuario:</label>
    			<div class="col-md-8">
      				<input type="text" class="form-control" id="usuario" disabled="disabled" value="<%=user.getUsuario() %>">
    			</div>
  			</div>
  			<div class="form-group">
    			<label class="control-label col-md-4" for="passwdact">Password Actual:</label>
    			<div class="col-md-8">
      				<input type="password" class="form-control" id="passwdact" placeholder="Password actual" required >
    			</div>
  			</div>
  			<div class="form-group">
    			<label class="control-label col-md-4" for="passwdnew">Nuevo password:</label>
    			<div class="col-md-8">
      				<input type="password" class="form-control" id="passwdnew" placeholder="Password nuevo" required >
    			</div>
  			</div>
  			<div class="form-group">
    			<label class="control-label col-md-4" for="passwdnew2">Confirmar:</label>
    			<div class="col-md-8">
      				<input type="password" class="form-control" id="passwdnew2" placeholder="confirma" 
      					data-match="#passwdnew" data-match-error="Los password no son iguales" >
      				<div class="help-block with-errors"></div>
      				<div id="msj"></div>
    			</div>    			    		
  			</div>  
  			</form>			
  			
		</div>
		
		<div class="modal-footer">			
			<button type="button" data-dismiss="modal" class="btn"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</button>
			<button id="btn-cpok" type="submit" class="btn btn-default" form="PasswdForm"><span class="glyphicon glyphicon-ok-sign"></span> Cambiar</button>
		</div>
		
		
	</div>
</div>

</body>
</html>