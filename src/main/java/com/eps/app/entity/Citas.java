/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByIdCita", query = "SELECT c FROM Citas c WHERE c.idCita = :idCita")
    , @NamedQuery(name = "Citas.findByFechaCita", query = "SELECT c FROM Citas c WHERE c.fechaCita = :fechaCita")
    , @NamedQuery(name = "Citas.findByEstadoCita", query = "SELECT c FROM Citas c WHERE c.estadoCita = :estadoCita")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cita")
    private Integer idCita;
    @Column(name = "fecha_cita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCita;
    @Size(max = 11)
    @Column(name = "estado_cita")
    private String estadoCita;
    @OneToMany(mappedBy = "idCita")
    private Collection<Calificacion> calificacionCollection;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private Pacientes idPaciente;
    @JoinColumn(name = "id_personalcm", referencedColumnName = "id_personalcm")
    @ManyToOne
    private Personalcm idPersonalcm;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne
    private Convenios idConvenio;

    public Citas() {
    }

    public Citas(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Personalcm getIdPersonalcm() {
        return idPersonalcm;
    }

    public void setIdPersonalcm(Personalcm idPersonalcm) {
        this.idPersonalcm = idPersonalcm;
    }

    public Convenios getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenios idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Citas[ idCita=" + idCita + " ]";
    }
    
}
