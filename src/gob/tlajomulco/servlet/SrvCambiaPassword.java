package gob.tlajomulco.servlet;

import gob.tlajomulco.ComprasDAO;
import gob.tlajomulco.ModelMensajes;
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

import com.google.gson.Gson;

/**
 * Servlet implementation class SrvCambiaPassword
 */
@WebServlet("/CambiaPassword")
public class SrvCambiaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCambiaPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");  // Devolvemos JSON
		res.setCharacterEncoding("UTF-8");
		
		String passwdAct = "";
		String passwdNew = "";
		ModelMensajes msj = new ModelMensajes();
		
		// Obtenemos parámetros necesarios
		if (req.getParameter("passwdact") != null)
			passwdAct = req.getParameter("passwdact");
		if (req.getParameter("passwdnew") != null)
			passwdNew = req.getParameter("passwdnew");
		
		System.out.println(passwdAct + " - " + passwdNew);
		
		// Leemos datos de la sesion
		HttpSession s = req.getSession(false);
		ModelUsuario user = new ModelUsuario(); 
		
		if (s.getAttribute("user") != null) {
			user = (ModelUsuario) s.getAttribute("user");
			
			// Verificamos que el password actual sea el de la sesión
			if (Base64Coder.decode(user.getPassword()).equals(passwdAct)) {
				ComprasDAO db = new ComprasDAO(); 
				EstrucuraRetornoLOGIN login = db.cambiaPassword(user.getId(), passwdAct, passwdNew);
				
				if (login.isEXITO()) {									
					if (login.getDATOS_CONSULTA() != null) {						
						user.setPassword(Base64Coder.encode(passwdNew));			
						//s.removeAttribute("user");
						s.setAttribute("user", user); // Remplazamos el atributo user
						
						msj.setExito(true);
						msj.setMensaje("Ok");
					} else
						msj.setMensaje("No fue posible cambiar el password...");
				} else 
					msj.setMensaje(login.getMENSAJE());
			} else 
				msj.setMensaje("Password incorrecto...");
			
		} else {
			msj.setMensaje("Sesión no se encuentra vigente...");
		}
	
		Gson gson = new Gson();
		String json = gson.toJson(msj);
		res.getWriter().write(json);
	}

}
