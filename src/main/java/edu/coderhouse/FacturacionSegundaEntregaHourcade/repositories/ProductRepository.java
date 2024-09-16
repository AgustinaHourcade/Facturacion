package edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
