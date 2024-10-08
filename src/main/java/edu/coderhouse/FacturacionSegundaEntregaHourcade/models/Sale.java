package edu.coderhouse.FacturacionSegundaEntregaHourcade.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="SALE")
public class Sale {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TOTAL")
    private double total;
    @Column(name = "DATE")
    private LocalDate date;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "CLIENT_ID")
    @JsonIgnore
    private Client client;


    @OneToMany (mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SaleXproduct> saleXproduct;

    public Sale() {
    }

    public Sale(Long id, double total, LocalDate date, Client client, List<SaleXproduct> saleXproduct) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.client = client;
        this.saleXproduct = saleXproduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SaleXproduct> getSaleXproduct() {
        return saleXproduct;
    }

    public void setSaleXproduct(List<SaleXproduct> saleXproduct) {
        this.saleXproduct = saleXproduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id && Double.compare(total, sale.total) == 0  && Objects.equals(date, sale.date) && Objects.equals(client, sale.client) && Objects.equals(saleXproduct, sale.saleXproduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, date, client, saleXproduct);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", total=" + total +
                ", date=" + date +
                ", client=" + client +
                ", saleXproduct=" + saleXproduct +
                '}';
    }
}
