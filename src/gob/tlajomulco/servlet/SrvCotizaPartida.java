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
 * Servlet implementation class SrvCotizaPartida
 */
@WebServlet("/CotizaPartida")
public class SrvCotizaPartida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCotizaPartida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");		
		
		System.out.println("Hola ingresando a esto... SrvCotizaPartida");
		ModelCotizacionProveedorDETALLE d = new ModelCotizacionProveedorDETALLE();
		
		//String parametros = "1"; //req.getParameterNames().nextElement();
		
		String item = req.getParameter("item");
		String cotId = req.getParameter("cod");
		String terminado = req.getParameter("term");
		
		//System.out.println("Parámetros... " + parametros);
		
		if (item != null && !item.isEmpty()) {			
			//String[] data = parametros.split("\\|");
			//cotId = //data[0];
			//item = s1//data[1];
			//terminado = data[2];
			
			ComprasDAO ws = new ComprasDAO();
			d = ws.getCotizacionProveedorDet(cotId, item);
			
			req.setAttribute("detalle", d);
			req.setAttribute("cotId", cotId);			
			req.setAttribute("terminado", terminado);
			req.getRequestDispatcher("site/cotiza-item.jsp").forward(req, res);
			
		} else {
			// No hay datos para mostrar
			System.out.println("No hay datos para mostrar: " + item);
		}
	}

}
