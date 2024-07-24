
package com.todocodeacademy.mendez_Bazar.service;

import com.todocodeacademy.mendez_Bazar.model.Producto;
import com.todocodeacademy.mendez_Bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    //aplicamos inyeccion de dependencias de IProductoRepository con AUTOWIRED
    @Autowired
    private IProductoRepository produRepo;

    @Override
    public Producto findProducto(Long codigo) {
        return produRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Producto> getProductos() {
        return produRepo.findAll();
    }

    @Override
    public List<Producto> getProductosSinStock() {
        //traemos todos los productos
        List<Producto> lista_productos = this.getProductos();
        //creamos una lista donde van a estar los productos sin Stok
        List<Producto> lista_productoSinStok = new ArrayList();
        //buscamos los productos menor a cinco lo agregamos a la lista
        for(Producto pr: lista_productos){
            if(pr.getCantidad_disponible() < 5){
                lista_productoSinStok.add(pr);
            }
        }
        //retornamos la lista de productos sin stok
        return lista_productoSinStok;
    }

    @Override
    public void saveProducto(Producto produ) {
        produRepo.save(produ);
    }

    @Override
    public void deleteProducto(Long codigo) {
        produRepo.deleteById(codigo);
    }

    @Override
    public void editProducto(Producto produ) {
        this.saveProducto(produ);
    }
}
