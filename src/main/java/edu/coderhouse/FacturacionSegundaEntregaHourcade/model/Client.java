package edu.coderhouse.FacturacionSegundaEntregaHourcade.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DNI")
    private long dni;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;

   @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sale> sales;

    public Client() {
    }

    public Client(String name, String surname, long dni, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && dni == client.dni && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(phone, client.phone) && Objects.equals(email, client.email) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dni, phone, email, address);
    }

    @Override
    public String toString() {
        return "Client {" +
                id +
                " - " + surname + ", " + name + " - " + dni + " - " + phone + " - " + email +" - " + address +
                "}\n";
    }
}
