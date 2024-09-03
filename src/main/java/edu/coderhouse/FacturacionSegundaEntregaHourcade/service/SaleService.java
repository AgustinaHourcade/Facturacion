package edu.coderhouse.FacturacionSegundaEntregaHourcade.service;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.model.Sale;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Sale postSale (Sale sale){
        return saleRepository.save(sale);
    }

    public Optional<Sale> getSale(Long id){
        return saleRepository.findById(id);
    }

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

}
