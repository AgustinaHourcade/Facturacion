package edu.coderhouse.FacturacionSegundaEntregaHourcade.repository;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
