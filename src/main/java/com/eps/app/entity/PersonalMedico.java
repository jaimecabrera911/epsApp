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
@Table(name = "personal_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalMedico.findAll", query = "SELECT p FROM PersonalMedico p")
    , @NamedQuery(name = "PersonalMedico.findByIdPersonalmedico", query = "SELECT p FROM PersonalMedico p WHERE p.idPersonalmedico = :idPersonalmedico")
    , @NamedQuery(name = "PersonalMedico.findByTipoIde", query = "SELECT p FROM PersonalMedico p WHERE p.tipoIde = :tipoIde")
    , @NamedQuery(name = "PersonalMedico.findByNumIde", query = "SELECT p FROM PersonalMedico p WHERE p.numIde = :numIde")
    , @NamedQuery(name = "PersonalMedico.findByNombrePm", query = "SELECT p FROM PersonalMedico p WHERE p.nombrePm = :nombrePm")
    , @NamedQuery(name = "PersonalMedico.findByApellidoPm", query = "SELECT p FROM PersonalMedico p WHERE p.apellidoPm = :apellidoPm")
    , @NamedQuery(name = "PersonalMedico.findByDireccionPm", query = "SELECT p FROM PersonalMedico p WHERE p.direccionPm = :direccionPm")
    , @NamedQuery(name = "PersonalMedico.findByTelefonoPm", query = "SELECT p FROM PersonalMedico p WHERE p.telefonoPm = :telefonoPm")})
public class PersonalMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personalmedico")
    private Integer idPersonalmedico;
    @Size(max = 3)
    @Column(name = "tipo_ide")
    private String tipoIde;
    @Column(name = "num_ide")
    private Integer numIde;
    @Size(max = 30)
    @Column(name = "nombre_pm")
    private String nombrePm;
    @Size(max = 30)
    @Column(name = "apellido_pm")
    private String apellidoPm;
    @Size(max = 45)
    @Column(name = "direccion_pm")
    private String direccionPm;
    @Column(name = "telefono_pm")
    private Integer telefonoPm;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private Especialidad idEspecialidad;
    @OneToMany(mappedBy = "idPersonalmedico")
    private Collection<Personalcm> personalcmCollection;

    public PersonalMedico() {
    }

    public PersonalMedico(Integer idPersonalmedico) {
        this.idPersonalmedico = idPersonalmedico;
    }

    public Integer getIdPersonalmedico() {
        return idPersonalmedico;
    }

    public void setIdPersonalmedico(Integer idPersonalmedico) {
        this.idPersonalmedico = idPersonalmedico;
    }

    public String getTipoIde() {
        return tipoIde;
    }

    public void setTipoIde(String tipoIde) {
        this.tipoIde = tipoIde;
    }

    public Integer getNumIde() {
        return numIde;
    }

    public void setNumIde(Integer numIde) {
        this.numIde = numIde;
    }

    public String getNombrePm() {
        return nombrePm;
    }

    public void setNombrePm(String nombrePm) {
        this.nombrePm = nombrePm;
    }

    public String getApellidoPm() {
        return apellidoPm;
    }

    public void setApellidoPm(String apellidoPm) {
        this.apellidoPm = apellidoPm;
    }

    public String getDireccionPm() {
        return direccionPm;
    }

    public void setDireccionPm(String direccionPm) {
        this.direccionPm = direccionPm;
    }

    public Integer getTelefonoPm() {
        return telefonoPm;
    }

    public void setTelefonoPm(Integer telefonoPm) {
        this.telefonoPm = telefonoPm;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @XmlTransient
    public Collection<Personalcm> getPersonalcmCollection() {
        return personalcmCollection;
    }

    public void setPersonalcmCollection(Collection<Personalcm> personalcmCollection) {
        this.personalcmCollection = personalcmCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonalmedico != null ? idPersonalmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalMedico)) {
            return false;
        }
        PersonalMedico other = (PersonalMedico) object;
        if ((this.idPersonalmedico == null && other.idPersonalmedico != null) || (this.idPersonalmedico != null && !this.idPersonalmedico.equals(other.idPersonalmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.PersonalMedico[ idPersonalmedico=" + idPersonalmedico + " ]";
    }
    
}
