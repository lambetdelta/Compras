<%@page import="org.tempuri.ModelCATTIPOPAGO"%>
<%@page import="org.tempuri.ModelCotizacionProveedor"%>
<%@page import="gob.tlajomulco.utiles.FormatosQPS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ModelCotizacionProveedor cot = new ModelCotizacionProveedor();
	ModelCATTIPOPAGO[] tipoPago = null;
	
	if (request.getAttribute("cotizacion") != null) {
		cot = (ModelCotizacionProveedor) request.getAttribute("cotizacion");		
	}
	
	if (request.getAttribute("tipoPago") != null)
		tipoPago = (ModelCATTIPOPAGO[]) request.getAttribute("tipoPago");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cotiza Fin</title>

<link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">

<script src="js/jquery-ready-cotiza-final.js" type="text/javascript"></script>
</head>
<body>
	<div class="modal-dialog" id="dialog-cotizafin">		
		<div class="modal-content">
		
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3><span class="glyphicon glyphicon-shopping-cart"></span>Cotización: <%=cot.getNUMERO() %></h3>
			</div>
		
			<div class="modal-body">			
				<form id="cotiza-finaliza" class="form-horizontal"  role="form" data-toggle="validator" data-disable="true" action="#" method="get" accept-charset="UTF-8">				
  					<div class="form-group">
  						<label class="control-label col-md-4" for="Dependencia">Dependencia:</label>
    					<div class="col-md-8">
      						<input type="text" class="form-control" id="Dependencia" name="Dependencia" disabled="disabled" value="<%=cot.getCENTROCOSTOS() %>" >
    					</div>
    				</div>
    				<div class="form-group">
  						<label class="control-label col-md-4" for="dias" title="Límite de entrega">Entrega:</label>
    					<div class="col-md-8">
    						<div class="input-group">
  								<span class="input-group-addon">Días</span>
      							<input type="number" class="form-control text-right" id="dias" min="1" value="<%=cot.getTIEMPOENTREGA() %>">
      						</div>
      					</div>
	    			</div>
    				<div class="form-group">
  						<label class="control-label col-md-4" for="tipo-pago">Tipo de pago:</label>
    					<div class="col-md-8">    					
      						<select id="tipo-pago" name="tipo-pago" class="form-control" title="(Selecciona una opción)" required>
      							<option value="pleaseSelect" selected="selected" disabled="disabled">(Seleccione un tipo de pago)</option>      						        						 					
	      				<% for (int i=0; i < tipoPago.length; i++) { 
	      					String sel = "";
	      					if (tipoPago[i].getDESCRIPCION().equals(cot.getTIPO_PAGO()))
	      						sel = "selected=\"selected\"";
	      				%>
    	  						<option value="<%=tipoPago[i].getID() %>" <%=sel %>><%=tipoPago[i].getDESCRIPCION() %></option>
      					<% } %>
      						</select>
    					</div>
    				</div>
	    			<div class="form-group">
  						<label class="control-label col-md-4" for="cotizador" title="Nombre de quien cotiza">Cotizador:</label>
    					<div class="col-md-8">
    						<div class="input-group">
  								<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
      							<input type="text" class="form-control" id="cotizador" name="cotizador"  value="<%=cot.getCOTIZADOR() %>" style="text-transform:uppercase;" required >
      						</div>
	    				</div>
    				</div>   
    				
    				<div class="form-group">
  						<label class="control-label col-md-4" for="garantia">Garantia <span style="font-weight: initial">*</span>:</label>
    					<div class="col-md-8">    							
      						<textarea rows="3" cols="100%" class="form-control" id="garantia" required="required"><%=cot.getGARANTIA() %></textarea>      					
    					</div>
    				</div>
    				<div class="form-group">
  						<label class="control-label col-md-4" for="observaciones">Observaciones:</label>
    					<div class="col-md-8">    							
      						<textarea rows="3" cols="100%" class="form-control" id="observaciones"><%=cot.getOBSERVACIONES() %></textarea>      					
    					</div>
    				</div>
    			
    				<div class="form-group">
  						<label class="control-label col-md-4" for="disculpa">Disculpas:</label>
    					<div class="col-md-8">    							
      						<textarea rows="2" cols="100%" class="form-control" id="disculpa"><%=cot.getDISCULPA() %></textarea>      					
    					</div>
    				</div>
    				
    				<div class="row"> 			  				
		    			<div class="col-md-12">
		    				<!--
    						<div class="checkbox text-right">
  								<label title="Al finalizar una cotización no será posible actualizar precios de sus partidas, ni la información de entrega">
  								<input type="checkbox" id="finalizar" name="finalizar">¿Desea finalizar esta cotización?</label>
      						</div>    
      						<br /> -->  	
      						<span>(*)Campos obligatorios</span>			
	      					<div class="alert alert-info col-md-12" role="alert">
    	  						Al finalizar una cotización no será posible actualizar precios de sus partidas, ni la información de entrega
      						</div>
    					</div>
    				</div>
    			    			    		
    				<input id="cotId" type="hidden" value="<%=cot.getLIST_ID() %>">
    				<input id="cotIdInvitacion" type="hidden" value="<%=cot.getID() %>">
    				<input id="cotNo" type="hidden" value="<%=cot.getNUMERO() %>">
    				<input id="terminado" type="hidden" value="<%=cot.getTERMINADO() %>">    			
    				<input id="boExtencionId" type="hidden" value="<%=cot.getBOEXTENSION_ID() %>">
    				
				</form>
			</div>
		
			<div class="modal-footer">						
		<% if (cot.getTERMINADO().equals("F")) { %>			
				<button id="btn-ok" type="submit" class="btn btn-default" form="cotiza-finaliza" value="true"><span class="glyphicon glyphicon-send" ></span>Enviar</button>
				<!-- <button id="btn-ok" type="submit" class="btn" form="cotiza-finaliza" value="false"><span class="glyphicon glyphicon-ok-sign" ></span> Guardar</button> -->
		<% } %>
				<button type="button" data-dismiss="modal" class="btn"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</button>
			</div>
		</div>
	</div>
</body>
</html>