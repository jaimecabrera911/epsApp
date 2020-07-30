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
@Table(name = "eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e")
    , @NamedQuery(name = "Eps.findByIdEps", query = "SELECT e FROM Eps e WHERE e.idEps = :idEps")
    , @NamedQuery(name = "Eps.findByNitEps", query = "SELECT e FROM Eps e WHERE e.nitEps = :nitEps")
    , @NamedQuery(name = "Eps.findByNombreEps", query = "SELECT e FROM Eps e WHERE e.nombreEps = :nombreEps")
    , @NamedQuery(name = "Eps.findByDireccionEps", query = "SELECT e FROM Eps e WHERE e.direccionEps = :direccionEps")
    , @NamedQuery(name = "Eps.findByTelefonoEps", query = "SELECT e FROM Eps e WHERE e.telefonoEps = :telefonoEps")})
public class Eps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_eps")
    private Integer idEps;
    @Column(name = "nit_eps")
    private Integer nitEps;
    @Size(max = 30)
    @Column(name = "nombre_eps")
    private String nombreEps;
    @Size(max = 45)
    @Column(name = "direccion_eps")
    private String direccionEps;
    @Column(name = "telefono_eps")
    private Integer telefonoEps;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;
    @OneToMany(mappedBy = "idEps")
    private Collection<Convenios> conveniosCollection;

    public Eps() {
    }

    public Eps(Integer idEps) {
        this.idEps = idEps;
    }

    public Integer getIdEps() {
        return idEps;
    }

    public void setIdEps(Integer idEps) {
        this.idEps = idEps;
    }

    public Integer getNitEps() {
        return nitEps;
    }

    public void setNitEps(Integer nitEps) {
        this.nitEps = nitEps;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    public String getDireccionEps() {
        return direccionEps;
    }

    public void setDireccionEps(String direccionEps) {
        this.direccionEps = direccionEps;
    }

    public Integer getTelefonoEps() {
        return telefonoEps;
    }

    public void setTelefonoEps(Integer telefonoEps) {
        this.telefonoEps = telefonoEps;
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

    @XmlTransient
    public Collection<Convenios> getConveniosCollection() {
        return conveniosCollection;
    }

    public void setConveniosCollection(Collection<Convenios> conveniosCollection) {
        this.conveniosCollection = conveniosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEps != null ? idEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.idEps == null && other.idEps != null) || (this.idEps != null && !this.idEps.equals(other.idEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Eps[ idEps=" + idEps + " ]";
    }
    
}
