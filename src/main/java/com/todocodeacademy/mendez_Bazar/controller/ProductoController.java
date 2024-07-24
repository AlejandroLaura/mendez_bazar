
package com.todocodeacademy.mendez_Bazar.controller;

import com.todocodeacademy.mendez_Bazar.model.Producto;
import com.todocodeacademy.mendez_Bazar.service.IProductoService;
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
public class ProductoController {
    //aplicamos inyeccion de dependencias de IProductoService con @Autowired
    @Autowired
    private IProductoService produServis;
    //realizamos los endpoint CRUD
    //endpoint para traer un producto
    @GetMapping("/producto/traer")
    @ResponseBody
    public Producto findProducto(@RequestParam Long codigo){
        return produServis.findProducto(codigo);
    }
    //endpoint para traer todos los productos
    @GetMapping("/productos/traer")
    @ResponseBody
    public List<Producto> getProductos(){
        return produServis.getProductos();
    }
    //endpoint para traer todos los productos sin stock
    @GetMapping("/productos/falta_stock")
    @ResponseBody
    public List<Producto> getProductosSinStock(){
        return produServis.getProductosSinStock();
    }
    //endpoint para dar de alta un producto
    @PostMapping("/producto/crear")
    public String createProducto(@RequestBody Producto pro){
        produServis.saveProducto(pro);
        return "El producto fue creado correctamente";
    }
    //endpoint para dar de baja un producto
    @DeleteMapping("/producto/borrar")
    public String deleteProducto(@RequestParam Long codigo){
        produServis.deleteProducto(codigo);
        return "Producto eliminado exitosamente";
    }
    //endpoint para editar un producto
    @PutMapping("/producto/editar")
    public String editProducto(@RequestBody Producto pro){
        produServis.editProducto(pro);
        return "Producto editado correctamente";
    }
    
    
}
