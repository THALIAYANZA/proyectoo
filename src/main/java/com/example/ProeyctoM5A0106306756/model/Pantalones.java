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
@Table(name = "pantalones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalones.findAll", query = "SELECT p FROM Pantalones p")
    , @NamedQuery(name = "Pantalones.findById", query = "SELECT p FROM Pantalones p WHERE p.id = :id")
    , @NamedQuery(name = "Pantalones.findByMarca", query = "SELECT p FROM Pantalones p WHERE p.marca = :marca")
    , @NamedQuery(name = "Pantalones.findByModelo", query = "SELECT p FROM Pantalones p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Pantalones.findByFabricante", query = "SELECT p FROM Pantalones p WHERE p.fabricante = :fabricante")
    , @NamedQuery(name = "Pantalones.findByCodigo", query = "SELECT p FROM Pantalones p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pantalones.findByCosto", query = "SELECT p FROM Pantalones p WHERE p.costo = :costo")
    , @NamedQuery(name = "Pantalones.findByCantidad", query = "SELECT p FROM Pantalones p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pantalones.findByCostototal", query = "SELECT p FROM Pantalones p WHERE p.costototal = :costototal")
    , @NamedQuery(name = "Pantalones.findByOrigen", query = "SELECT p FROM Pantalones p WHERE p.origen = :origen")})
public class Pantalones implements Serializable {

    @Column(name = "costo")
    private Integer costo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "costototal")
    private Integer costototal;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "origen")
    private String origen;

    public Pantalones() {
    }

    public Pantalones(Integer id) {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
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
        if (!(object instanceof Pantalones)) {
            return false;
        }
        Pantalones other = (Pantalones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.ProeyctoM5A0106306756.model.Pantalones[ id=" + id + " ]";
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
