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
@Table(name = "zapatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zapatos.findAll", query = "SELECT z FROM Zapatos z")
    , @NamedQuery(name = "Zapatos.findById", query = "SELECT z FROM Zapatos z WHERE z.id = :id")
    , @NamedQuery(name = "Zapatos.findByMarca", query = "SELECT z FROM Zapatos z WHERE z.marca = :marca")
    , @NamedQuery(name = "Zapatos.findByCodigo", query = "SELECT z FROM Zapatos z WHERE z.codigo = :codigo")
    , @NamedQuery(name = "Zapatos.findByCosto", query = "SELECT z FROM Zapatos z WHERE z.costo = :costo")
    , @NamedQuery(name = "Zapatos.findByCostototal", query = "SELECT z FROM Zapatos z WHERE z.costototal = :costototal")    
    , @NamedQuery(name = "Zapatos.findByCantidad", query = "SELECT z FROM Zapatos z WHERE z.cantidad = :cantidad")
    , @NamedQuery(name = "Zapatos.findByTipodezapato", query = "SELECT z FROM Zapatos z WHERE z.tipodezapato = :tipodezapato")})
public class Zapatos implements Serializable {

    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "costototal")
    private Integer costototal;

    @Column(name = "costo")
    private Integer costo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "codigo")
    private String codigo;
     
     
      @Column(name = "tipodezapato")
    private String tipodezapato;

    public Zapatos() {
    }

    public Zapatos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    public String getTipodezapato() {
        return tipodezapato;
    }

    public void setTipodezapato(String tipodezapato) {
        this.tipodezapato = tipodezapato;
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
        if (!(object instanceof Zapatos)) {
            return false;
        }
        Zapatos other = (Zapatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ProeyctoM5A0106306756.model.Zapatos[ id=" + id + " ]";
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCostototal() {
        return costototal;
    }

    public void setCostototal(Integer costototal) {
        this.costototal = costototal;
    }
    
}
