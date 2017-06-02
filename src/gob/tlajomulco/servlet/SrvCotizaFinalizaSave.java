package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelCotizacionCabecera;
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
 * Servlet implementation class SrvCotizaFinalizaSave
 */
@WebServlet(description = "Guardamos la cotización cabecera", urlPatterns = { "/CotizaFinalizaSave" })
public class SrvCotizaFinalizaSave extends HttpServlet {
	private static final long serialVersionUID = 4741539806422291449L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCotizaFinalizaSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");  // Devolvemos JSON
		res.setCharacterEncoding("UTF-8");
		
		ModelCotizacionCabecera cab = new ModelCotizacionCabecera();
		
		// Leemos parámetros
		if (req.getParameter("nombreTipoPago") != null)
			cab.setNombreTipoPago(req.getParameter("nombreTipoPago"));
		if (req.getParameter("idTipoPago") != null)
			cab.setIdTipoPago(req.getParameter("idTipoPago"));
		if (req.getParameter("fechaEntrega") != null)
			cab.setFechaEntrega(FormatosQPS.getFechaQPS(req.getParameter("fechaEntrega")));
		if (req.getParameter("boExtencionId") != null)
			cab.setBoExtencionId(req.getParameter("boExtencionId"));
		if (req.getParameter("cotId") != null)
			cab.setIdCotizacion(req.getParameter("cotId"));
		if (req.getParameter("cotNo") != null)
			cab.setNumeroCotizacion(req.getParameter("cotNo"));
		if (req.getParameter("terminado") != null)
			cab.setTerminado(req.getParameter("terminado"));
		if (req.getParameter("cotizador") != null)
			cab.setCotizador(req.getParameter("cotizador").toUpperCase());
		if (req.getParameter("observaciones") != null)
			cab.setObservaciones(req.getParameter("observaciones").toUpperCase());
		if (req.getParameter("disculpa") != null)
			cab.setDisculpa(req.getParameter("disculpa").toUpperCase());
		if (req.getParameter("garantia") != null)
			cab.setGaratia(req.getParameter("garantia").toUpperCase());
		if (req.getParameter("dias") != null)
			cab.setDiasEntrega(Integer.parseInt(req.getParameter("dias")));
		
		System.out.println("Dias: " + cab.getDiasEntrega());
		// Leemos datos de la sesion
		HttpSession s = req.getSession(false);
		ModelUsuario user = new ModelUsuario();
		user = (ModelUsuario) s.getAttribute("user");
		
		cab.setUsuario(user.getUsuario());
		
		ComprasDAO db = new ComprasDAO();
		EstrucuraRetornoUpdate upd = db.updateCotizacionCabecera(cab);
		
		// Verificamos si hay que finalizar la cotización
		if (req.getParameter("finalizar") != null) {
			
			boolean finalizar =  Boolean.parseBoolean(req.getParameter("finalizar"));
			
			if (finalizar) {
				//cab.setTerminado("T");
				upd = db.updateCotizacionTerminado(cab);
				upd.setMENSAJE("T");
			}	
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(upd);
		res.getWriter().write(json);
	}

}
