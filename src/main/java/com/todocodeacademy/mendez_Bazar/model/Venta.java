
package com.todocodeacademy.mendez_Bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;
    private Double total;
    @OneToMany
    private List<ItemVenta> listaProductosCantidad;
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo, Date fecha_venta, Double total, List<ItemVenta> listaProductosCantidad, Cliente unCliente) {
        this.codigo = codigo;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductosCantidad = listaProductosCantidad;
        this.unCliente = unCliente;
    }

    
    
    
}
