
package com.todocodeacademy.mendez_Bazar.service;

import com.todocodeacademy.mendez_Bazar.dto.VentaClienteProductoDTO;
import com.todocodeacademy.mendez_Bazar.dto.VentaProductoDTO;
import com.todocodeacademy.mendez_Bazar.model.Producto;
import com.todocodeacademy.mendez_Bazar.model.Venta;
import java.util.Date;
import java.util.List;


public interface IVentaService {
    //creamos los metodos pero sin su implementacion
    //metodos get para traer una venta
    public Venta findVenta(Long codigo);
    //metodos get para traer todas las ventas
    public List<Venta> getVentas();
    //metodos get para traer lista de productos de una determinada venta
    public List<Producto> getVentasProductos(Long codigo_venta);
    //metodo get para traer la cantidad de ventas y el monto total vendido en un dia
    public VentaProductoDTO getVentasDia(String fecha_dia);
    //metodo get para traer los datos de la venta con el monto mas grande de todos
    public VentaClienteProductoDTO getVentaMontoMayor();
    //metodos post para crear una venta
    public void saveVenta(Venta venta);
    //metodo delete para eliminar una venta
    public void deleteVenta(Long codigo);
    //metodo put para editar una venta
    public void editVenta(Venta venta);
}
