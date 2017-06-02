package gob.tlajomulco;

public class ModelCotizacionItem {

	private String idItem;
	private float precioItem;
	private String fechaEntregaItem; 
	private String garantiaItem;
	private float cantidadItem; 
	private String terminado; 
	private String usuario; 
	private String idCotizacion;
	private float ivaPorcentaje;
	private float ivaIEPS;
	private String observaciones;
	private String itemdetalle;
	public ModelCotizacionItem() {
		super();
		
		idItem = "";
		precioItem = 0;
		fechaEntregaItem = "";
		garantiaItem = "";
		cantidadItem = 0;
		terminado = "";
		usuario = "";
		idCotizacion = "";
		ivaPorcentaje = 16;
		ivaIEPS = 0;
		observaciones = "";
		itemdetalle="";
	}

	public String getItemDetalle(){
		return this.itemdetalle;
	}
	public void setItemDetalle(String itemdetalle){
		this.itemdetalle=itemdetalle;
	}
	public String getIdItem() {
		return idItem;
	}
	
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public float getPrecioItem() {
		return precioItem;
	}

	public void setPrecioItem(float precioItem) {
		this.precioItem = precioItem;
	}

	public String getFechaEntregaItem() {
		return fechaEntregaItem;
	}

	public void setFechaEntregaItem(String fechaEntregaItem) {
		this.fechaEntregaItem = fechaEntregaItem;
	}

	public String getGarantiaItem() {
		return garantiaItem;
	}

	public void setGarantiaItem(String garantiaItem) {
		this.garantiaItem = garantiaItem;
	}

	public float getCantidadItem() {
		return cantidadItem;
	}

	public void setCantidadItem(float cantidadItem) {
		this.cantidadItem = cantidadItem;
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

	public String getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(String idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	
	public float getTotalPrecio() {
		return cantidadItem * precioItem;
	}

	public float getIvaPorcentaje() {
		return ivaPorcentaje;
	}

	public void setIvaPorcentaje(float ivaPorcentaje) {
		this.ivaPorcentaje = ivaPorcentaje;
	}

	public float getIvaIEPS() {
		return ivaIEPS;
	}

	public void setIvaIEPS(float ivaIEPS) {
		this.ivaIEPS = ivaIEPS;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return idItem + ", " + precioItem + ", " + fechaEntregaItem + ", "
				+ garantiaItem + ", " + cantidadItem + ", " + terminado + ", "
				+ usuario + ", " + idCotizacion;
	}

}
