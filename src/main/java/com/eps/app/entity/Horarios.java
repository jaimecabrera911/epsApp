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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findByIdHorario", query = "SELECT h FROM Horarios h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "Horarios.findByNomHorario", query = "SELECT h FROM Horarios h WHERE h.nomHorario = :nomHorario")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario")
    private Integer idHorario;
    @Size(max = 200)
    @Column(name = "nom_horario")
    private String nomHorario;
    @OneToMany(mappedBy = "idHorario")
    private Collection<CentroMedico> centroMedicoCollection;

    public Horarios() {
    }

    public Horarios(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getNomHorario() {
        return nomHorario;
    }

    public void setNomHorario(String nomHorario) {
        this.nomHorario = nomHorario;
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
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Horarios[ idHorario=" + idHorario + " ]";
    }
    
}
