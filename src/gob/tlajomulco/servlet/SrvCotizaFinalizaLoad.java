package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelUsuario;
import gob.tlajomulco.utiles.Base64Coder;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.tempuri.ModelCATTIPOPAGO;
import org.tempuri.ModelCotizacionProveedor;

/**
 * Servlet implementation class SrvCotizaFinalizaLoad
 */
@WebServlet("/CotizaFinalizaLoad")
public class SrvCotizaFinalizaLoad extends HttpServlet {

	private static final long serialVersionUID = -8992829843088157985L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCotizaFinalizaLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		ModelCotizacionProveedor cot = new ModelCotizacionProveedor();
		String data = req.getParameterNames().nextElement(); //FormatosQPS.convertToUTF8(req.getParameterNames().nextElement());
		
		//Gson gson = new Gson();
		//cot = (ModelCotizacionProveedor) gson.fromJson(data, ModelCotizacionProveedor.class);
		
		// Obtenemos los tipos de pago
		ComprasDAO db = new ComprasDAO(); 
		ModelCATTIPOPAGO[] tp = db.getCatalogoTipoPago();
		
		System.out.println("Tipo pago: " + tp);
		HttpSession sesionOk = req.getSession(false);
		if (sesionOk != null){		
			if (sesionOk.getAttribute("user") != null) {
				ModelUsuario user = (ModelUsuario) sesionOk.getAttribute("user");
				cot = db.getCotizacionProveedor(data, user.getUsuario(), Base64Coder.decode(user.getPassword()));

				System.out.println("Cotizacion: "+cot);
				
				req.setAttribute("cotizacion", cot);
				req.setAttribute("tipoPago", tp);
				req.getRequestDispatcher("site/cotiza-termino.jsp").forward(req, res);
			}else
				res.getWriter().write("dqwwqd");
		}else
			res.getWriter().write("ddddd");
	}
}
