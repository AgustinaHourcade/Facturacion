package edu.coderhouse.FacturacionSegundaEntregaHourcade.controller;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Sale;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/post")
    public Sale postSale (@RequestBody Sale sale){
        return saleService.postSale(sale);
    }
}
