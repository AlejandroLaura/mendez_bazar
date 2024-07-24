
package com.todocodeacademy.mendez_Bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaProductoDTO {
    private int cantidad_de_ventas;
    private double monto_total;

    public VentaProductoDTO() {
    }

    public VentaProductoDTO(int cantidad_de_ventas, double monto_total) {
        this.cantidad_de_ventas = cantidad_de_ventas;
        this.monto_total = monto_total;
    }
    
    
    
}
