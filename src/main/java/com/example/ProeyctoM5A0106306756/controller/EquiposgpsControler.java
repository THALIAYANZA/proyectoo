/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.controller;

import com.example.ProeyctoM5A0106306756.model.Equiposgps;
import com.example.ProeyctoM5A0106306756.service.EquiposgpsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author THALY
 */
@RestController
@RequestMapping("/api/equiposgps")
public class EquiposgpsControler {
    
    
    @Autowired
    EquiposgpsService equiposgpsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Equiposgps>> listar() {
        
        return new ResponseEntity<>(equiposgpsService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Equiposgps> crear(@RequestBody Equiposgps e) {
        return new ResponseEntity<>(equiposgpsService.crear(e), HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Equiposgps> eliminar(@PathVariable Long id) {
        equiposgpsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Equiposgps> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(buscarEquiposgps(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Equiposgps> actualizar(@PathVariable Long id, @RequestBody Equiposgps e) {
        Equiposgps equiposgps = buscarEquiposgps(id);
        
        if (equiposgps == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                equiposgps.setEquipo(e.getEquipo());
                equiposgps.setImei(e.getImei());
                equiposgps.setNumerodechip(e.getNumerodechip());
                equiposgps.setSerie(e.getSerie());
                equiposgps.setCosto(e.getCosto());
                equiposgps.setObservacion(e.getObservacion());

                return new ResponseEntity<>(equiposgpsService.crear(e), HttpStatus.OK);

            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    public Equiposgps buscarEquiposgps(Long id) {
        return equiposgpsService.findById(id);
    }

    @PostMapping("/buscarporimei")
    public ResponseEntity<Equiposgps>buscarporimei(@RequestBody Equiposgps e){
    Equiposgps equiposgps = equiposgpsService.imei(e.getImei());
    if(equiposgps ==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }else{
    return new ResponseEntity<>(equiposgps, HttpStatus.OK);
    }
    }
    
    
    
    
}
