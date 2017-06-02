package org.tempuri;

public class ProveedoresSoapProxy implements org.tempuri.ProveedoresSoap {
  private String _endpoint = null;
  private org.tempuri.ProveedoresSoap proveedoresSoap = null;
  
  public ProveedoresSoapProxy() {
    _initProveedoresSoapProxy();
  }
  
  public ProveedoresSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initProveedoresSoapProxy();
  }
  
  private void _initProveedoresSoapProxy() {
    try {
      proveedoresSoap = (new org.tempuri.ProveedoresLocator()).getProveedoresSoap();
      if (proveedoresSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)proveedoresSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)proveedoresSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (proveedoresSoap != null)
      ((javax.xml.rpc.Stub)proveedoresSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ProveedoresSoap getProveedoresSoap() {
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap;
  }
  
  public org.tempuri.EstrucuraRetornoLOGIN loginProveedores(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.loginProveedores(usuario, password);
  }
  
  public org.tempuri.EstrucuraRetornoLOGIN changePassword(java.lang.String idProveedor, java.lang.String passwordActual, java.lang.String passwordNuevo) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.changePassword(idProveedor, passwordActual, passwordNuevo);
  }
  
  public org.tempuri.EstrucuraRetornoCOTPROB cotizacionProveedor(java.lang.String nombre_proveedor, java.lang.String codigo_proveedor, java.lang.String fechadesde, java.lang.String fechahasta, java.lang.String fechaentregadesde, java.lang.String fechaentregahasta, java.lang.String nombre_familia, java.lang.String codigo_familia, java.lang.String nombre_rubro, java.lang.String codigo_rubro, java.lang.String tipo_compra, java.lang.String codigo_tipo_compra, java.lang.String cuenta_usuario, java.lang.String pass_usuario, java.lang.String terminado, java.lang.String id_cotizacion, java.lang.String numero_cotizacion) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.cotizacionProveedor(nombre_proveedor, codigo_proveedor, fechadesde, fechahasta, fechaentregadesde, fechaentregahasta, nombre_familia, codigo_familia, nombre_rubro, codigo_rubro, tipo_compra, codigo_tipo_compra, cuenta_usuario, pass_usuario, terminado, id_cotizacion, numero_cotizacion);
  }
  
  public org.tempuri.EstrucuraRetornoCOTPROBDETALLE cotizacionProveedorDetalle(java.lang.String listID_boplace, java.lang.String ID, java.lang.String DETALLE) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.cotizacionProveedorDetalle(listID_boplace, ID, DETALLE);
  }
  
  public org.tempuri.EstrucuraRetornoCOTPED pedidoCotizacion(java.lang.String nombre_proveedor, java.lang.String codigo_proveedor, java.lang.String fechadesde, java.lang.String fechahasta, java.lang.String fechaentregadesde, java.lang.String fechaentregahasta, java.lang.String nombre_familia, java.lang.String codigo_familia, java.lang.String nombre_rubro, java.lang.String codigo_rubro, java.lang.String tipo_compra, java.lang.String codigo_tipo_compra, java.lang.String cuenta_usuario, java.lang.String pass_usuario) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.pedidoCotizacion(nombre_proveedor, codigo_proveedor, fechadesde, fechahasta, fechaentregadesde, fechaentregahasta, nombre_familia, codigo_familia, nombre_rubro, codigo_rubro, tipo_compra, codigo_tipo_compra, cuenta_usuario, pass_usuario);
  }
  
  public org.tempuri.EstrucuraRetornoORDCOMP ordenCompra(java.lang.String fechadesde, java.lang.String fechahasta, java.lang.String fechaentregadesde, java.lang.String fechaentregahasta, java.lang.String tipo_compra, java.lang.String codigo_tipo_compra) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.ordenCompra(fechadesde, fechahasta, fechaentregadesde, fechaentregahasta, tipo_compra, codigo_tipo_compra);
  }
  
  public org.tempuri.EstrucuraRetornoORDCOMPDetalle ordenCompraDetalle(java.lang.String LISTID_boplace) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.ordenCompraDetalle(LISTID_boplace);
  }
  
  public org.tempuri.EstrucuraRetornoPADRONPROV padronProveedores(java.lang.String nombre_proveedor, java.lang.String codigo_proveedor, java.lang.String nombre_familia, java.lang.String codigo_familia, java.lang.String nombre_rubro, java.lang.String codigo_rubro, java.lang.String cuenta_usuario, java.lang.String pass_usuario) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.padronProveedores(nombre_proveedor, codigo_proveedor, nombre_familia, codigo_familia, nombre_rubro, codigo_rubro, cuenta_usuario, pass_usuario);
  }
  
  public org.tempuri.EstrucuraRetornoUpdate updateCabezera(java.lang.String nombretipopago, java.lang.String idtipopago, java.lang.String cabezerafechaentrega, java.lang.String idcotizacion, java.lang.String numerocotizacion, java.lang.String terminado, java.lang.String usuario, java.lang.String cotizador, java.lang.String boextencionid, java.lang.String prov_observacion, java.lang.String prov_disculpa, int dias_entrega, java.lang.String garantia) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.updateCabezera(nombretipopago, idtipopago, cabezerafechaentrega, idcotizacion, numerocotizacion, terminado, usuario, cotizador, boextencionid, prov_observacion, prov_disculpa, dias_entrega, garantia);
  }
  
  public org.tempuri.EstrucuraRetornoUpdate updateItemCotizacion(java.lang.String iditem, java.math.BigDecimal precioitem, java.lang.String terminado, java.lang.String usuario, java.lang.String idcotizacion, java.lang.String observaciones, java.lang.String iva, java.math.BigDecimal iva_proovedor, java.math.BigDecimal iva_IE, java.lang.String itemdetalle) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.updateItemCotizacion(iditem, precioitem, terminado, usuario, idcotizacion, observaciones, iva, iva_proovedor, iva_IE, itemdetalle);
  }
  
  public org.tempuri.EstrucuraRetornoUpdate updateTerminoCotizacion(java.lang.String boExtcionId, java.lang.String terminado, java.lang.String usuario, java.lang.String idCotizacion) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.updateTerminoCotizacion(boExtcionId, terminado, usuario, idCotizacion);
  }
  
  public org.tempuri.EstrucuraRetornoCATTIPOPAGO catalogoTipoPago() throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.catalogoTipoPago();
  }
  
  public org.tempuri.EstrucuraRetornoCATFAMPROD catalogoFamiliaProductos() throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.catalogoFamiliaProductos();
  }
  
  public org.tempuri.EstrucuraRetornoRUBROS catalogoRubros() throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.catalogoRubros();
  }
  
  public org.tempuri.EstrucuraRetornoTIPOCOMPRA catalogoTipoCompra() throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.catalogoTipoCompra();
  }
  
  public org.tempuri.EstrucuraRetornoCATPROV catalogoProveedores() throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.catalogoProveedores();
  }
  
  public org.tempuri.EstrucuraRetornoUpdate uploadFile(java.lang.String terminado, java.lang.String numCotizacion, java.lang.String usuario, byte[] archivoBytes, java.lang.String fileName, java.lang.String idCotizacion) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.uploadFile(terminado, numCotizacion, usuario, archivoBytes, fileName, idCotizacion);
  }
  
  public org.tempuri.EstrucuraRetornoCONCURSOSMODEL getConcursos(java.lang.String IDRUBRO, java.lang.String FECHA) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.getConcursos(IDRUBRO, FECHA);
  }
  
  public org.tempuri.EstrucuraRetornoCONCURSOSMODEL_DETAIL getConcursosbyIDRequerimiento(java.lang.String IDREQUERIMIENTO) throws java.rmi.RemoteException{
    if (proveedoresSoap == null)
      _initProveedoresSoapProxy();
    return proveedoresSoap.getConcursosbyIDRequerimiento(IDREQUERIMIENTO);
  }
  
  
}