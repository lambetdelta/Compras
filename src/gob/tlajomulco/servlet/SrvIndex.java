package gob.tlajomulco.servlet;

import gob.tlajomulco.config.Constantes;
import gob.tlajomulco.config.Estatus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrvIndex
 */
@WebServlet("/index.jsp")
public class SrvIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8"); // Devolvemos una html
		
		Estatus sts = Constantes.getEstatus(Constantes.getURL(req));
		
		req.setAttribute("estatus", sts);
		req.getRequestDispatcher("inicio.jsp").forward(req, res);
	}
}
