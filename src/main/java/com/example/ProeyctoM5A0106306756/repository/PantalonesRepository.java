
package com.example.ProeyctoM5A0106306756.repository;

import com.example.ProeyctoM5A0106306756.model.Pantalones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author THALY
 */
public interface PantalonesRepository  extends JpaRepository<Pantalones, Long>{
     //buscar por codigo
    @Query(value = "SELECT * FROM Pantalones p WHERE p.codigo = :codigo", nativeQuery = true)
    public Pantalones codigo(String codigo);
    
    
}
