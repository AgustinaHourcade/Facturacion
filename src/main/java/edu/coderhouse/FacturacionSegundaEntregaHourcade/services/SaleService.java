package edu.coderhouse.FacturacionSegundaEntregaHourcade.services;

import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Client;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Product;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.Sale;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.models.SaleXproduct;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.ClientRepository;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.ProductRepository;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.SaleRepository;
import edu.coderhouse.FacturacionSegundaEntregaHourcade.repositories.SaleXproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleXproductRepository saleXproductRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    public Sale postSale (Sale sale){
        return saleRepository.save(sale);
    }

    public Sale postSale (Long clientId, HashMap<Integer, Integer> products){
        Client client = clientRepository.findById(clientId)
                .orElseThrow (()-> new RuntimeException("Cliente no encontrado"));

        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setClient(client);
        sale = saleRepository.save(sale);

        double total =0;

        List<SaleXproduct> saleXproductList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : products.entrySet()){
            SaleXproduct saleXproduct = new SaleXproduct();
            saleXproduct.setSale(sale);
            Product p = productRepository.findById((long) entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            double productPrice = p.getPrice() * entry.getValue();
            total=total+productPrice;

            int newStock = p.getStock() - entry.getValue();
            if (newStock < 0) {
                throw new RuntimeException("Stock insuficiente para el producto #" + entry.getKey());
            }
            p.setStock(newStock);

            productRepository.save(p);

            saleXproduct.setProduct(p);
            saleXproduct.setQuantity(entry.getValue());
            saleXproductRepository.save(saleXproduct);

            saleXproductList.add(saleXproduct);
        }

        sale.setTotal(total);
        sale.setSaleXproduct(saleXproductList);
        return saleRepository.save(sale);
    }

    public Optional<Sale> getSale(Long id){
        return saleRepository.findById(id);
    }

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }
    public void deleteSale(Long id){
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta #: " + id + "no encontrada"));
        saleRepository.delete(sale);
    }

}
