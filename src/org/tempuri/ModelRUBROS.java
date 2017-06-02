/**
 * ModelRUBROS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ModelRUBROS  implements java.io.Serializable {
    private java.lang.String ID;

    private java.lang.String CODIGO;

    private java.lang.String DETALLE;

    public ModelRUBROS() {
    }

    public ModelRUBROS(
           java.lang.String ID,
           java.lang.String CODIGO,
           java.lang.String DETALLE) {
           this.ID = ID;
           this.CODIGO = CODIGO;
           this.DETALLE = DETALLE;
    }


    /**
     * Gets the ID value for this ModelRUBROS.
     * 
     * @return ID
     */
    public java.lang.String getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ModelRUBROS.
     * 
     * @param ID
     */
    public void setID(java.lang.String ID) {
        this.ID = ID;
    }


    /**
     * Gets the CODIGO value for this ModelRUBROS.
     * 
     * @return CODIGO
     */
    public java.lang.String getCODIGO() {
        return CODIGO;
    }


    /**
     * Sets the CODIGO value for this ModelRUBROS.
     * 
     * @param CODIGO
     */
    public void setCODIGO(java.lang.String CODIGO) {
        this.CODIGO = CODIGO;
    }


    /**
     * Gets the DETALLE value for this ModelRUBROS.
     * 
     * @return DETALLE
     */
    public java.lang.String getDETALLE() {
        return DETALLE;
    }


    /**
     * Sets the DETALLE value for this ModelRUBROS.
     * 
     * @param DETALLE
     */
    public void setDETALLE(java.lang.String DETALLE) {
        this.DETALLE = DETALLE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModelRUBROS)) return false;
        ModelRUBROS other = (ModelRUBROS) obj;
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
            ((this.CODIGO==null && other.getCODIGO()==null) || 
             (this.CODIGO!=null &&
              this.CODIGO.equals(other.getCODIGO()))) &&
            ((this.DETALLE==null && other.getDETALLE()==null) || 
             (this.DETALLE!=null &&
              this.DETALLE.equals(other.getDETALLE())));
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
        if (getCODIGO() != null) {
            _hashCode += getCODIGO().hashCode();
        }
        if (getDETALLE() != null) {
            _hashCode += getDETALLE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModelRUBROS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ModelRUBROS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODIGO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CODIGO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DETALLE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DETALLE"));
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
