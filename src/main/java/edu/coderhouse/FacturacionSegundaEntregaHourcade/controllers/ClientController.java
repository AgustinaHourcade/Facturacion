package edu.coderhouse.FacturacionSegundaEntregaHourcade.controllers;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Client;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/add")
    public Client postClient (@RequestBody Client client){
        return clientService.postClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok("Cliente eliminado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al cliente #" +  id);
        }
    }

}
