package edu.coderhouse.FacturacionSegundaEntregaHourcade.controller;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Client;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/search/{id}")
    public Optional<Client> getClient (@PathVariable Long id){
        return clientService.getClient(id);
    }

    @GetMapping("/search/all")
    public List<Client> getAllClients (){
        return clientService.getAllClients();
    }
    @PostMapping
    public Client postClient (@RequestBody Client client){
        return clientService.postClient(client);
    }

}
