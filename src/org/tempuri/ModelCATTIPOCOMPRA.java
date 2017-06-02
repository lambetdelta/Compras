/**
 * ModelCATTIPOCOMPRA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ModelCATTIPOCOMPRA  implements java.io.Serializable {
    private java.lang.String ID;

    private java.lang.String CODIGO;

    private java.lang.String NOMBRE;

    public ModelCATTIPOCOMPRA() {
    }

    public ModelCATTIPOCOMPRA(
           java.lang.String ID,
           java.lang.String CODIGO,
           java.lang.String NOMBRE) {
           this.ID = ID;
           this.CODIGO = CODIGO;
           this.NOMBRE = NOMBRE;
    }


    /**
     * Gets the ID value for this ModelCATTIPOCOMPRA.
     * 
     * @return ID
     */
    public java.lang.String getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ModelCATTIPOCOMPRA.
     * 
     * @param ID
     */
    public void setID(java.lang.String ID) {
        this.ID = ID;
    }


    /**
     * Gets the CODIGO value for this ModelCATTIPOCOMPRA.
     * 
     * @return CODIGO
     */
    public java.lang.String getCODIGO() {
        return CODIGO;
    }


    /**
     * Sets the CODIGO value for this ModelCATTIPOCOMPRA.
     * 
     * @param CODIGO
     */
    public void setCODIGO(java.lang.String CODIGO) {
        this.CODIGO = CODIGO;
    }


    /**
     * Gets the NOMBRE value for this ModelCATTIPOCOMPRA.
     * 
     * @return NOMBRE
     */
    public java.lang.String getNOMBRE() {
        return NOMBRE;
    }


    /**
     * Sets the NOMBRE value for this ModelCATTIPOCOMPRA.
     * 
     * @param NOMBRE
     */
    public void setNOMBRE(java.lang.String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModelCATTIPOCOMPRA)) return false;
        ModelCATTIPOCOMPRA other = (ModelCATTIPOCOMPRA) obj;
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
            ((this.NOMBRE==null && other.getNOMBRE()==null) || 
             (this.NOMBRE!=null &&
              this.NOMBRE.equals(other.getNOMBRE())));
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
        if (getNOMBRE() != null) {
            _hashCode += getNOMBRE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModelCATTIPOCOMPRA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ModelCATTIPOCOMPRA"));
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
        elemField.setFieldName("NOMBRE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NOMBRE"));
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
