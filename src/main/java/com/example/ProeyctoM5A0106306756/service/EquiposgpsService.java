/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Equiposgps;
import java.util.List;

/**
 *
 * @author THALY
 */
public interface EquiposgpsService {
    
     public Equiposgps crear(Equiposgps e);

    public Equiposgps findById(Long id);

    public List<Equiposgps> findByAll();

    public void delete(Long id);
    
    public Equiposgps imei(String imei);
    
}
