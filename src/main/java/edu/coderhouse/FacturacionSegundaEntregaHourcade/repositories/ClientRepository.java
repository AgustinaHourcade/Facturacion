package edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
