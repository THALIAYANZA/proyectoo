/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Casas;
import java.util.List;

/**
 *
 * @author THALY
 */
public interface CasasService {
    
    public Casas crear(Casas c);

    public Casas findById(Long id);

    public List<Casas> findByAll();
    
    public Casas codigo(String codigo);

    public void delete(Long id);


    
    
}
