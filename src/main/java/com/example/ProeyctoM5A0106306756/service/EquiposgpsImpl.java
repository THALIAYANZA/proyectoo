/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Equiposgps;
import com.example.ProeyctoM5A0106306756.repository.EquiposgpsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THALY
 */
@Service
public class EquiposgpsImpl implements EquiposgpsService{
     @Autowired //inyecion para crea un objeto referencial dentro del repositorio
    private EquiposgpsRepository equiposgpsRepository;
    
    

    @Override
    public Equiposgps crear(Equiposgps e) {
        return equiposgpsRepository.save(e);
    }

   @Override
    public Equiposgps findById(Long id) {
        return equiposgpsRepository.findById(id).orElse(null);
    }

   @Override
    public List<Equiposgps> findByAll() {
       return equiposgpsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        equiposgpsRepository.deleteById(id);
    }



    @Override
    public Equiposgps imei(String imei) {
        return equiposgpsRepository.imei(imei);
       
    }

    

    
    
}
