package edu.coderhouse.FacturacionSegundaEntregaHourcade.controllers;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Address;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/post")
    public Address postAddress (@RequestBody Address address){
        return addressService.postAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        try {
            addressService.deleteAddress(id);
            return ResponseEntity.ok("Dirección eliminada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la dirección");
        }
    }
}
