package gob.tlajomulco.servlet;

import java.io.IOException;
import java.util.ArrayList;

import gob.tlajomulco.utiles.Utilidades;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gob.tlajomulco.ComprasDAO;
import org.tempuri.CONCURSOSMODEL;
import com.google.gson.Gson;
/**
 * Servlet implementation class SrvComprandoAjax
 */
@WebServlet("/ComprandoAjax")
public class SrvComprandoAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvComprandoAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(request.getParameter("idRubros")!= null && request.getParameter("fecha_publicacion")!= null){
			String rubros="";
			String fecha_publicacion="";
//			String fecha_vencimiento="";
			ComprasDAO db = new ComprasDAO();
			CONCURSOSMODEL[] concursos;
			ArrayList <CONCURSOSMODEL[]> concursos_lista = new ArrayList <CONCURSOSMODEL[]> ();
			rubros=Utilidades.limpiar(request.getParameter("idRubros"));
			String [] id_rubros=rubros.split( ",");
			fecha_publicacion=Utilidades.limpiar(request.getParameter("fecha_publicacion"));
//			fecha_vencimiento=Utilidades.limpiar(request.getParameter("fecha_vencimiento"));
			for (int i = 0; i < id_rubros.length; i++) {
				concursos=db.getConcurso(id_rubros[i], fecha_publicacion);
				if(concursos != null)
					if(concursos.length > 0){
						concursos=Utilidades.limpiarTotal(concursos);
						concursos_lista.add(concursos);
					}
			}
			String respuesta=new Gson().toJson(concursos_lista);
			response.getWriter().write(respuesta);
		}
	}

}
