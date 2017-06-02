package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tempuri.ModelCotizacionProveedorDETALLE;

/**
 * Servlet implementation class SrvInvitacionDet
 */
@WebServlet("/InvitacionDet")
public class SrvInvitacionDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvInvitacionDet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		String pk = "";
		String terminado = "";
		
		if (req.getParameter("PK") != null)
			pk = req.getParameter("PK");
		if (req.getParameter("terminado") != null)
			terminado = req.getParameter("terminado");
		
		
		if (!pk.equals("")) {
			ComprasDAO db = new ComprasDAO();
			
			ModelCotizacionProveedorDETALLE[] det = db.getCotizacionProveedorDet(pk);
			
			req.setAttribute("detalle", det);
			req.setAttribute("cotId", pk);
			req.setAttribute("terminado", terminado);
			req.getRequestDispatcher("site/cotizaciones-det.jsp").forward(req, res);
		}
		
	}

}
