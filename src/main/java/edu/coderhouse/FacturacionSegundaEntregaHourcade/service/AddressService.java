package edu.coderhouse.FacturacionSegundaEntregaHourcade.service;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Address;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Client;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repository.AddressRepository;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address postAddress (Address address){
        return addressRepository.save(address);
    }

    public Optional<Address> getAddress(Long id){
        return addressRepository.findById(id);
    }

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
}
