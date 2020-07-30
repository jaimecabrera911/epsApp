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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "personalcm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personalcm.findAll", query = "SELECT p FROM Personalcm p")
    , @NamedQuery(name = "Personalcm.findByIdPersonalcm", query = "SELECT p FROM Personalcm p WHERE p.idPersonalcm = :idPersonalcm")})
public class Personalcm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personalcm")
    private Integer idPersonalcm;
    @OneToMany(mappedBy = "idPersonalcm")
    private Collection<Citas> citasCollection;
    @JoinColumn(name = "id_cm", referencedColumnName = "id_cm")
    @ManyToOne
    private CentroMedico idCm;
    @JoinColumn(name = "id_personalmedico", referencedColumnName = "id_personalmedico")
    @ManyToOne
    private PersonalMedico idPersonalmedico;

    public Personalcm() {
    }

    public Personalcm(Integer idPersonalcm) {
        this.idPersonalcm = idPersonalcm;
    }

    public Integer getIdPersonalcm() {
        return idPersonalcm;
    }

    public void setIdPersonalcm(Integer idPersonalcm) {
        this.idPersonalcm = idPersonalcm;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    public CentroMedico getIdCm() {
        return idCm;
    }

    public void setIdCm(CentroMedico idCm) {
        this.idCm = idCm;
    }

    public PersonalMedico getIdPersonalmedico() {
        return idPersonalmedico;
    }

    public void setIdPersonalmedico(PersonalMedico idPersonalmedico) {
        this.idPersonalmedico = idPersonalmedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonalcm != null ? idPersonalcm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personalcm)) {
            return false;
        }
        Personalcm other = (Personalcm) object;
        if ((this.idPersonalcm == null && other.idPersonalcm != null) || (this.idPersonalcm != null && !this.idPersonalcm.equals(other.idPersonalcm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Personalcm[ idPersonalcm=" + idPersonalcm + " ]";
    }
    
}
