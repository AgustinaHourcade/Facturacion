package edu.coderhouse.FacturacionSegundaEntregaHourcade.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "STREET")
    private String street;
    @Column(name = "NUMBER")
    private int number;
    @Column(name = "CITY")
    private String city;
    @Column(name = "CP")
    private String cp;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "APARTMENT")
    private String apartment;

    @ManyToOne (fetch = FetchType.LAZY)
    private Client client;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && number == address.number && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(cp, address.cp) && Objects.equals(province, address.province) && Objects.equals(apartment, address.apartment) && Objects.equals(client, address.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, number, city, cp, province, apartment, client);
    }

    @Override
    public String toString() {
        return "Address{" +
                id + " - " + street + number + ", " + apartment + ", " + city + ", " + cp + ", " +
                province +
                '}';
    }
}