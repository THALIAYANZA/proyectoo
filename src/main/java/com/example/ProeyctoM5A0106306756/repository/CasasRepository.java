
package com.example.ProeyctoM5A0106306756.repository;

import com.example.ProeyctoM5A0106306756.model.Casas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author THALY
 */
public interface CasasRepository extends JpaRepository<Casas, Long>{

   //buscar por codigo
    @Query(value = "SELECT * FROM Casas c WHERE c.codigo = :codigo", nativeQuery = true)
    public Casas codigo(String codigo);
    
}
