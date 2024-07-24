
package com.todocodeacademy.mendez_Bazar.service;

import com.todocodeacademy.mendez_Bazar.dto.VentaClienteProductoDTO;
import com.todocodeacademy.mendez_Bazar.dto.VentaProductoDTO;
import com.todocodeacademy.mendez_Bazar.model.Producto;
import com.todocodeacademy.mendez_Bazar.model.Venta;
import com.todocodeacademy.mendez_Bazar.repository.IVentaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    //aplicamos inyeccion de dependencias de IVentaRepository con AUTOWIRED
    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoService productoServis;
    //metodo para buscar una venta 
    @Override
    public Venta findVenta(Long codigo) {
        return ventaRepo.findById(codigo).orElse(null);
    }
    //metodo para buscar todas las ventas
    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }
    //metodo para traer una lista de productos de una determinada venta
    @Override
    public List<Producto> getVentasProductos(Long codigo_venta) {
        //buscamos la venta con el codigo
        Venta ven = this.findVenta(codigo_venta);
        return ven.getListaProductos();
    }
    //metodo para traer la cantidad de ventas y el monto total vendido en un dia
    @Override
    public VentaProductoDTO getVentasDia(String fecha_dia) {
        
        
            Date fecha_buscar = null;
            //tranformamos de string a tipo date
        try{    
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            fecha_buscar = formato.parse(fecha_dia);
            if(fecha_buscar != null){
                System.out.println("Fecha convertida: " + fecha_buscar);
            }
            else{
                System.out.println("La cnversion de la fecha n fue exitosa.");
            }
        } catch (Exception e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("El valor de la fecha a buscar es" + fecha_buscar);
        //creamos el objeto a retornar y variables a setear 
        VentaProductoDTO venta = new VentaProductoDTO();
        int cantidad_ventas = 0;
        Double monto_total = 0.0;

        //traemos todas las ventas en una lista 
        List<Venta> lista_venta = this.getVentas();

        //recorremos todas las ventas y completamos
        for(Venta ven: lista_venta){
            if(ven.getFecha_venta().equals(fecha_buscar)){
                monto_total = monto_total + ven.getTotal();
                cantidad_ventas ++;
            }
        }
        //seteamos y retornamos el objeto
        venta.setCantidad_de_ventas(cantidad_ventas);
        venta.setMonto_total(monto_total);
        
        return venta;
        
        
        
    }
    //metodo para traer los datos de la venta con el monto mas grande de todos
    @Override
    public VentaClienteProductoDTO getVentaMontoMayor() {
        //creamos el objeto a retornar y las variables necesarias
        VentaClienteProductoDTO datos_venta_mayor = new VentaClienteProductoDTO();
        Venta ventaMayor = new Venta();
        Double monto_mayor = 0.0;
        //traemos a una lista todas las ventas
        List<Venta> listaVentas = this.getVentas();
        //recorremos y nos quedamos con la venta con el monto mas grande
        
        for(Venta ven: listaVentas){
        
            if(ven.getTotal() > monto_mayor){
                monto_mayor = ven.getTotal();
                ventaMayor = ven;
            }
        }
        //seteamos el producto a retornar
        datos_venta_mayor.setCodigo_venta(ventaMayor.getCodigo());
        datos_venta_mayor.setCantidad_de_productos(ventaMayor.getListaProductos().size());
        datos_venta_mayor.setTotal(ventaMayor.getTotal());
        datos_venta_mayor.setNombre_cliente(ventaMayor.getUnCliente().getNombre());
        datos_venta_mayor.setApellido_cliente(ventaMayor.getUnCliente().getApellido());
        return datos_venta_mayor;
    }

    @Override
    public void saveVenta(Venta venta) {
        //calculamos el total de manera automatica
        //declaramos la variable del monto total de la venta y lista de prductos de la venta
        Double montoTotal = 0.0;
        List<Producto> listaProductos = venta.getListaProductos();
        //recorremos la lista y vamos sumando los montos por cada producto
        for(Producto pro: listaProductos){
            Producto productoActual = productoServis.findProducto(pro.getCodigo());
            montoTotal = montoTotal + productoActual.getCosto();
        }
        venta.setTotal(montoTotal);
        
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long codigo) {
        ventaRepo.deleteById(codigo);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }
}
