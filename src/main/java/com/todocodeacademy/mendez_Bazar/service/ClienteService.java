
package com.todocodeacademy.mendez_Bazar.service;

import com.todocodeacademy.mendez_Bazar.model.Cliente;
import com.todocodeacademy.mendez_Bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    //aplicamos inyeccion de dependencias de IClienteRepository con Autowired
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cli) {
        clienteRepo.save(cli);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente cli) {
        this.saveCliente(cli);
    }
}
