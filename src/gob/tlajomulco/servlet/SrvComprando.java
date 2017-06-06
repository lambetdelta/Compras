package gob.tlajomulco.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tempuri.ModelRUBROS;
import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.config.Constantes;
import gob.tlajomulco.config.Estatus;

/**
 * Servlet implementation class SrvComprando
 */
@WebServlet("/Comprando")
public class SrvComprando extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvComprando() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		//HttpSession sesionOk = req.getSession(false);
		
		ComprasDAO db = new ComprasDAO();
		ModelRUBROS[] rubros = null;
		
		rubros = db.getRubros();
		Estatus status = Constantes.getEstatus(Constantes.getURL(req));
		req.setAttribute("status", status);
		if (rubros.length > 0)
			req.setAttribute("rubros", rubros);
	
		req.getRequestDispatcher("comprando.jsp").forward(req, res);
	}
}
