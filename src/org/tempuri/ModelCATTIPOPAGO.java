/**
 * ModelCATTIPOPAGO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ModelCATTIPOPAGO  implements java.io.Serializable {
    private java.lang.String ID;

    private java.lang.String DESCRIPCION;

    public ModelCATTIPOPAGO() {
    }

    public ModelCATTIPOPAGO(
           java.lang.String ID,
           java.lang.String DESCRIPCION) {
           this.ID = ID;
           this.DESCRIPCION = DESCRIPCION;
    }


    /**
     * Gets the ID value for this ModelCATTIPOPAGO.
     * 
     * @return ID
     */
    public java.lang.String getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ModelCATTIPOPAGO.
     * 
     * @param ID
     */
    public void setID(java.lang.String ID) {
        this.ID = ID;
    }


    /**
     * Gets the DESCRIPCION value for this ModelCATTIPOPAGO.
     * 
     * @return DESCRIPCION
     */
    public java.lang.String getDESCRIPCION() {
        return DESCRIPCION;
    }


    /**
     * Sets the DESCRIPCION value for this ModelCATTIPOPAGO.
     * 
     * @param DESCRIPCION
     */
    public void setDESCRIPCION(java.lang.String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModelCATTIPOPAGO)) return false;
        ModelCATTIPOPAGO other = (ModelCATTIPOPAGO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID==null && other.getID()==null) || 
             (this.ID!=null &&
              this.ID.equals(other.getID()))) &&
            ((this.DESCRIPCION==null && other.getDESCRIPCION()==null) || 
             (this.DESCRIPCION!=null &&
              this.DESCRIPCION.equals(other.getDESCRIPCION())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getID() != null) {
            _hashCode += getID().hashCode();
        }
        if (getDESCRIPCION() != null) {
            _hashCode += getDESCRIPCION().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModelCATTIPOPAGO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ModelCATTIPOPAGO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESCRIPCION");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DESCRIPCION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
