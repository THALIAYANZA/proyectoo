/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Pantalones;
import java.util.List;

/**
 *
 * @author THALY
 */
public interface PantalonesService {
    
    public Pantalones crear(Pantalones p);

    public Pantalones findById(Long id);

    public List<Pantalones> findByAll();

    public void delete(Long id);
    
    public Pantalones codigo(String codigo);
}
