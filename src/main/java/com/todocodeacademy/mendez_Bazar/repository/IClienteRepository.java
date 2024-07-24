
package com.todocodeacademy.mendez_Bazar.repository;

import com.todocodeacademy.mendez_Bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long>{
    
}
