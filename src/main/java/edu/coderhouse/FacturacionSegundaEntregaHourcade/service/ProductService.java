package edu.coderhouse.FacturacionSegundaEntregaHourcade.service;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Product;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct (Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
