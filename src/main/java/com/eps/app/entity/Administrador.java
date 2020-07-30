/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.app.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador")
    , @NamedQuery(name = "Administrador.findByNomAdministrador", query = "SELECT a FROM Administrador a WHERE a.nomAdministrador = :nomAdministrador")
    , @NamedQuery(name = "Administrador.findByApellidoAdministrador", query = "SELECT a FROM Administrador a WHERE a.apellidoAdministrador = :apellidoAdministrador")
    , @NamedQuery(name = "Administrador.findByDireccionAdmin", query = "SELECT a FROM Administrador a WHERE a.direccionAdmin = :direccionAdmin")
    , @NamedQuery(name = "Administrador.findByTelefonoAdmin", query = "SELECT a FROM Administrador a WHERE a.telefonoAdmin = :telefonoAdmin")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_administrador")
    private Integer idAdministrador;
    @Size(max = 35)
    @Column(name = "nom_administrador")
    private String nomAdministrador;
    @Size(max = 35)
    @Column(name = "apellido_administrador")
    private String apellidoAdministrador;
    @Size(max = 45)
    @Column(name = "direccion_admin")
    private String direccionAdmin;
    @Column(name = "telefono_admin")
    private Integer telefonoAdmin;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNomAdministrador() {
        return nomAdministrador;
    }

    public void setNomAdministrador(String nomAdministrador) {
        this.nomAdministrador = nomAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getDireccionAdmin() {
        return direccionAdmin;
    }

    public void setDireccionAdmin(String direccionAdmin) {
        this.direccionAdmin = direccionAdmin;
    }

    public Integer getTelefonoAdmin() {
        return telefonoAdmin;
    }

    public void setTelefonoAdmin(Integer telefonoAdmin) {
        this.telefonoAdmin = telefonoAdmin;
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
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
