package gob.tlajomulco.config;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Estatus {

	private boolean activo;
	private String titulo;
	private String mensaje;
	private String repositorio;
	
	public Estatus() {
		super();
		
		activo = false;
		titulo = "NO DISPONIBLE";
		mensaje = "Temporalmente estamos fuera de servicio, intente mas tarde";
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}

	public void loadFromXML(String xml) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		doc = builder.build(xml);
		
		Element sts = doc.getRootElement();
		
		// Leemos informacion...
		boolean act = Boolean.parseBoolean(sts.getChildText("Activo"));
		setActivo(act);
		setTitulo(sts.getChildTextTrim("Titulo"));
		setMensaje(sts.getChildTextTrim("Mensaje"));
		setRepositorio(sts.getChildTextTrim("Repositorio"));
	}

	@Override
	public String toString() {
		return activo + ", " + titulo + ", " + mensaje;
	}
	
}
