package gob.tlajomulco.servlet;


import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelUsuario;
import gob.tlajomulco.config.Constantes;
import gob.tlajomulco.utiles.Base64Coder;
import gob.tlajomulco.utiles.Formatos;
import gob.tlajomulco.utiles.FormatosQPS;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.tempuri.ModelCotizacionProveedor;
import org.tempuri.ModelCotizacionProveedorDETALLE;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

/**
 * Servlet implementation class SrvPrintCotizacion
 */
@WebServlet("/PrintCotizacion.pdf")
public class SrvPrintCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SrvPrintCotizacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		String pk = "";
		if (req.getParameter("pk") != null)
			pk = FormatosQPS.convertToUTF8(req.getParameter("pk"));

		System.out.println("Ingresando ala impresión..." + pk);

		HttpSession sesionOk = req.getSession(false);

		if (sesionOk != null)		
			if (sesionOk.getAttribute("user") != null) {
				ModelUsuario user = (ModelUsuario) sesionOk.getAttribute("user");

				ComprasDAO db = new ComprasDAO();
				ModelCotizacionProveedor cot = db.getCotizacionProveedor(pk, user.getUsuario(), Base64Coder.decode(user.getPassword()));
				ModelCotizacionProveedorDETALLE items[] = db.getCotizacionProveedorDet(cot.getLIST_ID());

				String pdf = "Cotización-" + cot.getNUMERO() + ".pdf";
				res.setContentType("application/pdf"); // Aqui ya regresamos un PDF
				res.setHeader("Content-disposition","inline; filename="+ pdf);  
				res.setHeader("Pragma", "cache");  
				res.setHeader("Expires", "0");  
				res.setHeader("Cache-control", "private");

				String css = Constantes.getURL(req) + "/css/cotiza.css";
				StringBuffer buf = new StringBuffer();

				// Encabezados de HTML
				buf.append("<!DOCTYPE html><html><head><meta charset='UTF-8'></meta><title>Cotización de Proveedor</title>");
				buf.append("<link rel='stylesheet' type='text/css' href='" + css + "' media='print' />");
				buf.append("</head><body>");
				// Titulo de la cotizacion
				buf.append("	<div id='fondo'>");
				buf.append("		<div id='titulo'>");
				buf.append("            <table id='gridTitulo'>");
				buf.append("                <tr><th>COTIZACION:</th> <td><span id='folio' class='txt-negrita'>"+ cot.getNUMERO() +"</span></td></tr>");
				buf.append("                <tr><th>Requerimiento:</th><td>"+ cot.getREQUERIMINTO() +"</td></tr>");
				buf.append("                 <tr><th>Fecha:</th><td>"+ FormatosQPS.getFechaCorta(cot.getFECHAACTUAL()) +"</td></tr>");
				buf.append("                 <tr><th>Días entrega:</th><td>"+ cot.getTIEMPOENTREGA() +"</td></tr>");
				//buf.append("                 <tr><th>F. Límite:</th><td>"+ FormatosQPS.getFechaLarga(cot.getFECHATERMINACION()) +"</td></tr>");
				buf.append("                <tr><th>Moneda:</th><td>"+ cot.getMONEDA() +"</td></tr>");
				buf.append("                <tr><th>Dependencia:</th><td>"+ cot.getCENTROCOSTOS() +"</td></tr>");
				buf.append("                <tr><th>Proveedor:</th><td>"+ cot.getPROVEEDOR() +"</td></tr>");
				buf.append("            </table>");
				buf.append("            <div id='impresion'>Fecha de impresión: "+ Formatos.getHoyStr() +"</div>");
				buf.append("        </div>");
				// Partidas de la cotización encabezado
				buf.append("        <div id='partidas'>");
				buf.append("            <table id='gridPartidas'><thead>");
				buf.append("            		<tr class='txt-centrar'><th>#</th><th>Descripción</th><th>Cantidad</th><th>Precio</th><th>Subtotal</th><th>IVA</th><th>IEPS</th><th>Total</th></tr>");
				buf.append("				</thead>");
				// Partidas de la cotización detalle
				buf.append("            	<tbody>");
				double sumSubtotal = 0;
				double sumIva = 0;
				double sumaIeps = 0;
				double sumTotal = 0;
				boolean marcar = false;
				for (int i = 0; i < items.length; i++) {
					ModelCotizacionProveedorDETALLE d = items[i];
					double cantidad = Double.parseDouble(d.getCANTIDAD());
					double precio = Double.parseDouble(d.getPRECIO_UNITARIO());
					double ivaP = Double.parseDouble(d.getIVA());
					double subtotal = cantidad * precio;
					double iva = subtotal * (ivaP / 100);
					double ieps = Double.parseDouble(d.getIVAIE());
					double total = subtotal + iva + ieps;

					sumSubtotal += subtotal;
					sumIva += iva;
					sumaIeps +=ieps;
					sumTotal += total;

					String cMarca = "";
					if (marcar)
						cMarca = "rowmarca";

					buf.append("            		<tr>");
					buf.append("            			<td class='txt-centrar "+ cMarca +"'>"+ d.getREFERENCIA() +"</td>");
					buf.append("            			<td class='"+ cMarca +"'>"+ d.getDESCRIPCION() +"</td>");
					buf.append("            			<td class='txt-derecha "+ cMarca +"'>"+ Formatos.getFNumero(cantidad) +"</td>");
					buf.append("            			<td class='txt-derecha "+ cMarca +"'>"+ Formatos.getFNumero(precio) +"</td>");
					buf.append("            			<td class='txt-derecha "+ cMarca +"'>"+ Formatos.getFNumero(subtotal) +"</td>");
					buf.append("            			<td class='txt-derecha "+ cMarca +"'>"+ Formatos.getFNumero(iva) +"</td>");
					buf.append("            			<td class='txt-derecha "+ cMarca +"'>"+ Formatos.getFNumero(ieps) +"</td>");
					buf.append("            			<td class='txt-derecha "+ cMarca +"'>"+ Formatos.getFNumero(total) +"</td>");
					buf.append("            		</tr>");

					marcar = !marcar;
				}		
				buf.append("            	</tbody>");

				// Partidas de la cotizacion pie
				buf.append("            	<tfoot>");
				buf.append("            		<tr> <th colspan='4'></th>");
				buf.append("            			<th class='txt-derecha'>"+ Formatos.getFNumero(sumSubtotal) +"</th>");
				buf.append("            			<th class='txt-derecha'>"+ Formatos.getFNumero(sumIva) +"</th>");
				buf.append("            			<th class='txt-derecha'>"+ Formatos.getFNumero(sumaIeps) +"</th>");
				buf.append("            			<th class='txt-derecha'>"+ Formatos.getFNumero(sumTotal) +"</th>");
				buf.append("            		</tr>");
				buf.append("            	</tfoot>");
				buf.append("        	</table>");

				// Aca imprimimos observaciones o discuplas
				buf.append("<br></br>");
				if (!cot.getGARANTIA().isEmpty())
					buf.append("<div id='garantia'><strong>Garantía</strong><br></br>"+ cot.getGARANTIA() +"</div>");
				buf.append("<br></br>");
				if (!cot.getOBSERVACIONES().isEmpty())
					buf.append("<div id='observaciones'><strong>Observaciones</strong><br></br>"+ cot.getOBSERVACIONES() +"</div>");

				if (!cot.getDISCULPA().isEmpty()) {
					buf.append("<br></br>");
					buf.append("<div id='disculpas'><strong>Disculpas:</strong><br></br>"+ cot.getDISCULPA() +"</div>");			
				}

				// Firma del cotizador
				if (!cot.getCOTIZADOR().isEmpty()) {
					buf.append("            <br></br><br></br>");
					buf.append("        	<div class='txt-centrar'><strong>COTIZÓ:</strong>");
					buf.append("        		<br></br><br></br>");
					buf.append("                _________________________________________<br></br>" + cot.getCOTIZADOR());
					buf.append("        	</div>");
				}
				buf.append("        </div>");
				buf.append("	</div>");
				buf.append("</body></html>");


				// Construimos PDF
				try {
					DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
					String html =  buf.toString();
					System.out.println(html);

					StringReader sr = new StringReader(html);
					InputSource is = new InputSource(sr);

					Document doc = builder.parse(is);
					ITextRenderer rend = new ITextRenderer();
					rend.setDocument(doc, "http://127.0.0.1:" + req.getServerPort());
					rend.layout();

					OutputStream os = res.getOutputStream();
					rend.createPDF(os);
					os.close();				
				} catch (ParserConfigurationException | SAXException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	}

}
