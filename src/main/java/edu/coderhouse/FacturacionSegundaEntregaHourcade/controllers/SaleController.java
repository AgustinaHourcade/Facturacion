package edu.coderhouse.FacturacionSegundaEntregaHourcade.controllers;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Sale;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/search/{id}")
    public Optional<Sale> getSale (@PathVariable Long id){
        return saleService.getSale(id);
    }

    @GetMapping("/search/all")
    public List<Sale> getAllSales (){
        return saleService.getAllSales();
    }

    @PostMapping("/post/{clientId}")
    public Sale postSale(@PathVariable Long clientId, @RequestBody HashMap<Integer, Integer> products) {
        return saleService.postSale(clientId, products);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            saleService.deleteSale(id);
            return ResponseEntity.ok("Venta eliminada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la venta #"+ id);
        }
    }


}
