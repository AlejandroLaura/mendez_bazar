
package com.todocodeacademy.mendez_Bazar.service;

import com.todocodeacademy.mendez_Bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    //creamos los metodos sin su implementacion
    //metodos para traer un cliente
    public Cliente findCliente(Long id);
    //metodos para traer todos los clientes 
    public List<Cliente> getClientes();
    //metodo para dar de alta un cliene
    public void saveCliente(Cliente cli);
    //metodo para dar de baja un cliente 
    public void deleteCliente(Long id);
    //metodo para editar un cliente
    public void editCliente(Cliente cli);
}
