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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "centro_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroMedico.findAll", query = "SELECT c FROM CentroMedico c")
    , @NamedQuery(name = "CentroMedico.findByIdCm", query = "SELECT c FROM CentroMedico c WHERE c.idCm = :idCm")
    , @NamedQuery(name = "CentroMedico.findByNomCm", query = "SELECT c FROM CentroMedico c WHERE c.nomCm = :nomCm")
    , @NamedQuery(name = "CentroMedico.findByDireccionCm", query = "SELECT c FROM CentroMedico c WHERE c.direccionCm = :direccionCm")
    , @NamedQuery(name = "CentroMedico.findByTelefonoCm", query = "SELECT c FROM CentroMedico c WHERE c.telefonoCm = :telefonoCm")})
public class CentroMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cm")
    private Integer idCm;
    @Size(max = 40)
    @Column(name = "nom_cm")
    private String nomCm;
    @Size(max = 50)
    @Column(name = "direccion_cm")
    private String direccionCm;
    @Size(max = 30)
    @Column(name = "telefono_cm")
    private String telefonoCm;
    @OneToMany(mappedBy = "idCm")
    private Collection<Personalcm> personalcmCollection;
    @OneToMany(mappedBy = "idCm")
    private Collection<Convenios> conveniosCollection;
    @JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad")
    @ManyToOne
    private Localidades idLocalidad;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private Especialidad idEspecialidad;
    @JoinColumn(name = "id_nivel_atencion", referencedColumnName = "id_nivel_atencion")
    @ManyToOne
    private NivelAtencion idNivelAtencion;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    @ManyToOne
    private Horarios idHorario;

    public CentroMedico() {
    }

    public CentroMedico(Integer idCm) {
        this.idCm = idCm;
    }

    public Integer getIdCm() {
        return idCm;
    }

    public void setIdCm(Integer idCm) {
        this.idCm = idCm;
    }

    public String getNomCm() {
        return nomCm;
    }

    public void setNomCm(String nomCm) {
        this.nomCm = nomCm;
    }

    public String getDireccionCm() {
        return direccionCm;
    }

    public void setDireccionCm(String direccionCm) {
        this.direccionCm = direccionCm;
    }

    public String getTelefonoCm() {
        return telefonoCm;
    }

    public void setTelefonoCm(String telefonoCm) {
        this.telefonoCm = telefonoCm;
    }

    @XmlTransient
    public Collection<Personalcm> getPersonalcmCollection() {
        return personalcmCollection;
    }

    public void setPersonalcmCollection(Collection<Personalcm> personalcmCollection) {
        this.personalcmCollection = personalcmCollection;
    }

    @XmlTransient
    public Collection<Convenios> getConveniosCollection() {
        return conveniosCollection;
    }

    public void setConveniosCollection(Collection<Convenios> conveniosCollection) {
        this.conveniosCollection = conveniosCollection;
    }

    public Localidades getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidades idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public NivelAtencion getIdNivelAtencion() {
        return idNivelAtencion;
    }

    public void setIdNivelAtencion(NivelAtencion idNivelAtencion) {
        this.idNivelAtencion = idNivelAtencion;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCm != null ? idCm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroMedico)) {
            return false;
        }
        CentroMedico other = (CentroMedico) object;
        if ((this.idCm == null && other.idCm != null) || (this.idCm != null && !this.idCm.equals(other.idCm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.CentroMedico[ idCm=" + idCm + " ]";
    }
    
}
