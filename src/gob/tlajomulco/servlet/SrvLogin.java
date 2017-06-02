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

import org.tempuri.EstrucuraRetornoLOGIN;

/**
 * Servlet implementation class SrvLogin
 */
@WebServlet(description = "Inicio de sesion", urlPatterns = { "/Login" })
public class SrvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvLogin() {
        super();
                     
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		String usuario = "";
		String password = "";
		
		if (req.getParameter("usuario") != null)
			usuario = req.getParameter("usuario");
		
		if (req.getParameter("password") != null)
			password = req.getParameter("password");   
		
		ModelUsuario user = new ModelUsuario();
		
		if (usuario.isEmpty()) 
			user.setMensaje("Debe especificar un usuario");
		else if (password.isEmpty())
			user.setMensaje("Password no debe ser vacio");
		else {
			
			try {
			ComprasDAO db = new ComprasDAO();
						
			EstrucuraRetornoLOGIN l = db.login(usuario, password);
			
			if (l.isEXITO()) {								
				user.setId(l.getDATOS_CONSULTA().getID());				
				user.setNombre(l.getDATOS_CONSULTA().getNOMBRE());
				user.setUsuario(usuario);
				user.setPassword(Base64Coder.encode(password));
								
				HttpSession sesionOk = req.getSession(true);
				sesionOk.setAttribute("user", user);
				
				res.sendRedirect("Invitaciones");
				
			} else {
				System.out.println(l.getMENSAJE());
								
				req.setAttribute("msg", "Usuario y/o contraseña inválidos.");
				req.getRequestDispatcher("index.jsp").forward(req, res);
				
			}
			} catch(Exception e) {
				System.out.println(e.getMessage());
				
				req.setAttribute("msg", "Disculpe las molestias, servicio no disponible");
				req.getRequestDispatcher("index.jsp").forward(req, res);
			}				
		}				
	}

}
