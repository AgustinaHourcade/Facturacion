package edu.coderhouse.FacturacionSegundaEntregaHourcade.services;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Address;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Sale;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.AddressRepository;
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

    public void deleteAddress(Long id){
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dirección #: " + id + "no encontrada"));
        addressRepository.delete(address);
    }
}
