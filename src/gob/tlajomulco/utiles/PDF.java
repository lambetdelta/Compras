/*Las medidas deben ser dadas en pulgadas
 * Las posiciones de X y Y se calculan con base en los margenes
 * La unidad de graficos es de 72 puntos por pulgada*/
package gob.tlajomulco.utiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;
import gob.tlajomulco.utiles.ManejadorFechas;

public class PDF extends PDFDocument {
	private double margin_left;
	private double margin_top;
	private double width;
	private double height;
	private int x_original;
	private int y_original;
	private int x;
	private int y;
	private int marginText;
	
	public  PDF(){
		super();
		this.margin_left = 35.5;
		this.margin_top = 35.5;
		this.marginText = 5;
		this.setXYOriginal((int)this.margin_left, (int)this.margin_top);
	}
	private PageFormat configPage(){
		//configurar una hoja y retornarla
		PageFormat page = new PageFormat();
		Paper paper = new Paper ();
		paper.setSize(595, 842);
		this.setMeasure((paper.getWidth() - (this.margin_left)), (paper.getHeight() - (this.margin_top)));
		paper.setImageableArea(this.margin_left, this.margin_top, this.width,
                this.height);
		page.setOrientation(PageFormat.PORTRAIT);
		page.setPaper(paper);
		return page;
	}
	public Graphics2D titleCotizacionConstancia(Graphics2D page,int x, int y){
		this.setXY(x,y);
		this.newFont(page, "Times New Roman", 15,Font.BOLD);
		int post = (int)(this.width / 4);
		int pos2 = ((int)(this.width / 3)) + 20;
		page.drawString("Municipio de Tlajomulco de Zuñiga, Jalisco", post, this.y+4);
		page.drawString("Constancia de Cotización", pos2, this.y+15);
		this.headerDateCotCon(page);
		return page;
	}
	private Graphics2D headerDateCotCon(Graphics2D page){
		this.headerDateCotConDate(page);
		this.headerDateCotConHour(page);
		return page;
	}
	private Graphics2D  headerDateCotConDate(Graphics2D page){
		this.newFont(page, "Times New Roman", 8,Font.PLAIN);
		int post = (int)(this.width / 6) * 5;
		String fecha="Fecha:" + ManejadorFechas.getFechaActual("dd-MM-yyyy");
		page.drawString(fecha, post, this.y + 4);
		return page;
	}
	private Graphics2D  headerDateCotConHour(Graphics2D page){
		this.newFont(page, "Times New Roman", 8,Font.PLAIN);
		int post = (int)(this.width / 6) * 5;
		String hora="Hora:" + ManejadorFechas.getHoraActual("hh:mm:ss a");
		page.drawString(hora, post, this.y + 15);
		return page;
	} 
	public Graphics2D containerDataProvider(Graphics2D page, int x, int y){
		this.setXY(x,y);
		this.newFont(page, "Times New Roman", 7,Font.PLAIN);
		String name="Proveedor";
		int width = ((int) this.width) - 13;
		this.drawrProviderName(page,name, this.x, this.y, width, 15);
		this.drawDataGeneralProvider(page, this.x, (this.y + 15),"Nombre:", "Representante Legal:",
				"Agente de Ventas:", "RFC:", "Tel:", "Fax:", "Email:");
		return page;
	}
	public Graphics2D drawDataBidding(Graphics2D page, int x, int y,String no_bidding,String target_bidding,
			String request, String date,String observations, String date_limit, String payconditions){
		x += this.marginText;
		int y_original=y;
		int x_separator = (int)(this.width / 5); 
		page.drawString(no_bidding, x, y);
		y += 10;
		page.drawString(target_bidding, x, y);
		y = y_original;
		x += x_separator;
		page.drawString(request, x, y);
		y = y_original;
		x += x_separator;
		page.drawString(date, x, y);
		page.drawString(observations, x, (y + 10));
		y = y_original;
		x += x_separator;
		page.drawString(payconditions, x, y);
		x += x_separator;
		this.drawDateLimitBidding(page, x, y, date_limit);
		return page;
	}
	private Graphics2D drawContainerDateLimitBidding(Graphics2D page, int x, int y){
		Color color= new Color(222,222,222);
		int width = (int)(this.width / 6);
		this.drawRecWithFilligAndBorder(page, x, y, width, 25, color);
		this.drawRecWithFilligAndBorder(page, x, (y + 25), width, 10, color);
		return page;
	}
	private Graphics2D drawRecWithFilligAndBorder(Graphics2D page, int x,int y, int width, int heigth, Color color){
		page.setColor(color);
		page.fillRect(x, y, width, heigth);
		page.setColor(Color.black);
		page.drawRect(x, y, width, heigth);
		return page;
	}
	private void drawImage(Graphics2D page, int x, int y, String path_){
		String separador = System.getProperty("file.separator");
		String path="C:" + separador+ "Users" + separador+ "Usuario" + separador
				+ "workspace" + separador+ "Compras" + separador+ "WebContent" 
				+ separador+ "documentos" + separador+ "WebProveedores" + separador 
				+"tlj-logo.png";
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e) {
		}
		page.drawImage(img, 40, 40, null);
	}
	private Graphics2D drawDateLimitBidding(Graphics2D page, int x, int y, String date_limt){
		y -= 10;
		this.drawContainerDateLimitBidding(page, x, y);
		y += 10;
		x += this.marginText;
		this.newFont(page, "Times New Roman", 6,Font.BOLD);
		page.drawString("Fecha Limite de Entrega de", x, y);
		page.drawString("la Cotización", x, (y + 10));
		this.newFont(page, "Times New Roman", 6,Font.PLAIN);
		page.drawString(date_limt, x, (y + 22));
		return page;
	}
	public Graphics2D drawTableItems(Graphics2D page){
		return page;
	}
	private Graphics2D drawDataGeneralProvider(Graphics2D page,int x, int y,String name, String legal_repr,
			String salesperson,String rfc,String tel,String fax,String email){
		this.newFont(page, "Times New Roman", 6,Font.PLAIN);
		this.drawContainerDataGenPro(page, x, y);
		x += this.marginText;
		int y_original=y;
		y += 10;
		page.drawString(name, x, y);
		y += 10;
		page.drawString(legal_repr, x, y);
		y += 10;
		page.drawString(salesperson, x, y);
		y += 10;
		page.drawString(rfc, x, y);
		x =(int)(this.width / 2);
		y = y_original + 10;
		page.drawString(tel, x, y);
		y += 10;
		page.drawString(fax, x, y);
		y += 10;
		page.drawString(email, x, y);
		return page;
	}
	private Graphics2D drawContainerDataGenPro(Graphics2D page,int x, int y){
		Color color=new Color(250,250,250);
		page.setColor(color);
		int width = ((int) this.width) - 13;
		page.fillRect(x, y, width, 45);
		page.setColor(Color.black);
		page.drawRect(x, y, width, 45);
		return page;
	}
	private Graphics2D drawrProviderName(Graphics2D page, String name,int x, int y,int width,int height){
		Color color=new Color(222,222,222);
		page.setColor(color);
		page.fillRect(x, y, width, height);
		page.setColor(Color.black);
		page.drawString(name, (x +5), (y +10));
		page.drawRect(x, y, width, height);
		return page;
	}
	public Graphics2D recMainCotCons(Graphics2D page,int x, int y){
		this.setXY(x,y);
		int width=(int)this.width -5;
		page.drawRect(this.x, this.y, width, 200);
		return page;
	}
	public PDFPage makePage(){
		return this.createPage(this.configPage());
	}
	public  void setMargins(double margin_top, double margin_left){
		this.margin_top = margin_top;
		this.margin_left = margin_left;
		this.setXYOriginal((int)margin_left, (int)margin_top);
	}
	public Graphics2D newFont(Graphics2D g,String name, int size,int style) {
	    Font font = new Font(name, style, size);
	    g.setFont(font);
	    return g;
	}
	private void setMeasure(double x,double y){
		this.setWidth(x);
		this.setHeight(y);
	}
	private void setWidth(double x){
		this.width=x - 20;
	}
	private void setHeight(double y){
		this.height=y;
	}
	private void setXY(int x, int y){
		x = this.x_original + x;
		y = this.y_original + y;
		this.setX(x);
		this.setY(y);
	}
	private void setXYOriginal(int x, int y){
		this.x_original = x;
		this.y_original = y;
	}
	private void setX(int x){
		this.x=x;
	
	}
	private void setY(int y){
		this.y=y;
	
	}
	public Graphics2D setWidthBorder(Graphics2D page,int pixel){
		BasicStroke stroke = new BasicStroke(pixel);
		page.setStroke(stroke);
		return page;
	}
}
