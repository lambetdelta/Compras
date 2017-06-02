package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelUsuario;
import gob.tlajomulco.config.Constantes;
import gob.tlajomulco.config.Estatus;
import gob.tlajomulco.utiles.Base64Coder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tempuri.ModelCotizacionProveedor;

/**
 * Servlet implementation class SrvInvitaciones
 */
@WebServlet("/Invitaciones")
public class SrvInvitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvInvitaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		HttpSession sesionOk = req.getSession(false);
		
		if (sesionOk != null)		
			if (sesionOk.getAttribute("user") != null) {
				ModelUsuario user = (ModelUsuario) sesionOk.getAttribute("user");				
				
				ComprasDAO db = new ComprasDAO();
				ModelCotizacionProveedor invitacion[] = db.getCotizacionProveedor(user.getUsuario(), Base64Coder.decode(user.getPassword()));
				
				if (invitacion != null)
					req.setAttribute("invitacion", invitacion);
				
				Estatus sts = Constantes.getEstatus(Constantes.getURL(req));				
				req.setAttribute("estatus", sts);

				req.getRequestDispatcher("site/cotizaciones.jsp").forward(req, res);
			} else
				res.sendRedirect("CierraSesion");
		else
			res.sendRedirect("CierraSesion");
		
	}

}
