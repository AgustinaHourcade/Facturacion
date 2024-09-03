package edu.coderhouse.FacturacionSegundaEntregaHourcade.controller;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Product;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search/{id}")
    public Optional<Product> getProduct (@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/search/all")
    public List<Product> getAllProduct (){
        return productService.getAllProducts();
    }
    @PostMapping
    public Product postClient (@RequestBody Product product){
        return productService.postProduct(product);
    }
}
