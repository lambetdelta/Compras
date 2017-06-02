package gob.tlajomulco.filtros;

import gob.tlajomulco.ModelUsuario;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FAcceso
 */

//@WebFilter(filterName="LoginFiltro", urlPatterns="/Compras/site/*", dispatcherTypes={DispatcherType.INCLUDE, DispatcherType.ERROR, DispatcherType.FORWARD, DispatcherType.REQUEST})
@WebFilter(filterName="/LoginFiltro",urlPatterns="/site/*" )

public class LoginFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpSession sesion = ((HttpServletRequest)req).getSession(false);
		if (verificaUsuario(sesion)) {
			chain.doFilter(req, res);
		} else {			
			HttpServletResponse hres = (HttpServletResponse) res;
            hres.sendRedirect("../index.jsp");

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	private boolean verificaUsuario(HttpSession sesion) {
		
		System.out.println("Filtro... verificando usuario");
		if (sesion != null) {
			ModelUsuario user = (ModelUsuario) sesion.getAttribute("user");
			
			if (user != null)
				return true;
		}
		
		return false;
			
			
	}
}
