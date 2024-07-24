
package com.todocodeacademy.mendez_Bazar.controller;

import com.todocodeacademy.mendez_Bazar.dto.VentaClienteProductoDTO;
import com.todocodeacademy.mendez_Bazar.dto.VentaProductoDTO;
import com.todocodeacademy.mendez_Bazar.model.Producto;
import com.todocodeacademy.mendez_Bazar.model.Venta;
import com.todocodeacademy.mendez_Bazar.service.IVentaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    //aplicamos inyeccion de dependencias de IVentaController con @Autowired
    @Autowired
    private IVentaService ventaServis;
    //procedemos a crear los endpoint
    //endpoint para traer una venta
    @GetMapping("/venta/traer")
    @ResponseBody
    public Venta findVenta(@RequestParam Long codigo){
        return ventaServis.findVenta(codigo);
    }
    //endpoint para traer todas las ventas
    @GetMapping("/ventas/traer")
    @ResponseBody
    public List<Venta> getVentas(){
        return ventaServis.getVentas();
    }
    //endpoint para traer todos los productos de una venta
    @GetMapping("/venta/productos/traer")
    @ResponseBody
    public List<Producto> getVentaProductos(@RequestParam Long codigo){
       return ventaServis.getVentasProductos(codigo);
    }
    //endpoint para traer las ventas de un determinado dia
    @GetMapping("/ventas/dia/traer")
    @ResponseBody 
    public VentaProductoDTO getVentasDia(@RequestParam String fecha_dia){
        return ventaServis.getVentasDia(fecha_dia);
    }
    //endpoint para traer datos de la venta de mayor monto
    @GetMapping("/venta/mayor_venta")
    @ResponseBody
    public VentaClienteProductoDTO getVentaMayor(){
        return ventaServis.getVentaMontoMayor();
    }
    //endpoint para crear una venta
    @PostMapping("/venta/crear")
    public String createVenta(@RequestBody Venta venta){
        ventaServis.saveVenta(venta);
        return "La venta fue realizada correctamente";
    }
    //endpoint para eliminar una venta
    @DeleteMapping("/venta/borrar")
    public String deleteVenta(@RequestParam Long codigo){
        ventaServis.deleteVenta(codigo);
        return "La venta ha sido eliminada correctamente";
    }
    //endpoint para editar una venta 
    @PutMapping("/venta/editar")
    public String editVenta(@RequestBody Venta venta){
        ventaServis.editVenta(venta);
        return "Venta editada correctamente";
    }
    
}
