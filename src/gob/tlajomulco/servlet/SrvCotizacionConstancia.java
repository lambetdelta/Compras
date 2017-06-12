package gob.tlajomulco.servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.IOException;
import java.util.Properties;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import org.apache.catalina.User;
import org.tempuri.ModelPadronProveedores;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowagie.text.Image;
import com.qoppa.pdfWriter.*;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelUsuario;
import gob.tlajomulco.config.Constantes;
import gob.tlajomulco.config.Estatus;
import gob.tlajomulco.utiles.PDF;
import gob.tlajomulco.utiles.Base64Coder;
import gob.tlajomulco.utiles.Email;
/**
 * Servlet implementation class SrvCotizacionConstancia
 */
@WebServlet("/CotizacionConstancia")
public class SrvCotizacionConstancia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCotizacionConstancia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		generatePDF(request, response);
		// TODO Auto-generated method stub
//		generatePDF(request, response);
		HttpSession sesionOk = request.getSession(false);
		ModelUsuario usuario= new ModelUsuario();
		if(sesionOk.getAttribute("user") != null){
			usuario = (ModelUsuario)sesionOk.getAttribute("user"); 
		}else
			response.getWriter().append("dddd");
		ModelPadronProveedores[] proveedores;
		ComprasDAO query = new ComprasDAO();
		proveedores = query.getDatosProveedor(usuario.getUsuario(),Base64Coder.decode(usuario.getPassword()));
		if(proveedores != null)
			response.getWriter().append(proveedores.toString());
		else
			response.getWriter().append(usuario.getUsuario());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		generatePDF(request, response);
//		HttpSession sesionOk = request.getSession(true);
//		ModelUsuario usuario= new ModelUsuario();
//		if(sesionOk.getAttribute("user") != null)
//			usuario = (ModelUsuario)sesionOk.getAttribute("user"); 
//		ModelPadronProveedores[] proveedores;
//		ComprasDAO query = new ComprasDAO();
//		proveedores = query.getDatosProveedor(usuario.getId());
//		System.out.println(proveedores.length); 
//		System.out.println("dwedwed"); 
	}
	private void generatePDF (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{ 
		
//		ServletOutputStream sOut = res.getOutputStream();
//		res.setContentType( "application/pdf" );  
//		res.setHeader("Content-disposition", "attachment; filename=" + "report.pdf" );
//		PDF pdf=new PDF();
//		pdf.setMargins(35, 25);
//		PDFPage page =pdf.makePage();
//		Graphics2D pencil = page.createGraphics();
//		pencil = pdf.setWidthBorder(pencil, 1);
//		pdf.recMainCotCons(pencil, 0, 0);
//		pdf.titleCotizacionConstancia(pencil,0,10);
//		pdf.containerDataProvider(pencil, 4, 28);
//		pdf.drawDataBidding(pencil, 30,135 , "Licitacion Numero: 0000000001", "Cotización Dirigida a:"
//				, "Requerimiento:", "Fecha:", "Observaciones:", "Fecha limite", "Condiciones de Pago:");
//		pdf.addPage(page);
//		pdf.saveDocument(sOut);
//		sOut.close();
//		Properties properties = System.getProperties();
////		Solo para pruebas, eliminar al montar y usar un servidor de smtp
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.socketFactory.port", "465");
//		properties.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.port", "465");
//		//Pruebas
//		String separador = System.getProperty("file.separator");
//		String path="C:" + separador+ "Users" + separador+ "Usuario" + separador
//				+ "workspace" + separador+ "Compras" + separador+ "WebContent" 
//				+ separador+ "documentos" + separador+ "WebProveedores" + separador 
//				+"0000004.pdf";
//		Email email = new Email("lambetdelta@hotmail.com", "test@gmail.com", "localhost", properties, "mail.smtp.host", "",
//				 "Osvaldo Uriel García",path,"Concurso.pdf");
//		email.sendEmail();
	}
}
