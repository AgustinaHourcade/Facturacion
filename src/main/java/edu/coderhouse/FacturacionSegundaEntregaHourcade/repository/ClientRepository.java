package edu.coderhouse.FacturacionSegundaEntregaHourcade.repository;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
