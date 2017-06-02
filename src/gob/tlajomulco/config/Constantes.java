package gob.tlajomulco.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jdom2.JDOMException;



public class Constantes {
	
	
	public static String getURL(HttpServletRequest hreq) {
		String url = "http://127.0.0.1:" + hreq.getServerPort() + hreq.getContextPath();
		//String url = "http://127.0.0.1:8080" + hreq.getContextPath();
		
		//System.out.println(url);
		return url;
	}
	
	public static String getURLSimple(HttpServletRequest hreq) {
		String url = getURL(hreq);
		System.out.println(url);
		return url;
	}
		
	public static Estatus getEstatus(String url) {
		Estatus sts = new Estatus();
		
		try {
			sts.loadFromXML(url + "/etc/status.xml");
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sts;
	}
}
