package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelCotizacionItem;
import gob.tlajomulco.ModelUsuario;
import gob.tlajomulco.utiles.FormatosQPS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tempuri.EstrucuraRetornoUpdate;

import com.google.gson.Gson;

/**
 * Servlet implementation class SrvInvitacionItemSave
 */
@WebServlet("/InvitacionItemSave")
public class SrvInvitacionItemSave extends HttpServlet {

	private static final long serialVersionUID = -6403304001888756703L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SrvInvitacionItemSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");  // Devolvemos JSON
		res.setCharacterEncoding("UTF-8");
		
		String idItem = "";
		float precio = 0;
		String garantia = "";
		float cantidad = 0;
		String terminado = "";
		String cotId = "";
		float iva = 16;
		float ieps = 0;
		String observaciones = "";
		
		
		if (req.getParameter("idItem") != null)
			idItem = req.getParameter("idItem");
		if (req.getParameter("precio") != null)
			precio = Float.parseFloat(req.getParameter("precio"));
		if (req.getParameter("ieps") != null)
			ieps = Float.parseFloat(req.getParameter("ieps"));
		if (req.getParameter("garantia") != null)
			garantia = req.getParameter("garantia").trim().toUpperCase();
		if (req.getParameter("cantidad") != null)
			cantidad = Float.parseFloat(req.getParameter("cantidad"));
		if (req.getParameter("terminado") != null)
			terminado = req.getParameter("terminado");
		if (req.getParameter("cotId") != null)
			cotId = req.getParameter("cotId");
		if (req.getParameter("iva") != null)
			iva = Float.parseFloat(req.getParameter("iva"));
		if (req.getParameter("observaciones") != null)
			observaciones = req.getParameter("observaciones").trim().toUpperCase();
		
		EstrucuraRetornoUpdate upd = new EstrucuraRetornoUpdate();
		upd.setEXITO(false);		
		
		if (!idItem.isEmpty()) {
			// Leemos datos de la sesion
			HttpSession s = req.getSession(false);
			ModelUsuario user = new ModelUsuario(); 
			
			if (s.getAttribute("user") != null) 
				user = (ModelUsuario) s.getAttribute("user");
			
			ComprasDAO db = new ComprasDAO();
			
			ModelCotizacionItem item = new ModelCotizacionItem();
			item.setIdItem(idItem);
			item.setPrecioItem(precio);
			item.setFechaEntregaItem("");
			item.setGarantiaItem(garantia);
			item.setCantidadItem(cantidad);
			item.setTerminado(terminado);
			item.setUsuario(user.getUsuario());
			item.setIdCotizacion(FormatosQPS.convertToUTF8(cotId));
			item.setIvaPorcentaje(iva);
			item.setIvaIEPS(ieps);
			item.setObservaciones(observaciones);
			
			upd = db.updateCotizacionItem(item);
						
		} else {
			upd.setMENSAJE("Parámetros incompletos");
		}			
		
		Gson gson = new Gson();
		String json = gson.toJson(upd);
		System.out.println(json);
		res.getWriter().write(json);
	}

}
