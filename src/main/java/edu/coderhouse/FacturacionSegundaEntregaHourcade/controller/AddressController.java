package edu.coderhouse.FacturacionSegundaEntregaHourcade.controller;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Address;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/search/{id}")
    public Optional<Address> getAddress (@PathVariable Long id){
        return addressService.getAddress(id);
    }

    @GetMapping("/search/all")
    public List<Address> getAllAddress (){
        return addressService.getAllAddress();
    }
    @PostMapping
    public Address postAddress (@RequestBody Address address){
        return addressService.postAddress(address);
    }
}
