/**
 * EstrucuraRetornoPADRONPROV.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class EstrucuraRetornoPADRONPROV  implements java.io.Serializable {
    private boolean EXITO;

    private java.lang.String MENSAJE;

    private org.tempuri.ModelPadronProveedores[] DATOS_CONSULTA;

    public EstrucuraRetornoPADRONPROV() {
    }

    public EstrucuraRetornoPADRONPROV(
           boolean EXITO,
           java.lang.String MENSAJE,
           org.tempuri.ModelPadronProveedores[] DATOS_CONSULTA) {
           this.EXITO = EXITO;
           this.MENSAJE = MENSAJE;
           this.DATOS_CONSULTA = DATOS_CONSULTA;
    }


    /**
     * Gets the EXITO value for this EstrucuraRetornoPADRONPROV.
     * 
     * @return EXITO
     */
    public boolean isEXITO() {
        return EXITO;
    }


    /**
     * Sets the EXITO value for this EstrucuraRetornoPADRONPROV.
     * 
     * @param EXITO
     */
    public void setEXITO(boolean EXITO) {
        this.EXITO = EXITO;
    }


    /**
     * Gets the MENSAJE value for this EstrucuraRetornoPADRONPROV.
     * 
     * @return MENSAJE
     */
    public java.lang.String getMENSAJE() {
        return MENSAJE;
    }


    /**
     * Sets the MENSAJE value for this EstrucuraRetornoPADRONPROV.
     * 
     * @param MENSAJE
     */
    public void setMENSAJE(java.lang.String MENSAJE) {
        this.MENSAJE = MENSAJE;
    }


    /**
     * Gets the DATOS_CONSULTA value for this EstrucuraRetornoPADRONPROV.
     * 
     * @return DATOS_CONSULTA
     */
    public org.tempuri.ModelPadronProveedores[] getDATOS_CONSULTA() {
        return DATOS_CONSULTA;
    }


    /**
     * Sets the DATOS_CONSULTA value for this EstrucuraRetornoPADRONPROV.
     * 
     * @param DATOS_CONSULTA
     */
    public void setDATOS_CONSULTA(org.tempuri.ModelPadronProveedores[] DATOS_CONSULTA) {
        this.DATOS_CONSULTA = DATOS_CONSULTA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstrucuraRetornoPADRONPROV)) return false;
        EstrucuraRetornoPADRONPROV other = (EstrucuraRetornoPADRONPROV) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.EXITO == other.isEXITO() &&
            ((this.MENSAJE==null && other.getMENSAJE()==null) || 
             (this.MENSAJE!=null &&
              this.MENSAJE.equals(other.getMENSAJE()))) &&
            ((this.DATOS_CONSULTA==null && other.getDATOS_CONSULTA()==null) || 
             (this.DATOS_CONSULTA!=null &&
              java.util.Arrays.equals(this.DATOS_CONSULTA, other.getDATOS_CONSULTA())));
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
        _hashCode += (isEXITO() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMENSAJE() != null) {
            _hashCode += getMENSAJE().hashCode();
        }
        if (getDATOS_CONSULTA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDATOS_CONSULTA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDATOS_CONSULTA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstrucuraRetornoPADRONPROV.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "estrucuraRetornoPADRONPROV"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EXITO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EXITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MENSAJE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MENSAJE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATOS_CONSULTA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DATOS_CONSULTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ModelPadronProveedores"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "ModelPadronProveedores"));
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
