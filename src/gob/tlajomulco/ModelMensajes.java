package gob.tlajomulco;

public class ModelMensajes {

	private boolean exito;
	private String mensaje;
	
	public ModelMensajes() {
		super();
			
		exito = false;
		mensaje = "";
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return isExito() + ", " + getMensaje();
	}

}
