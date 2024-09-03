package edu.coderhouse.FacturacionSegundaEntregaHourcade.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "SALEXPRODUCT")
public class SaleXproduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "SALE_ID")
    private Sale sale;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

    public SaleXproduct() {
    }

    public SaleXproduct(Long id, Sale sale, Product product, int quantity) {
        this.id = id;
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleXproduct that = (SaleXproduct) o;
        return id == that.id && quantity == that.quantity && Objects.equals(sale, that.sale) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sale, product, quantity);
    }

    @Override
    public String toString() {
        return "SaleXproduct{" +
                "id=" + id +
                ", sale=" + sale +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
