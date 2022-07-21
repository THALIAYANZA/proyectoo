/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.controller;

import com.example.ProeyctoM5A0106306756.model.Pantalones;
import com.example.ProeyctoM5A0106306756.service.PantalonesService;
import com.example.ProeyctoM5A0106306756.service.PantalonesServiceImpl;
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
@RequestMapping("/api/pantalones")
public class PantalonesControler {
    
    @Autowired
    PantalonesService pantalonesService;
    
    @Autowired
    PantalonesServiceImpl servicepantalones;

    @GetMapping("/lista")
    public ResponseEntity<List<Pantalones>> listar() {
         List<Pantalones> lista = servicepantalones.findByAll();
        List<Pantalones>  nuevalista  = new ArrayList<>();
        for ( Pantalones pantalones : lista) {
            int costototal = pantalones.getCosto()*pantalones.getCantidad();
            System.out.println(costototal+"hola mundo");
            pantalones.setCostototal(costototal);
            nuevalista.add(pantalones);
        }
                
        return new ResponseEntity<>(servicepantalones.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/pantalonesAll")
    public ResponseEntity<List<Pantalones>> listAsientoAll( ) {
        List<Pantalones> list = servicepantalones.findByAll();
        return new ResponseEntity<List<Pantalones>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Pantalones> crear(@RequestBody Pantalones p) {
        return new ResponseEntity<>(servicepantalones.crear(p), HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Pantalones> eliminar(@PathVariable Long id) {
        pantalonesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pantalones> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(buscarPantalones(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pantalones> actualizar(@PathVariable Long id, @RequestBody Pantalones p) {
        Pantalones pantalones = buscarPantalones(id);
        
        if (pantalones == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                pantalones.setMarca(p.getMarca());
                pantalones.setModelo(p.getModelo());
                pantalones.setFabricante(p.getFabricante());
                pantalones.setCodigo(p.getCodigo());
                pantalones.setCosto(p.getCosto());
                pantalones.setCantidad(p.getCantidad());
                pantalones.setCostototal(p.getCostototal());
                pantalones.setOrigen(p.getOrigen());

                return new ResponseEntity<>(pantalonesService.crear(p), HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    public Pantalones buscarPantalones(Long id) {
        return pantalonesService.findById(id);
    }

     @PostMapping("/buscarporcodigo")
    public ResponseEntity<Pantalones>buscarporcodigo(@RequestBody Pantalones p){
    Pantalones pantalones = pantalonesService.codigo(p.getCodigo());
    if(pantalones ==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }else{
    return new ResponseEntity<>(pantalones, HttpStatus.OK);
    }
    }
    
}
