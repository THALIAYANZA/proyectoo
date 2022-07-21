/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THALY
 */
@Component
 @Entity
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c"),
    @NamedQuery(name = "Casas.findById", query = "SELECT c FROM Casas c WHERE c.id = :id"),
    @NamedQuery(name = "Casas.findByPropietario", query = "SELECT c FROM Casas c WHERE c.propietario = :propietario"),
    @NamedQuery(name = "Casas.findByCodigo", query = "SELECT c FROM Casas c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Casas.findByArea", query = "SELECT c FROM Casas c WHERE c.area = :area"),
    @NamedQuery(name = "Casas.findByCostototal", query = "SELECT c FROM Casas c WHERE c.costototal = :costototal"),
    @NamedQuery(name = "Casas.findByTipodeterreno", query = "SELECT c FROM Casas c WHERE c.tipodeterreno = :tipodeterreno")})
 
public class Casas implements Serializable{

    @Column(name = "area")
    private Integer area;
    @Column(name = "costototal")
    private Integer costototal;

    

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "propietario")
    private String propietario;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "tipodeterreno")
    private String tipodeterreno;
    @JsonIgnore
    
    
    public Casas() {
    }

    public Casas(Integer area, Integer costototal, Integer id, String propietario, String codigo, String tipodeterreno) {
        this.area = area;
        this.costototal = costototal;
        this.id = id;
        this.propietario = propietario;
        this.codigo = codigo;
        this.tipodeterreno = tipodeterreno;
    }

    public Casas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    

    public String getTipodeterreno() {
        return tipodeterreno;
    }

    public void setTipodeterreno(String tipodeterreno) {
        this.tipodeterreno = tipodeterreno;
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
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
//    @Override
//    public boolean equalss(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Casas)) {
//            return false;
//        }
//        Casas other = (Casas) object;
//        if ((this.codigo == null && other.codigo != null) || (this.codigo!= null && !this.codigo.equals(other.codigo))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "com.example.ProeyctoM5A0106306756.model.Casas[ id=" + id + " ]";
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCostototal() {
        return costototal;
    }

    public void setCostototal(Integer costototal) {
        this.costototal = costototal;
    }

   


    
    
    
}
