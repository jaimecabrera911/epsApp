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
import javax.persistence.Lob;
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
@Table(name = "calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdCalificacion", query = "SELECT c FROM Calificacion c WHERE c.idCalificacion = :idCalificacion")
    , @NamedQuery(name = "Calificacion.findByNomCalificacion", query = "SELECT c FROM Calificacion c WHERE c.nomCalificacion = :nomCalificacion")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;
    @Size(max = 9)
    @Column(name = "nom_calificacion")
    private String nomCalificacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_cita", referencedColumnName = "id_cita")
    @ManyToOne
    private Citas idCita;
    @OneToMany(mappedBy = "idCalificacion")
    private Collection<ComentarioEps> comentarioEpsCollection;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public String getNomCalificacion() {
        return nomCalificacion;
    }

    public void setNomCalificacion(String nomCalificacion) {
        this.nomCalificacion = nomCalificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Citas getIdCita() {
        return idCita;
    }

    public void setIdCita(Citas idCita) {
        this.idCita = idCita;
    }

    @XmlTransient
    public Collection<ComentarioEps> getComentarioEpsCollection() {
        return comentarioEpsCollection;
    }

    public void setComentarioEpsCollection(Collection<ComentarioEps> comentarioEpsCollection) {
        this.comentarioEpsCollection = comentarioEpsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacion != null ? idCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idCalificacion == null && other.idCalificacion != null) || (this.idCalificacion != null && !this.idCalificacion.equals(other.idCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Calificacion[ idCalificacion=" + idCalificacion + " ]";
    }
    
}
