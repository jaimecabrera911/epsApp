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
@Table(name = "pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente")
    , @NamedQuery(name = "Pacientes.findByTipoDocumento", query = "SELECT p FROM Pacientes p WHERE p.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Pacientes.findByNumDoc", query = "SELECT p FROM Pacientes p WHERE p.numDoc = :numDoc")
    , @NamedQuery(name = "Pacientes.findByPrimerNombre", query = "SELECT p FROM Pacientes p WHERE p.primerNombre = :primerNombre")
    , @NamedQuery(name = "Pacientes.findBySegundoNombre", query = "SELECT p FROM Pacientes p WHERE p.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Pacientes.findByPrimerApellido", query = "SELECT p FROM Pacientes p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Pacientes.findBySegundoApellido", query = "SELECT p FROM Pacientes p WHERE p.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Pacientes.findByFechaNacimiento", query = "SELECT p FROM Pacientes p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Pacientes.findByDireccionPaciente", query = "SELECT p FROM Pacientes p WHERE p.direccionPaciente = :direccionPaciente")
    , @NamedQuery(name = "Pacientes.findByTelefonoPaciente", query = "SELECT p FROM Pacientes p WHERE p.telefonoPaciente = :telefonoPaciente")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Integer idPaciente;
    @Size(max = 3)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "num_doc")
    private Integer numDoc;
    @Size(max = 15)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 15)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 15)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 15)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "direccion_paciente")
    private String direccionPaciente;
    @Column(name = "telefono_paciente")
    private Integer telefonoPaciente;
    @OneToMany(mappedBy = "idPaciente")
    private Collection<Citas> citasCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;

    public Pacientes() {
    }

    public Pacientes(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public Integer getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(Integer telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Pacientes[ idPaciente=" + idPaciente + " ]";
    }
    
}
