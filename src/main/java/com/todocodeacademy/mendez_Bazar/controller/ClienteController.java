
package com.todocodeacademy.mendez_Bazar.controller;

import com.todocodeacademy.mendez_Bazar.model.Cliente;
import com.todocodeacademy.mendez_Bazar.service.IClienteService;
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
public class ClienteController {
    //aplicamos inyeccion de dependencia de IClienteService con @Autowired
    @Autowired
    private IClienteService cliServis;
    //procedemos a crear los endpoint
    //endpoint para traer un cliente
    @GetMapping("/cliente/traer")
    @ResponseBody
    public Cliente findCliente(@RequestParam Long id){
        return cliServis.findCliente(id);
    }
    //endpoint para traer todos los clientes
    @GetMapping("/clientes/traer")
    @ResponseBody
    public List<Cliente> getClientes(){
        return cliServis.getClientes();
    }
    //endpoint para dar de ala un cliente
    @PostMapping("/cliente/crear")
    public String createCliente(@RequestBody Cliente cli){
        cliServis.saveCliente(cli);
        return "EL cliente ha sido creado correctamente";
    }
    //endpoint para dar de baja un cliente
    @DeleteMapping("/cliente/borrar")
    public String deleteCLiente(@RequestParam Long id){
        cliServis.deleteCliente(id);
        return "El cliente fue eliminado exitosamente";
    }
    //endpoint para editar un cliente
    @PutMapping("/cliente/editar")
    public String editCliente(@RequestBody Cliente cli){
        cliServis.editCliente(cli);
        return "Se edito correctamente";
    }
}
