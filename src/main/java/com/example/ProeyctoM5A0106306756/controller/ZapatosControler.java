/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ProeyctoM5A0106306756.controller;

import com.example.ProeyctoM5A0106306756.model.Zapatos;
import com.example.ProeyctoM5A0106306756.service.ZapatosService;
import com.example.ProeyctoM5A0106306756.service.ZapatosServiceImpl;
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
@RequestMapping("/api/Zapatos")

public class ZapatosControler {
    
    
    @Autowired
    ZapatosService zapatosService;
    
    @Autowired
    ZapatosServiceImpl servicezapatos;

    @GetMapping("/lista")
    public ResponseEntity<List<Zapatos>> listar() {
         List<Zapatos> lista = servicezapatos.findByAll();
        List<Zapatos>  nuevalista  = new ArrayList<>();
        for ( Zapatos zapatos : lista) {
            int costototal = zapatos.getCosto()* zapatos.getCantidad();
            zapatos.setCostototal(costototal);
            nuevalista.add(zapatos);
            
        }
        return new ResponseEntity<>(nuevalista, HttpStatus.OK);
    }
    
     
    @GetMapping("/zapatosAll")
    public ResponseEntity<List<Zapatos>> listAsientoAll( ) {
        List<Zapatos> list = servicezapatos.findByAll();
        return new ResponseEntity<List<Zapatos>>(list, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Zapatos> crear(@RequestBody Zapatos z) {
        return new ResponseEntity<>(servicezapatos.crear(z), HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Zapatos> eliminar(@PathVariable Long id) {
        zapatosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Zapatos> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(buscarZapatos(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Zapatos> actualizar(@PathVariable Long id, @RequestBody Zapatos z) {
        Zapatos zapatos = buscarZapatos(id);
        
        if (zapatos == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                zapatos.setMarca(z.getMarca());
                zapatos.setCodigo(z.getCodigo());
                zapatos.setCosto(z.getCosto());
                zapatos.setCantidad(z.getCantidad());
                zapatos.setCostototal(z.getCostototal());
                zapatos.setTipodezapato(z.getTipodezapato());

                return new ResponseEntity<>(zapatosService.crear(z), HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    public Zapatos buscarZapatos(Long id) {
        return zapatosService.findById(id);
    }

     @PostMapping("/buscarpor codigo")
    public ResponseEntity<Zapatos>buscarporcadigo(@RequestBody Zapatos z){
    Zapatos zapatos = zapatosService.codigo(z.getCodigo());
    if(zapatos ==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }else{
    return new ResponseEntity<>(zapatos, HttpStatus.OK);
    }
    }
    
}
