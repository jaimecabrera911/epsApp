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
@Table(name = "convenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenios.findAll", query = "SELECT c FROM Convenios c")
    , @NamedQuery(name = "Convenios.findByIdConvenio", query = "SELECT c FROM Convenios c WHERE c.idConvenio = :idConvenio")
    , @NamedQuery(name = "Convenios.findByNomConvenio", query = "SELECT c FROM Convenios c WHERE c.nomConvenio = :nomConvenio")})
public class Convenios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_convenio")
    private Integer idConvenio;
    @Size(max = 40)
    @Column(name = "nom_convenio")
    private String nomConvenio;
    @OneToMany(mappedBy = "idConvenio")
    private Collection<Citas> citasCollection;
    @JoinColumn(name = "id_eps", referencedColumnName = "id_eps")
    @ManyToOne
    private Eps idEps;
    @JoinColumn(name = "id_cm", referencedColumnName = "id_cm")
    @ManyToOne
    private CentroMedico idCm;

    public Convenios() {
    }

    public Convenios(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getNomConvenio() {
        return nomConvenio;
    }

    public void setNomConvenio(String nomConvenio) {
        this.nomConvenio = nomConvenio;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    public Eps getIdEps() {
        return idEps;
    }

    public void setIdEps(Eps idEps) {
        this.idEps = idEps;
    }

    public CentroMedico getIdCm() {
        return idCm;
    }

    public void setIdCm(CentroMedico idCm) {
        this.idCm = idCm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvenio != null ? idConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenios)) {
            return false;
        }
        Convenios other = (Convenios) object;
        if ((this.idConvenio == null && other.idConvenio != null) || (this.idConvenio != null && !this.idConvenio.equals(other.idConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.app.entity.Convenios[ idConvenio=" + idConvenio + " ]";
    }
    
}
