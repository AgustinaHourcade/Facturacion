package edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
