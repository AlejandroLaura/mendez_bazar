
package com.todocodeacademy.mendez_Bazar.service;

import com.todocodeacademy.mendez_Bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    //creamos los metodos
    //metodo para traer un producto
    public Producto findProducto(Long codigo);
    //metodo para traer todos los productos
    public List<Producto> getProductos();
    //metodo para traer todos los productos en falta de stock(cantidad menor a 5)
    public List<Producto> getProductosSinStock();
    //metodo para dar de alta un producto
    public void saveProducto(Producto produ);
    //metodo para dar de baja un producto
    public void deleteProducto(Long codigo);
    //metodo para editar/modificar un producto
    public void editProducto(Producto produ);
}
