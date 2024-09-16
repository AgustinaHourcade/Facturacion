package edu.coderhouse.FacturacionSegundaEntregaHourcade.controllers;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Product;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/post")
    public Product postProduct(@RequestBody Product product){
        return productService.postProduct(product);
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<String> updateStock(@PathVariable Long id, @RequestParam int quantityChange) {
        try {
            productService.updateProductStock(id, quantityChange);
            return ResponseEntity.ok("Stock modificado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al producto #" +  id);
        }
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<String> updatePrice(@PathVariable Long id, @RequestParam int priceChange) {
        try {
            productService.updateProductPrice(id, priceChange);
            return ResponseEntity.ok("Precio modificado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al producto #" +  id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Producto eliminado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al producto #" +  id);
        }
    }
}
