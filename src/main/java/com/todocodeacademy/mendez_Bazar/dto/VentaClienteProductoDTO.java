
package com.todocodeacademy.mendez_Bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteProductoDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidad_de_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaClienteProductoDTO() {
    }

    public VentaClienteProductoDTO(Long codigo_venta, Double total, int cantidad_de_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_de_productos = cantidad_de_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
}
