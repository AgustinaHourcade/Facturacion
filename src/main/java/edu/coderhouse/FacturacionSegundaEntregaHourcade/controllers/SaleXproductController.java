package edu.coderhouse.FacturacionSegundaEntregaHourcade.controllers;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.SaleXproduct;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.services.SaleXproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salesXproduct")
public class SaleXproductController {
    @Autowired
    private SaleXproductService saleXproductService;

    @GetMapping("/search/{id}")
    public Optional<SaleXproduct> getSaleXproduct(@PathVariable Long id) {
        return saleXproductService.getSaleXproduct(id);
    }

    @GetMapping("/search/all")
    public List<SaleXproduct> getAllSaleXproduct (){
        return saleXproductService.getAllSaleXproduct();
    }

    @PostMapping("/post")
    public SaleXproduct postSaleXproduct (@RequestBody SaleXproduct saleXproduct){
        return saleXproductService.postSaleXproduct(saleXproduct);
    }
}

