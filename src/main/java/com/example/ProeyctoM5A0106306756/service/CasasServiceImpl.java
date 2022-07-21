/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Casas;
import com.example.ProeyctoM5A0106306756.repository.CasasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author THALY
 */
@Service
public class CasasServiceImpl implements CasasService {
    
    @Autowired
    private CasasRepository casasRepository;

    @Override
    public Casas crear(Casas c) {
        return casasRepository.save(c);
    }

    @Override
    public Casas findById(Long id) {
        return casasRepository.findById(id).orElse(null);
    }

    @Override
    public List<Casas> findByAll() {
         return casasRepository.findAll();
    }

    
    @Override
    public void delete(Long id) {
        casasRepository.deleteById(id);
    }
//
//    @Override
//    public List<Casas> buscarporcodigo(String codigo) {
//        return casasRepository.findByCodigo(codigo);
//    
//    }


    @Override
    public Casas codigo(String codigo) {
        return (Casas) casasRepository.codigo(codigo);
    
    }
    
}
