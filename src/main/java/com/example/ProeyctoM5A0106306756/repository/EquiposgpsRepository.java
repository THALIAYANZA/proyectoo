/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.repository;

import com.example.ProeyctoM5A0106306756.model.Equiposgps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author THALY
 */
public interface EquiposgpsRepository extends JpaRepository<Equiposgps, Long>{
    
    
     //buscar por codigo
    @Query(value = "SELECT * FROM Equipogps e WHERE e.imei = :imei", nativeQuery = true)
    public Equiposgps imei(String imei);
    
    
}
