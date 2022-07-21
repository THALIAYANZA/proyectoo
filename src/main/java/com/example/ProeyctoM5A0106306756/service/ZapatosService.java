/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.service;

import com.example.ProeyctoM5A0106306756.model.Zapatos;
import java.util.List;

/**
 *
 * @author THALY
 */
public interface ZapatosService {
    
   public Zapatos crear (Zapatos z);
   
   public Zapatos findById(Long id);
   
   public List<Zapatos> findByAll();
   
   public void delete(Long id);
   
   public Zapatos codigo(String codigo);
   
   
}
