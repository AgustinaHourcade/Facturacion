package edu.coderhouse.FacturacionSegundaEntregaHourcade.services;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.SaleXproduct;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.SaleXproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleXproductService {
    @Autowired
    private SaleXproductRepository saleXproductRepository;

    public SaleXproduct postSaleXproduct (SaleXproduct saleXproduct){
        return saleXproductRepository.save(saleXproduct);
    }

    public Optional<SaleXproduct> getSaleXproduct(Long id){
        return saleXproductRepository.findById(id);
    }

    public  List<SaleXproduct> getAllSaleXproduct(){
        return saleXproductRepository.findAll();
    }

}
