package gob.tlajomulco;

import org.tempuri.ModelCotizacionProveedorDETALLE;

public class CotizacionDetalleEx extends ModelCotizacionProveedorDETALLE {

	private static final long serialVersionUID = -5901810920268438896L;
	
	private String cotId;
	private String terminado;
	
	public CotizacionDetalleEx() {
		super();
	}

	public CotizacionDetalleEx(String ID_ITEM, String REFERENCIA,
			String DESCRIPCION, String DETALLES, String PRIORIDAD,
			String CANTIDAD, String PRECIOREFERENCIA, String FECHAENTREGA_ITEM,
			String UNIDAD_MEDIDA, String PRECIO_UNITARIO, String BONIFICACION,
			String IMPORTE_BONIFICACION, String TOTAL, String NETO_TOTAL,
			String PROYECTO_ITEM, String TIPO_GASTO_ITEM, String ORIGEN_ITEM,
			String PARTIDA, String GARANTIA, String DISPONIBLEANT,
			String DISPONIBLE, String PERMITESALDOROJO, String USUARIO,
			String VALIDAANUAL, String MOTIVOPRIORIDAD, String SOLICITUD,
			String CLAVEPRESUPUESTAL, String VALOR2_NOMBRE,
			String TOTAL2_NOMBRE, String SUMA2_NOMBRE, String TOTALTR,
			String OBSERVACIONES, String IVA, String IVAIE) {
//		super(ID_ITEM, REFERENCIA, DESCRIPCION, DETALLES, PRIORIDAD, CANTIDAD,
//				PRECIOREFERENCIA, FECHAENTREGA_ITEM, UNIDAD_MEDIDA,
//				PRECIO_UNITARIO, BONIFICACION, IMPORTE_BONIFICACION, TOTAL,
//				NETO_TOTAL, PROYECTO_ITEM, TIPO_GASTO_ITEM, ORIGEN_ITEM,
//				PARTIDA, GARANTIA, DISPONIBLEANT, DISPONIBLE, PERMITESALDOROJO,
//				USUARIO, VALIDAANUAL, MOTIVOPRIORIDAD, SOLICITUD,
//				CLAVEPRESUPUESTAL, VALOR2_NOMBRE, TOTAL2_NOMBRE, SUMA2_NOMBRE,
//				TOTALTR, OBSERVACIONES, IVA, IVAIE);
		// TODO Auto-generated constructor stub
	}

	public String getCotId() {
		return cotId;
	}

	public void setCotId(String cotId) {
		this.cotId = cotId;
	}

	public String getTerminado() {
		return terminado;
	}

	public void setTerminado(String terminado) {
		this.terminado = terminado;
	}

}
