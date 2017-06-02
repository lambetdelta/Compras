/**
 * ProveedoresLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ProveedoresLocator extends org.apache.axis.client.Service implements org.tempuri.Proveedores {

    public ProveedoresLocator() {
    }


    public ProveedoresLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProveedoresLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProveedoresSoap
    private java.lang.String ProveedoresSoap_address = "http://172.16.11.70:8066/Proveedores.asmx";

    public java.lang.String getProveedoresSoapAddress() {
        return ProveedoresSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProveedoresSoapWSDDServiceName = "ProveedoresSoap";

    public java.lang.String getProveedoresSoapWSDDServiceName() {
        return ProveedoresSoapWSDDServiceName;
    }

    public void setProveedoresSoapWSDDServiceName(java.lang.String name) {
        ProveedoresSoapWSDDServiceName = name;
    }

    public org.tempuri.ProveedoresSoap getProveedoresSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProveedoresSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProveedoresSoap(endpoint);
    }

    public org.tempuri.ProveedoresSoap getProveedoresSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.ProveedoresSoapStub _stub = new org.tempuri.ProveedoresSoapStub(portAddress, this);
            _stub.setPortName(getProveedoresSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProveedoresSoapEndpointAddress(java.lang.String address) {
        ProveedoresSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ProveedoresSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.ProveedoresSoapStub _stub = new org.tempuri.ProveedoresSoapStub(new java.net.URL(ProveedoresSoap_address), this);
                _stub.setPortName(getProveedoresSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProveedoresSoap".equals(inputPortName)) {
            return getProveedoresSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Proveedores");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ProveedoresSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProveedoresSoap".equals(portName)) {
            setProveedoresSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
