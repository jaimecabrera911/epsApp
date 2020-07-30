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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "localidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l")
    , @NamedQuery(name = "Localidades.findByIdLocalidad", query = "SELECT l FROM Localidades l WHERE l.idLocalidad = :idLocalidad")
    , @NamedQuery(name = "Localidades.findByNombreLocalidad", query = "SELECT l FROM Localidades l WHERE l.nombreLocalidad = :nombreLocalidad")})
public class Localidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_localidad")
    private Integer idLocalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_localidad")
    private String nombreLocalidad;
    @OneToMany(mappedBy = "idLocalidad")
    private Collection<CentroMedico> centroMedicoCollection;

    public Localidades() {
    }

    public Localidades(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Localidades(Integer idLocalidad, String nombreLocalidad) {
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
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
        hash += (idLocalidad != null ? idLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.idLocalidad == null && other.idLocalidad != null) || (this.idLocalidad != null && !this.idLocalidad.equals(other.idLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Localidades[ idLocalidad=" + idLocalidad + " ]";
    }
    
}
