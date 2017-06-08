package gob.tlajomulco.servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.tomcat.jni.File;

import com.lowagie.text.Image;
import com.qoppa.pdfWriter.*;

import gob.tlajomulco.config.Constantes;
import gob.tlajomulco.config.Estatus;
import gob.tlajomulco.utiles.PDF;

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
		generatePDF(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		generatePDF(request, response);
	}
	private void generatePDF (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{ 
	
//		ServletContext srvcon = getServletContext();
//		String rutafisica = srvcon.getRealPath("tlj-logo.png");
//		java.awt.Image imagenInterna = new ImageIcon(
//		           getClass().getResource(rutafisica)).getImage();
		// Get servlet output stream
		ServletOutputStream sOut = res.getOutputStream();
		res.setContentType( "application/pdf" );  
		res.setHeader("Content-disposition", "attachment; filename=" + "report.pdf" );
		PDF pdf=new PDF();
		pdf.setMargins(35, 25);
		PDFPage page =pdf.makePage();
		Graphics2D pencil = page.createGraphics();
		pencil = pdf.setWidthBorder(pencil, 1);
		pdf.recMainCotCons(pencil, 0, 0);
		pdf.titleCotizacionConstancia(pencil,0,10);
		pdf.containerDataProvider(pencil, 4, 28);
		pdf.addPage(page);
		pdf.saveDocument(sOut);
		sOut.close();
	}
}
