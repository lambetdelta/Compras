/**
 * ProveedoresSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface ProveedoresSoap extends java.rmi.Remote {
    public org.tempuri.EstrucuraRetornoLOGIN loginProveedores(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoLOGIN changePassword(java.lang.String idProveedor, java.lang.String passwordActual, java.lang.String passwordNuevo) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCOTPROB cotizacionProveedor(java.lang.String nombre_proveedor, java.lang.String codigo_proveedor, java.lang.String fechadesde, java.lang.String fechahasta, java.lang.String fechaentregadesde, java.lang.String fechaentregahasta, java.lang.String nombre_familia, java.lang.String codigo_familia, java.lang.String nombre_rubro, java.lang.String codigo_rubro, java.lang.String tipo_compra, java.lang.String codigo_tipo_compra, java.lang.String cuenta_usuario, java.lang.String pass_usuario, java.lang.String terminado, java.lang.String id_cotizacion, java.lang.String numero_cotizacion) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCOTPROBDETALLE cotizacionProveedorDetalle(java.lang.String listID_boplace, java.lang.String ID, java.lang.String DETALLE) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCOTPED pedidoCotizacion(java.lang.String nombre_proveedor, java.lang.String codigo_proveedor, java.lang.String fechadesde, java.lang.String fechahasta, java.lang.String fechaentregadesde, java.lang.String fechaentregahasta, java.lang.String nombre_familia, java.lang.String codigo_familia, java.lang.String nombre_rubro, java.lang.String codigo_rubro, java.lang.String tipo_compra, java.lang.String codigo_tipo_compra, java.lang.String cuenta_usuario, java.lang.String pass_usuario) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoORDCOMP ordenCompra(java.lang.String fechadesde, java.lang.String fechahasta, java.lang.String fechaentregadesde, java.lang.String fechaentregahasta, java.lang.String tipo_compra, java.lang.String codigo_tipo_compra) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoORDCOMPDetalle ordenCompraDetalle(java.lang.String LISTID_boplace) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoPADRONPROV padronProveedores(java.lang.String nombre_proveedor, java.lang.String codigo_proveedor, java.lang.String nombre_familia, java.lang.String codigo_familia, java.lang.String nombre_rubro, java.lang.String codigo_rubro, java.lang.String cuenta_usuario, java.lang.String pass_usuario) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoUpdate updateCabezera(java.lang.String nombretipopago, java.lang.String idtipopago, java.lang.String cabezerafechaentrega, java.lang.String idcotizacion, java.lang.String numerocotizacion, java.lang.String terminado, java.lang.String usuario, java.lang.String cotizador, java.lang.String boextencionid, java.lang.String prov_observacion, java.lang.String prov_disculpa, int dias_entrega, java.lang.String garantia) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoUpdate updateItemCotizacion(java.lang.String iditem, java.math.BigDecimal precioitem, java.lang.String terminado, java.lang.String usuario, java.lang.String idcotizacion, java.lang.String observaciones, java.lang.String iva, java.math.BigDecimal iva_proovedor, java.math.BigDecimal iva_IE, java.lang.String itemdetalle) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoUpdate updateTerminoCotizacion(java.lang.String boExtcionId, java.lang.String terminado, java.lang.String usuario, java.lang.String idCotizacion) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCATTIPOPAGO catalogoTipoPago() throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCATFAMPROD catalogoFamiliaProductos() throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoRUBROS catalogoRubros() throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoTIPOCOMPRA catalogoTipoCompra() throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCATPROV catalogoProveedores() throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoUpdate uploadFile(java.lang.String terminado, java.lang.String numCotizacion, java.lang.String usuario, byte[] archivoBytes, java.lang.String fileName, java.lang.String idCotizacion) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCONCURSOSMODEL getConcursos(java.lang.String IDRUBRO, java.lang.String FECHA) throws java.rmi.RemoteException;
    public org.tempuri.EstrucuraRetornoCONCURSOSMODEL_DETAIL getConcursosbyIDRequerimiento(java.lang.String IDREQUERIMIENTO) throws java.rmi.RemoteException;
}
