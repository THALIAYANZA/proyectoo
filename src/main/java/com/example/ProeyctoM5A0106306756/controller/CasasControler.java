
package com.example.ProeyctoM5A0106306756.controller;

import com.example.ProeyctoM5A0106306756.model.Casas;
import com.example.ProeyctoM5A0106306756.service.CasasService;
import java.util.ArrayList;
import java.util.List;

import com.example.ProeyctoM5A0106306756.service.CasasServiceImpl;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author THALY
 */
@RestController
@RequestMapping("/api/casas")
public class CasasControler {
    
    @Autowired
    CasasService casasService;

    @Autowired
    CasasServiceImpl servicecasas;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Casas>>listar(){
        List<Casas> lista = servicecasas.findByAll();
        List<Casas>  nuevalista  = new ArrayList<>();
        for ( Casas casas : lista) {
            int costototal = casas.getArea()*80;
            //System.out.println(costototal+"hola mundo");
            casas.setCostototal(costototal);
            nuevalista.add(casas);
        }
    return new ResponseEntity<>(nuevalista, HttpStatus.OK);
    
    }
    @GetMapping("/casasAll")
    public ResponseEntity<List<Casas>> listAsientoAll( ) {
        List<Casas> list = servicecasas.findByAll();
        return new ResponseEntity<List<Casas>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Casas> crear(@RequestBody Casas c) {
        return new ResponseEntity<>(servicecasas.crear(c), HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Casas> eliminar(@PathVariable Long id) {
        casasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Casas> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(buscarCasas(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Casas> actualizar(@PathVariable Long id, @RequestBody Casas c) {
        Casas casas = buscarCasas(id);
        
        if (casas == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                casas.setPropietario(c.getPropietario());
                casas.setCodigo(c.getCodigo());
                casas.setArea(c.getArea());
                casas.setCostototal(c.getCostototal());
                casas.setTipodeterreno(c.getTipodeterreno());
                

                return new ResponseEntity<>(casasService.crear(c), HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    public Casas buscarCasas(Long id) {
        return casasService.findById(id);
    }
    
    @PostMapping("/buscarpor codigo")
    public ResponseEntity<Casas>buscarporcadigo(@RequestBody Casas c){
    Casas casas = casasService.codigo(c.getCodigo());
    if(casas ==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }else{
    return new ResponseEntity<>(casas, HttpStatus.OK);
    }
    }
    
    
    
    
    
}
