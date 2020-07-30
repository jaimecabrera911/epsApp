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
import javax.persistence.Lob;
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
@Table(name = "comentario_eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioEps.findAll", query = "SELECT c FROM ComentarioEps c")
    , @NamedQuery(name = "ComentarioEps.findByIdComentario", query = "SELECT c FROM ComentarioEps c WHERE c.idComentario = :idComentario")})
public class ComentarioEps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_calificacion", referencedColumnName = "id_calificacion")
    @ManyToOne
    private Calificacion idCalificacion;

    public ComentarioEps() {
    }

    public ComentarioEps(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Calificacion getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Calificacion idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioEps)) {
            return false;
        }
        ComentarioEps other = (ComentarioEps) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.ComentarioEps[ idComentario=" + idComentario + " ]";
    }
    
}
