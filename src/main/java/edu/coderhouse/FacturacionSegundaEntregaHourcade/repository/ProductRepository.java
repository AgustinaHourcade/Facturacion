package edu.coderhouse.FacturacionSegundaEntregaHourcade.repository;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
