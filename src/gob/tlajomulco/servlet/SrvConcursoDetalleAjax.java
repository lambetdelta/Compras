package gob.tlajomulco.servlet;

import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.utiles.Utilidades;
import org.tempuri.CONCURSOSMODEL_DETAIL;
import com.google.gson.Gson;
/**
 * Servlet implementation class SrvConcursoDetalleAjax
 */
@WebServlet("/ConcursoDetalleAjax")
public class SrvConcursoDetalleAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvConcursoDetalleAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("idConcurso") != null){
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String idConcurso=Utilidades.limpiar(request.getParameter("idConcurso"));
			CONCURSOSMODEL_DETAIL[] concurso_detalle;
			ComprasDAO db=new ComprasDAO();
			String respuesta="{'sin_resultados':true}";
			concurso_detalle=db.getConcursoDet(idConcurso);
			if(concurso_detalle != null)
				 respuesta=new Gson().toJson(concurso_detalle);
			response.getWriter().write(respuesta);
				
		}
	}

}
