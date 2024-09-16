package edu.coderhouse.FacturacionSegundaEntregaHourcade.services;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Client;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client postClient (Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getClient(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public void deleteClient(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente #: " + id + "no encontrado"));
        clientRepository.delete(client);
    }
}
