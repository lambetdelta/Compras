/**
 * ModelCatProveedores.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ModelCatProveedores  implements java.io.Serializable {
    private java.lang.String ID;

    private java.lang.String CODIGO;

    private java.lang.String DENOMINACION;

    private java.lang.String RFC;

    private java.lang.String DIRECCIONELECTRONICA;

    private java.lang.String CALLE;

    private java.lang.String CODPOS;

    private java.lang.String PAIS;

    private java.lang.String CIUDAD;

    private java.lang.String PROVINCIA;

    private java.lang.String BARRIO;

    public ModelCatProveedores() {
    }

    public ModelCatProveedores(
           java.lang.String ID,
           java.lang.String CODIGO,
           java.lang.String DENOMINACION,
           java.lang.String RFC,
           java.lang.String DIRECCIONELECTRONICA,
           java.lang.String CALLE,
           java.lang.String CODPOS,
           java.lang.String PAIS,
           java.lang.String CIUDAD,
           java.lang.String PROVINCIA,
           java.lang.String BARRIO) {
           this.ID = ID;
           this.CODIGO = CODIGO;
           this.DENOMINACION = DENOMINACION;
           this.RFC = RFC;
           this.DIRECCIONELECTRONICA = DIRECCIONELECTRONICA;
           this.CALLE = CALLE;
           this.CODPOS = CODPOS;
           this.PAIS = PAIS;
           this.CIUDAD = CIUDAD;
           this.PROVINCIA = PROVINCIA;
           this.BARRIO = BARRIO;
    }


    /**
     * Gets the ID value for this ModelCatProveedores.
     * 
     * @return ID
     */
    public java.lang.String getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ModelCatProveedores.
     * 
     * @param ID
     */
    public void setID(java.lang.String ID) {
        this.ID = ID;
    }


    /**
     * Gets the CODIGO value for this ModelCatProveedores.
     * 
     * @return CODIGO
     */
    public java.lang.String getCODIGO() {
        return CODIGO;
    }


    /**
     * Sets the CODIGO value for this ModelCatProveedores.
     * 
     * @param CODIGO
     */
    public void setCODIGO(java.lang.String CODIGO) {
        this.CODIGO = CODIGO;
    }


    /**
     * Gets the DENOMINACION value for this ModelCatProveedores.
     * 
     * @return DENOMINACION
     */
    public java.lang.String getDENOMINACION() {
        return DENOMINACION;
    }


    /**
     * Sets the DENOMINACION value for this ModelCatProveedores.
     * 
     * @param DENOMINACION
     */
    public void setDENOMINACION(java.lang.String DENOMINACION) {
        this.DENOMINACION = DENOMINACION;
    }


    /**
     * Gets the RFC value for this ModelCatProveedores.
     * 
     * @return RFC
     */
    public java.lang.String getRFC() {
        return RFC;
    }


    /**
     * Sets the RFC value for this ModelCatProveedores.
     * 
     * @param RFC
     */
    public void setRFC(java.lang.String RFC) {
        this.RFC = RFC;
    }


    /**
     * Gets the DIRECCIONELECTRONICA value for this ModelCatProveedores.
     * 
     * @return DIRECCIONELECTRONICA
     */
    public java.lang.String getDIRECCIONELECTRONICA() {
        return DIRECCIONELECTRONICA;
    }


    /**
     * Sets the DIRECCIONELECTRONICA value for this ModelCatProveedores.
     * 
     * @param DIRECCIONELECTRONICA
     */
    public void setDIRECCIONELECTRONICA(java.lang.String DIRECCIONELECTRONICA) {
        this.DIRECCIONELECTRONICA = DIRECCIONELECTRONICA;
    }


    /**
     * Gets the CALLE value for this ModelCatProveedores.
     * 
     * @return CALLE
     */
    public java.lang.String getCALLE() {
        return CALLE;
    }


    /**
     * Sets the CALLE value for this ModelCatProveedores.
     * 
     * @param CALLE
     */
    public void setCALLE(java.lang.String CALLE) {
        this.CALLE = CALLE;
    }


    /**
     * Gets the CODPOS value for this ModelCatProveedores.
     * 
     * @return CODPOS
     */
    public java.lang.String getCODPOS() {
        return CODPOS;
    }


    /**
     * Sets the CODPOS value for this ModelCatProveedores.
     * 
     * @param CODPOS
     */
    public void setCODPOS(java.lang.String CODPOS) {
        this.CODPOS = CODPOS;
    }


    /**
     * Gets the PAIS value for this ModelCatProveedores.
     * 
     * @return PAIS
     */
    public java.lang.String getPAIS() {
        return PAIS;
    }


    /**
     * Sets the PAIS value for this ModelCatProveedores.
     * 
     * @param PAIS
     */
    public void setPAIS(java.lang.String PAIS) {
        this.PAIS = PAIS;
    }


    /**
     * Gets the CIUDAD value for this ModelCatProveedores.
     * 
     * @return CIUDAD
     */
    public java.lang.String getCIUDAD() {
        return CIUDAD;
    }


    /**
     * Sets the CIUDAD value for this ModelCatProveedores.
     * 
     * @param CIUDAD
     */
    public void setCIUDAD(java.lang.String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }


    /**
     * Gets the PROVINCIA value for this ModelCatProveedores.
     * 
     * @return PROVINCIA
     */
    public java.lang.String getPROVINCIA() {
        return PROVINCIA;
    }


    /**
     * Sets the PROVINCIA value for this ModelCatProveedores.
     * 
     * @param PROVINCIA
     */
    public void setPROVINCIA(java.lang.String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }


    /**
     * Gets the BARRIO value for this ModelCatProveedores.
     * 
     * @return BARRIO
     */
    public java.lang.String getBARRIO() {
        return BARRIO;
    }


    /**
     * Sets the BARRIO value for this ModelCatProveedores.
     * 
     * @param BARRIO
     */
    public void setBARRIO(java.lang.String BARRIO) {
        this.BARRIO = BARRIO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModelCatProveedores)) return false;
        ModelCatProveedores other = (ModelCatProveedores) obj;
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
            ((this.DENOMINACION==null && other.getDENOMINACION()==null) || 
             (this.DENOMINACION!=null &&
              this.DENOMINACION.equals(other.getDENOMINACION()))) &&
            ((this.RFC==null && other.getRFC()==null) || 
             (this.RFC!=null &&
              this.RFC.equals(other.getRFC()))) &&
            ((this.DIRECCIONELECTRONICA==null && other.getDIRECCIONELECTRONICA()==null) || 
             (this.DIRECCIONELECTRONICA!=null &&
              this.DIRECCIONELECTRONICA.equals(other.getDIRECCIONELECTRONICA()))) &&
            ((this.CALLE==null && other.getCALLE()==null) || 
             (this.CALLE!=null &&
              this.CALLE.equals(other.getCALLE()))) &&
            ((this.CODPOS==null && other.getCODPOS()==null) || 
             (this.CODPOS!=null &&
              this.CODPOS.equals(other.getCODPOS()))) &&
            ((this.PAIS==null && other.getPAIS()==null) || 
             (this.PAIS!=null &&
              this.PAIS.equals(other.getPAIS()))) &&
            ((this.CIUDAD==null && other.getCIUDAD()==null) || 
             (this.CIUDAD!=null &&
              this.CIUDAD.equals(other.getCIUDAD()))) &&
            ((this.PROVINCIA==null && other.getPROVINCIA()==null) || 
             (this.PROVINCIA!=null &&
              this.PROVINCIA.equals(other.getPROVINCIA()))) &&
            ((this.BARRIO==null && other.getBARRIO()==null) || 
             (this.BARRIO!=null &&
              this.BARRIO.equals(other.getBARRIO())));
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
        if (getDENOMINACION() != null) {
            _hashCode += getDENOMINACION().hashCode();
        }
        if (getRFC() != null) {
            _hashCode += getRFC().hashCode();
        }
        if (getDIRECCIONELECTRONICA() != null) {
            _hashCode += getDIRECCIONELECTRONICA().hashCode();
        }
        if (getCALLE() != null) {
            _hashCode += getCALLE().hashCode();
        }
        if (getCODPOS() != null) {
            _hashCode += getCODPOS().hashCode();
        }
        if (getPAIS() != null) {
            _hashCode += getPAIS().hashCode();
        }
        if (getCIUDAD() != null) {
            _hashCode += getCIUDAD().hashCode();
        }
        if (getPROVINCIA() != null) {
            _hashCode += getPROVINCIA().hashCode();
        }
        if (getBARRIO() != null) {
            _hashCode += getBARRIO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModelCatProveedores.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ModelCatProveedores"));
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
        elemField.setFieldName("DENOMINACION");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DENOMINACION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RFC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DIRECCIONELECTRONICA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DIRECCIONELECTRONICA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CALLE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CALLE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODPOS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CODPOS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAIS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PAIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIUDAD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CIUDAD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROVINCIA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PROVINCIA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BARRIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BARRIO"));
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
