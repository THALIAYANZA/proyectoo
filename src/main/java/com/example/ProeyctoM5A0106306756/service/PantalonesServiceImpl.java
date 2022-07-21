/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Pantalones;
import com.example.ProeyctoM5A0106306756.repository.PantalonesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THALY
 */
@Service
public class PantalonesServiceImpl implements PantalonesService{
    
     @Autowired //inyecion para crea un objeto referencial dentro del repositorio
    private PantalonesRepository pantalonesRepository;
    

    @Override
    public Pantalones crear(Pantalones p) {
         return pantalonesRepository.save(p);
    }

    @Override
    public Pantalones findById(Long id) {
        return pantalonesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pantalones> findByAll() {
        return pantalonesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pantalonesRepository.deleteById(id);
    }

    @Override
    public Pantalones codigo(String codigo) {
        return pantalonesRepository.codigo(codigo);
    
    }
    
}
