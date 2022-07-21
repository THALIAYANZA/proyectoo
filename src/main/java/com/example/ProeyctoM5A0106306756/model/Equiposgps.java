/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THALY
 */
@Entity
@Table(name = "equiposgps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equiposgps.findAll", query = "SELECT e FROM Equiposgps e")
    , @NamedQuery(name = "Equiposgps.findById", query = "SELECT e FROM Equiposgps e WHERE e.id = :id")
    , @NamedQuery(name = "Equiposgps.findByEquipo", query = "SELECT e FROM Equiposgps e WHERE e.equipo = :equipo")
    , @NamedQuery(name = "Equiposgps.findByImei", query = "SELECT e FROM Equiposgps e WHERE e.imei = :imei")
    , @NamedQuery(name = "Equiposgps.findByNumerodechip", query = "SELECT e FROM Equiposgps e WHERE e.numerodechip = :numerodechip")
    , @NamedQuery(name = "Equiposgps.findBySerie", query = "SELECT e FROM Equiposgps e WHERE e.serie = :serie")
    , @NamedQuery(name = "Equiposgps.findByCosto", query = "SELECT e FROM Equiposgps e WHERE e.costo = :costo")
    , @NamedQuery(name = "Equiposgps.findByObservacion", query = "SELECT e FROM Equiposgps e WHERE e.observacion = :observacion")})
public class Equiposgps implements Serializable {

    @Column(name = "costo")
    private Integer costo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "equipo")
    private String equipo;
    @Column(name = "imei")
    private String imei;
    @Column(name = "numerodechip")
    private String numerodechip;
    @Column(name = "serie")
    private String serie;
    @Column(name = "observacion")
    private String observacion;

    public Equiposgps() {
    }

    public Equiposgps(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getNumerodechip() {
        return numerodechip;
    }

    public void setNumerodechip(String numerodechip) {
        this.numerodechip = numerodechip;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equiposgps)) {
            return false;
        }
        Equiposgps other = (Equiposgps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ProeyctoM5A0106306756.model.Equiposgps[ id=" + id + " ]";
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
}
