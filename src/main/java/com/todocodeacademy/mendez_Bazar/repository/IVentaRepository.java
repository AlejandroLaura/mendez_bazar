
package com.todocodeacademy.mendez_Bazar.repository;

import com.todocodeacademy.mendez_Bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository <Venta, Long>{
    
}
