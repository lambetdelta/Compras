<%@page import="gob.tlajomulco.CotizacionDetalleEx"%>
<%@page import="gob.tlajomulco.utiles.Formatos"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="gob.tlajomulco.utiles.FormatosQPS"%>
<%@page import="org.tempuri.ModelCotizacionProveedorDETALLE"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ModelCotizacionProveedorDETALLE[] det = null;

	if (request.getAttribute("detalle") != null) {
		det = (ModelCotizacionProveedorDETALLE[]) request.getAttribute("detalle");
		
		String cotId = "";
		String terminado = "";
		if (request.getAttribute("cotId") != null)
			cotId = request.getAttribute("cotId").toString();
		if (request.getAttribute("terminado") != null)
			terminado = request.getAttribute("terminado").toString();
%>

												<br />
												<table id="table-inv-det" class="table table-bordered table-hover">
        	        								<thead>
        	        									<tr>
        	        										<th class="text-center">item</th>
        	        										<th class="text-center">Artículo</th>
        	        										<th class="text-center">U.M.</th>        	        										
        	        										<th class="text-center">Cantidad</th>
        	        										<th class="text-center">Precio</th>
        	        										<th class="text-center">Subtotal</th>
        	        										<th class="text-center">IVA</th>
        	        										<th class="text-center">IEPS</th>
        	        										<th class="text-center">Total</th>        	        										
        	        										<th class="text-center"></th>
        	        									</tr>
        	        								</thead>
        	        								<tbody>
<%		
		double sumSubtotal = 0;
		double sumIva = 0;
		double sumIEPS = 0;
		double sumTotal = 0;
		for (int i = 0; i < det.length; i++) {
			ModelCotizacionProveedorDETALLE d = det[i];
			String claseRow = "";
			if (!d.getPRECIO_UNITARIO().equals("0.0000"))
				claseRow = "success";
			double cantidad = Double.parseDouble(d.getCANTIDAD());
			System.out.println("Precio: "+d.getPRECIO_UNITARIO());
			double precio = Double.parseDouble(d.getPRECIO_UNITARIO());
			double ivaP = Double.parseDouble(d.getIVA());
			double subtotal = cantidad * precio;
			double iva = subtotal * (ivaP / 100);
			double ieps = Double.parseDouble(d.getIVAIE());
			double total = subtotal + iva + ieps;
			
			sumSubtotal += subtotal;
			sumIva += iva;
			sumIEPS += ieps;
			sumTotal += total;
%>
														<tr id="partida-det-<%=d.getID_ITEM() %>" class="<%=claseRow %>">
        	        										<td class="text-center"><strong><%=d.getREFERENCIA() %></strong></td>
        	        										<td><span title="<%=d.getDETALLES() %>"><%=d.getDESCRIPCION() %></span></td>
        	        										<td class="text-center"><%=d.getUNIDAD_MEDIDA() %></td>
        	        										<td class="text-center" style="white-space: nowrap;"><%=d.getCANTIDAD() %></td>
        	        										<td class="text-right" style="white-space: nowrap;"><%=FormatosQPS.getMoneda(d.getPRECIO_UNITARIO()) %></td>
        	        										<td class="text-right" style="white-space: nowrap;"><%=Formatos.getFNumero(subtotal) %></td>
        	        										<td class="text-right" style="white-space: nowrap;"><%=Formatos.getFNumero(iva) %></td>
        	        										<td class="text-right" style="white-space: nowrap;"><%=Formatos.getFNumero(ieps) %></td>
        	        										<td class="text-right" style="white-space: nowrap;"><%=Formatos.getFNumero(total) %></td>
        	        										        	        										
        	        										<td class="text-center">
        	        											<div class="partida-link" href="" title="Cotizar" data_partida="<%=d.getID_ITEM() %>" cotId="<%=cotId %>" terminado="<%=terminado %>">
        	        												<span id="ico_cotiza" class="ico_cotiza glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
       	        												</div>        	        				
        	        										</td>
        	        									</tr>
<% 		} // Fin for %>
													</tbody>
													<tfoot>
														<tr>
															<td colspan="5"></td>
															<td class="text-right" style="white-space: nowrap;"><strong><%=Formatos.getFNumero(sumSubtotal) %></strong></td>
															<td class="text-right" style="white-space: nowrap;"><strong><%=Formatos.getFNumero(sumIva) %></strong></td>
															<td class="text-right" style="white-space: nowrap;"><strong><%=Formatos.getFNumero(sumIEPS) %></strong></td>
															<td class="text-right" style="white-space: nowrap;"><strong><%=Formatos.getFNumero(sumTotal) %></strong></td>
															<td colspan="1"></td>
														</tr>
													</tfoot>
												</table>
<%	} else {%>
								<div class="alert alert-info" role="alert">
			 						<strong>Disculpa:</strong>
			 						Esta cotización no contiene ninguna partida.
			 					</div>
<% } %>