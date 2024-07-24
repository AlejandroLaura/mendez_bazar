
package com.todocodeacademy.mendez_Bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    

    public Producto() {
    }

    public Producto(Long codigo, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }

    
    
}