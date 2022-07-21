/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Zapatos;
import com.example.ProeyctoM5A0106306756.repository.ZapatosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THALY
 */
@Service
public class ZapatosServiceImpl implements ZapatosService{
     @Autowired //inyecion para crea un objeto referencial dentro del repositorio
    private ZapatosRepository zapatosRepository;

    @Override
    public Zapatos crear(Zapatos z) {
       return zapatosRepository.save(z);
    }

    @Override
    public Zapatos findById(Long id) {
        return zapatosRepository.findById(id).orElse(null);
    }

    @Override
    public List<Zapatos> findByAll() {
        return zapatosRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        zapatosRepository.deleteById(id);
    }

    @Override
    public Zapatos codigo(String codigo) {
        
        return (Zapatos) zapatosRepository.codigo(codigo);
    }
    
}
