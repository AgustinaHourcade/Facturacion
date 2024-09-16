package edu.coderhouse.FacturacionSegundaEntregaHourcade.services;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Product;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Agregar producto
    public Product postProduct (Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void updateProductStock(Long productId, int quantityChange) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        int newStock = product.getStock() + quantityChange;
        if (newStock < 0) {
            throw new RuntimeException("Stock insuficiente para el producto ID: " + productId);
        }

        product.setStock(newStock);
        productRepository.save(product);
    }

    public void updateProductPrice(Long productId, double priceChange) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (priceChange < 0) {
            throw new RuntimeException("El precio no puede ser menor a $0 " + productId);
        }

        product.setPrice(priceChange);
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto #: " + id + "no encontrada"));
        productRepository.delete(product);
    }
}
