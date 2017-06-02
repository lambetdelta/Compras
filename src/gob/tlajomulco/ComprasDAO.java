package gob.tlajomulco;

import gob.tlajomulco.utiles.Formatos;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.tempuri.CONCURSOSMODEL;
import org.tempuri.CONCURSOSMODEL_DETAIL;
import org.tempuri.EstrucuraRetornoCATFAMPROD;
import org.tempuri.EstrucuraRetornoCATPROV;
import org.tempuri.EstrucuraRetornoCATTIPOPAGO;
import org.tempuri.EstrucuraRetornoCONCURSOSMODEL;
import org.tempuri.EstrucuraRetornoCONCURSOSMODEL_DETAIL;
import org.tempuri.EstrucuraRetornoCOTPROB;
import org.tempuri.EstrucuraRetornoCOTPROBDETALLE;
import org.tempuri.EstrucuraRetornoLOGIN;
import org.tempuri.EstrucuraRetornoRUBROS;
import org.tempuri.EstrucuraRetornoUpdate;
import org.tempuri.ModelCATFAMPROD;
import org.tempuri.ModelCATTIPOPAGO;
import org.tempuri.ModelCatProveedores;
import org.tempuri.ModelCotizacionProveedor;
import org.tempuri.ModelCotizacionProveedorDETALLE;
import org.tempuri.ModelRUBROS;
import org.tempuri.ProveedoresSoapProxy;

public class ComprasDAO {	
	
	private final String passEncode = "RTasdSD1356x355"; 
	
	public ComprasDAO() {
		super();
	}
	
	public String getPassEncode() {
		return passEncode;
	}
	
	
	// ************************************************************************************************************
	// Consultas de catálogos
	// ************************************************************************************************************
	
	
	/**
	 * Obtiene el catálogo de rubros
	 * @return
	 * @throws RemoteException
	 */
	public ModelRUBROS[] getRubros() throws RemoteException {

		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();		
		EstrucuraRetornoRUBROS r = ws.catalogoRubros();
		
		if (r.isEXITO())
			return r.getDATOS_CONSULTA();
		
		return null;
	}
	
	/**
	 * Obtiene el catalogo de Tipo de Pagos
	 * @return
	 * @throws RemoteException
	 */
	public ModelCATTIPOPAGO[] getCatalogoTipoPago() throws RemoteException {
		
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();		
		EstrucuraRetornoCATTIPOPAGO tp = ws.catalogoTipoPago();
				
		if (tp.isEXITO()) 
			if (tp.getDATOS_CONSULTA().length > 0)
				return tp.getDATOS_CONSULTA();			
		
		return null;
	}
	
	/**
	 * Obtiene el catálogo de proveedores
	 * @return
	 * @throws RemoteException
	 */
	public ModelCatProveedores[] getCatalogoProveedores() throws RemoteException {
		
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		EstrucuraRetornoCATPROV prov = ws.catalogoProveedores();
		
		if (prov.isEXITO()) 
			if (prov.getDATOS_CONSULTA().length > 0)
				return prov.getDATOS_CONSULTA();			
		
		return null;		
	}
	
	/**
	 * Obtiene el catálogo de familias de productos
	 * @return
	 * @throws RemoteException 
	 */
	public ModelCATFAMPROD[] getCatalogoFamiliaProductos() throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		EstrucuraRetornoCATFAMPROD fp = ws.catalogoFamiliaProductos();
		
		if (fp.isEXITO())
			if (fp.getDATOS_CONSULTA().length > 0)
				return fp.getDATOS_CONSULTA();
		
		return null;
	}
	
	// ************************************************************************************************************
	// Login y cambio de password
	// ************************************************************************************************************
	
	/**
	 * Logear un usuario al sistema de compras
	 * @param usuario
	 * @param passwd
	 * @return
	 * @throws RemoteException
	 */
	public EstrucuraRetornoLOGIN login(String usuario, String passwd) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoLOGIN l = new EstrucuraRetornoLOGIN();
		
		System.out.println(Formatos.getHoyStr() + "\tLlamamos loginProveedores");
		l = ws.loginProveedores(usuario, passwd);
		
		return l;
	}
	
	/**
	 * Cambiar password a un proveedor
	 * @param proveedorId
	 * @param passwordOld
	 * @param passwordNew
	 * @return
	 * @throws RemoteException
	 */
	public EstrucuraRetornoLOGIN cambiaPassword(String proveedorId, String passwordOld, String passwordNew) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoLOGIN l = new EstrucuraRetornoLOGIN();
		
		l = ws.changePassword(proveedorId, passwordOld, passwordNew);
		
		return l;
	}
	
	
	// ************************************************************************************************************
	// Consulta de Concurso, maestro y detalle
	// ************************************************************************************************************
	
	/**
	 * Obtiene el listado de concursos vigentes por rubro
	 * @param idRubro
	 * @param fecha
	 * @return
	 * @throws RemoteException
	 */
	public CONCURSOSMODEL[] getConcurso(String idRubro, String fecha) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		EstrucuraRetornoCONCURSOSMODEL cm = ws.getConcursos(idRubro, fecha);
		
		if (cm.isEXITO())
			return cm.getDATOS_CONSULTA();
			
		
		return null;
	}
	
	/**
	 * Obtiene el listado de Items que contiene un concurso
	 * @param idRequerimiento
	 * @return
	 * @throws RemoteException
	 */
	public CONCURSOSMODEL_DETAIL[] getConcursoDet(String idRequerimiento) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoCONCURSOSMODEL_DETAIL cd = ws.getConcursosbyIDRequerimiento(idRequerimiento);
		if (cd.isEXITO())
			return cd.getDATOS_CONSULTA();
		
		return null;
	}
	
	
	// ************************************************************************************************************
	// Consulta de cotizaciones, maestro y detalle
	// ************************************************************************************************************	
	
	/**
	 * Obtiene un arreglo de las cotizaciones que tiene el proveedor
	 * @param usuario
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public ModelCotizacionProveedor[] getCotizacionProveedor(String usuario, String password) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		/*
		 * id_cotizacion
		 * numero_cotizacion
		 * */
		EstrucuraRetornoCOTPROB cot = ws.cotizacionProveedor("", "", "", "", "", "", "", "", "", "", "", "", usuario, password, "F","","");
		
		if (cot.isEXITO())
			if (cot.getDATOS_CONSULTA().length > 0)
				return cot.getDATOS_CONSULTA();

		return null;		
	}
	
	public ModelCotizacionProveedor getCotizacionProveedor(String pk, String usuario, String password) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoCOTPROB cot = ws.cotizacionProveedor("", "", "", "", "", "", "", "", "", "", "", "", usuario, password, "",pk,"");
		
		System.out.println(cot.isEXITO() + ", " + cot.getMENSAJE() + ", " + cot.getDATOS_CONSULTA().length);
		
		if (cot.isEXITO())
			if (cot.getDATOS_CONSULTA().length > 0) {
				System.out.println(cot.getDATOS_CONSULTA()[0].getID());
				
				return cot.getDATOS_CONSULTA()[0];
			}
			else
				return null;
		else
			return null;
	}
	
	/**
	 * Obtiene el detalle de X cotización
	 * @param pk
	 * @return
	 * @throws RemoteException
	 */
	public ModelCotizacionProveedorDETALLE[] getCotizacionProveedorDet(String pk) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoCOTPROBDETALLE det = ws.cotizacionProveedorDetalle("",pk, "");
		
		if (det.isEXITO())
			if (det.getDATOS_CONSULTA().length > 0)
				return det.getDATOS_CONSULTA();			
			
		return null;
	}
	
	public ModelCotizacionProveedorDETALLE getCotizacionProveedorDet(String pk, String item) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		EstrucuraRetornoCOTPROBDETALLE det = ws.cotizacionProveedorDetalle("",pk, item);
		
		if (det.isEXITO())
			if (det.getDATOS_CONSULTA().length > 0)
				return det.getDATOS_CONSULTA()[0];			
			
		return null;
	}
	
	
	// ************************************************************************************************************
	// Actualizaciones de Cotizaciones
	// ************************************************************************************************************
	
	/**
	 * Actualiza una partida de la cotización
	 * @param item
	 * @return
	 * @throws RemoteException
	 */
	public EstrucuraRetornoUpdate updateCotizacionItem(ModelCotizacionItem item) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		System.out.println("Compras :: Actualizando Elemento de Cotización: " + item.getIdItem()+ " precio: " + item.getPrecioItem());
		return ws.updateItemCotizacion(item.getIdItem(), BigDecimal.valueOf(item.getPrecioItem()), item.getFechaEntregaItem(), item.getUsuario(),
				 item.getIdCotizacion(), item.getObservaciones(),String.valueOf(item.getIvaPorcentaje()),BigDecimal.valueOf(item.getIvaPorcentaje()),
				 BigDecimal.valueOf(item.getIvaIEPS()), item.getItemDetalle());	
	}
	
	/**
	 * Actualiza la cabecera de la cotización
	 * @param cab
	 * @return
	 * @throws RemoteException
	 */
	public EstrucuraRetornoUpdate updateCotizacionCabecera(ModelCotizacionCabecera cab) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		System.out.println("Compras :: Actualizando Cotización: " + cab.getIdCotizacion());
		System.out.println(cab);
		
		return ws.updateCabezera(cab.getNombreTipoPago(), cab.getIdTipoPago(), cab.getFechaEntrega(), 
				cab.getIdCotizacion(), cab.getNumeroCotizacion(), cab.getTerminado(), cab.getUsuario(), 
				cab.getCotizador(), cab.getBoExtencionId(), cab.getObservaciones(), cab.getDisculpa(), 
				cab.getDiasEntrega(), cab.getGaratia());
	}
	
	/**
	 * Se da por terminada la edicion de una cotización.
	 * @return
	 * @throws RemoteException
	 */
	public EstrucuraRetornoUpdate updateCotizacionTerminado(ModelCotizacionCabecera cab) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		
		System.out.println("Compras :: Finalizando Cotización: " + cab.getIdCotizacion());
		return ws.updateTerminoCotizacion(cab.getBoExtencionId(),cab.getTerminado(),cab.getUsuario(),cab.getIdCotizacion()); //(extincion, terminado, usuario, idCotizacion)
	}
	
	public EstrucuraRetornoUpdate uploadFile(String numCotizacion, String usuario, byte[] archivoBytes, String fileName, String idCotizacion) throws RemoteException {
		ProveedoresSoapProxy ws = new ProveedoresSoapProxy();
		System.out.println("Subiendo archivo: " + fileName + ", cotización: " + numCotizacion);
		return ws.uploadFile("F", numCotizacion, usuario, archivoBytes, fileName, idCotizacion);		
	}
}
