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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 25)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 15)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Administrador> administradorCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Eps> epsCollection;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne
    private Perfiles idPerfil;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<PersonalMedico> personalMedicoCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Pacientes> pacientesCollection;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(Collection<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

    @XmlTransient
    public Collection<Eps> getEpsCollection() {
        return epsCollection;
    }

    public void setEpsCollection(Collection<Eps> epsCollection) {
        this.epsCollection = epsCollection;
    }

    public Perfiles getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfiles idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public Collection<PersonalMedico> getPersonalMedicoCollection() {
        return personalMedicoCollection;
    }

    public void setPersonalMedicoCollection(Collection<PersonalMedico> personalMedicoCollection) {
        this.personalMedicoCollection = personalMedicoCollection;
    }

    @XmlTransient
    public Collection<Pacientes> getPacientesCollection() {
        return pacientesCollection;
    }

    public void setPacientesCollection(Collection<Pacientes> pacientesCollection) {
        this.pacientesCollection = pacientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
