/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.app.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "nivel_atencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAtencion.findAll", query = "SELECT n FROM NivelAtencion n")
    , @NamedQuery(name = "NivelAtencion.findByIdNivelAtencion", query = "SELECT n FROM NivelAtencion n WHERE n.idNivelAtencion = :idNivelAtencion")
    , @NamedQuery(name = "NivelAtencion.findByNomNvatencion", query = "SELECT n FROM NivelAtencion n WHERE n.nomNvatencion = :nomNvatencion")})
public class NivelAtencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel_atencion")
    private Integer idNivelAtencion;
    @Size(max = 40)
    @Column(name = "nom_nvatencion")
    private String nomNvatencion;
    @OneToMany(mappedBy = "idNivelAtencion")
    private Collection<CentroMedico> centroMedicoCollection;

    public NivelAtencion() {
    }

    public NivelAtencion(Integer idNivelAtencion) {
        this.idNivelAtencion = idNivelAtencion;
    }

    public Integer getIdNivelAtencion() {
        return idNivelAtencion;
    }

    public void setIdNivelAtencion(Integer idNivelAtencion) {
        this.idNivelAtencion = idNivelAtencion;
    }

    public String getNomNvatencion() {
        return nomNvatencion;
    }

    public void setNomNvatencion(String nomNvatencion) {
        this.nomNvatencion = nomNvatencion;
    }

    @XmlTransient
    public Collection<CentroMedico> getCentroMedicoCollection() {
        return centroMedicoCollection;
    }

    public void setCentroMedicoCollection(Collection<CentroMedico> centroMedicoCollection) {
        this.centroMedicoCollection = centroMedicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelAtencion != null ? idNivelAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAtencion)) {
            return false;
        }
        NivelAtencion other = (NivelAtencion) object;
        if ((this.idNivelAtencion == null && other.idNivelAtencion != null) || (this.idNivelAtencion != null && !this.idNivelAtencion.equals(other.idNivelAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.NivelAtencion[ idNivelAtencion=" + idNivelAtencion + " ]";
    }
    
}
