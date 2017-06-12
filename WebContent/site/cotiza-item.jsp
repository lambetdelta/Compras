
<%@page import="gob.tlajomulco.utiles.Formatos"%>
<%@page import="gob.tlajomulco.utiles.FormatosQPS"%>
<%@page import="org.tempuri.ModelCotizacionProveedorDETALLE"%>
<%@page import="gob.tlajomulco.ModelUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%

	ModelCotizacionProveedorDETALLE d = new ModelCotizacionProveedorDETALLE();
	String cotId = "";
	String terminado = "";
	String attrDisable = "";

	double iva = 16;
	double ivaP = 0;
	double ieps = 0;
	double subtotal = 0;
	double total = 0;
	
	if (request.getAttribute("detalle") != null) {
		d = (ModelCotizacionProveedorDETALLE) request.getAttribute("detalle");
		if (request.getAttribute("cotId") != null)
			cotId = request.getAttribute("cotId").toString();
		if (request.getAttribute("terminado") != null)
			terminado = request.getAttribute("terminado").toString();
		if (terminado.equals("T"))
			attrDisable = "disabled=\"disabled\"";
		double cantidad = Double.parseDouble(d.getCANTIDAD());
		double precio = Double.parseDouble(d.getPRECIO_UNITARIO());
		iva = Double.parseDouble(d.getIVA());
		
		if (d.getIVAIE().equals(".0000"))
			d.setIVAIE("0.0000");
		
		if (precio > 0) {
			subtotal = cantidad * precio;
			ivaP = subtotal * (iva/100);
			ieps = Double.parseDouble(d.getIVAIE());
			total = subtotal + ivaP + ieps;
		} else
			iva = 16;
	}
	if(d.getID_ITEM() != null){
%>
	<link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">
	<div class="modal-dialog" id="dialog-cotizaitem">
		
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3><span class="glyphicon glyphicon-shopping-cart"></span> Cotizar partida: <%=d.getREFERENCIA() %></h3>
			</div>
		
		<div class="modal-body">
			
			<form id="cotiza-item" class="form-horizontal"  role="form" data-toggle="validator" data-disable="true" action="#" method="get" accept-charset="UTF-8">				
  				<div class="form-group">
  					<label class="control-label col-md-4" for="articulo">Artículo:</label>
    				<div class="col-md-8">
      					<input type="text" class="form-control" id="articulo" disabled="disabled" value="<%=d.getDESCRIPCION() %>">
    				</div>
    			</div>
    			<div class="form-group">
  					<label class="control-label col-md-4" for="cantidad">Cantidad:</label>
    				<div class="col-md-8">
    					<div class="input-group">
  							<span class="input-group-addon"><%=d.getUNIDAD_MEDIDA() %></span>
      						<input type="text" class="form-control text-right" id="cantidad" disabled="disabled" value="<%=d.getCANTIDAD() %>">
      					</div>
    				</div>
    			</div>
    			<div class="form-group">
  					<label class="control-label col-md-4" for="precio">Precio unitario:</label>
    				<div class="col-md-8">
      					<div class="input-group">
  							<span class="input-group-addon">$</span>
  							<input id="precio" type="text" pattern="[0-9]+([.][0-9]+)?" class="form-control text-right" placeholder="Precio unitario" value="<%=d.getPRECIO_UNITARIO() %>" <%=attrDisable %> required>  							
						</div>
    				</div>
    			</div>
    			<div class="form-group">
  					<label class="control-label col-md-4" for="iva">IVA:</label>
    				<div class="col-md-8">
      					<div class="input-group">
  							<span class="input-group-addon">%</span>
  							<input id="iva" type="number" min="0" max="100" class="form-control text-right" placeholder="Porcentaje de IVA" value="<%=iva %>" <%=attrDisable %> required>  							
						</div>
    				</div>
    			</div>
    			
    			<div class="form-group">
  					<label class="control-label col-md-4" for="subtotal">Subtotal:</label>
    				<div class="col-md-8">
    					<div class="input-group">
  							<span class="input-group-addon">$</span>
      						<input type="text" class="form-control text-right" id="subtotal" disabled="disabled" value="<%=Formatos.getFNumeroSingle(subtotal) %>">
      					</div>
    				</div>
    			</div>
    			<div class="form-group">
  					<label class="control-label col-md-4" for="ivaP">IVA:</label>
    				<div class="col-md-8">
    					<div class="input-group">
  							<span class="input-group-addon">$</span>
      						<input type="text" class="form-control text-right" id="ivaP" disabled="disabled" value="<%=Formatos.getFNumeroSingle(ivaP) %>">
      					</div>
    				</div>
    			</div>
    			<div class="form-group">
  					<label class="control-label col-md-4" for="ieps">IEPS:</label>
    				<div class="col-md-8">
      					<div class="input-group">
  							<span class="input-group-addon">$</span>
  							<input id="ieps" type="text" pattern="[0-9]+([.][0-9]+)?" class="form-control text-right" placeholder="IEPS" value="<%=Formatos.getFNumeroSingle(ieps) %>" <%=attrDisable %> required>  							
						</div>
    				</div>
    			</div>
    			<div class="form-group">
  					<label class="control-label col-md-4" for="total">Total:</label>
    				<div class="col-md-8">
    					<div class="input-group">
  							<span class="input-group-addon">$</span>
      						<input type="text" class="form-control text-right" id="total" disabled="disabled" value="<%=Formatos.getFNumeroSingle(total) %>">
      					</div>
    				</div>
    			</div>
    			
    			<input id="idItem" type="hidden" value="<%=d.getID_ITEM() %>">
    			<input id="terminado" type="hidden" value="<%=terminado %>">    			
    			<input id="cotId" type="hidden" value="<%=cotId %>">
			</form>
		</div>
		
		<div class="modal-footer">		
		<%if (terminado.equals("F")) {%>
			<button id="btn-ok" type="submit" class="btn btn-default" form="cotiza-item"><span class="glyphicon glyphicon-ok-sign"></span> Guardar</button>				
		<%} %>
			<button type="button" data-dismiss="modal" class="btn"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</button>
		</div>
	</div>
</div>
<script src="js/jquery-ready-cotiza-item.js" type="text/javascript"></script>
<% }else{ %>
	<div id="no-item">
		<div class="alert alert-info col-md-12" role="alert">
			Sin Datos que mostrar.
		</div>
	</div>
<% }%>