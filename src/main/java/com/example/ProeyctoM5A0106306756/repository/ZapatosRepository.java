/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.repository;

import com.example.ProeyctoM5A0106306756.model.Zapatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author THALY
 */
public interface ZapatosRepository  extends JpaRepository<Zapatos, Long>{
    
     //buscar por codigo
    @Query(value = "SELECT * FROM Zapatos z WHERE z.codigo = :codigo", nativeQuery = true)
    public Zapatos codigo(String codigo);
    
}
