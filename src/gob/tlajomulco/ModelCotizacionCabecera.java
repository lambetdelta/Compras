package gob.tlajomulco;

public class ModelCotizacionCabecera {

	private String nombreTipoPago;
	private String idTipoPago;
	private String fechaEntrega; 
	private int diasEntrega;
	private String garatia;
	private String idCotizacion;
	private String numeroCotizacion;
	private String terminado;
	private String usuario;
	private String cotizador;
	private String boExtencionId;
	private String observaciones;
	private String disculpa;
	
	public ModelCotizacionCabecera() {
		super();
		
		nombreTipoPago = "";
		idTipoPago = "";
		fechaEntrega = "";
		idCotizacion = "";
		numeroCotizacion = "";
		terminado = "";
		usuario = "";
		cotizador = "";
		boExtencionId = "";
		observaciones = "";
		disculpa = "";
	}

	public String getNombreTipoPago() {
		return nombreTipoPago;
	}

	public void setNombreTipoPago(String nombreTipoPago) {
		this.nombreTipoPago = nombreTipoPago;
	}

	public String getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(String idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public String getTerminado() {
		return terminado;
	}

	public void setTerminado(String terminado) {
		this.terminado = terminado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCotizador() {
		return cotizador;
	}

	public void setCotizador(String cotizador) {
		this.cotizador = cotizador;
	}

	public String getBoExtencionId() {
		return boExtencionId;
	}

	public void setBoExtencionId(String boExtencionId) {
		this.boExtencionId = boExtencionId;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDisculpa() {
		return disculpa;
	}

	public void setDisculpa(String disculpa) {
		this.disculpa = disculpa;
	}
 
	public int getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(int diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	public String getGaratia() {
		return garatia;
	}

	public void setGaratia(String garatia) {
		this.garatia = garatia;
	}

	@Override
	public String toString() {
		return nombreTipoPago + ", " + idTipoPago + ", " + fechaEntrega + ", "
				+ idCotizacion + ", " + numeroCotizacion + ", " + terminado
				+ ", " + usuario + ", " + cotizador + ", " + boExtencionId;
	}

}
