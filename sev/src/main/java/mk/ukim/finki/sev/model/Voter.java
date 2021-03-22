package mk.ukim.finki.sev.model;

import javax.persistence.*;


@Entity
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long embg;

    private String name;

    private String lastName;

    private String city;

    private String address;

    public Voter() {
    }

    public Voter(String name, String lastName, String city, String address) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
    }

    public Long getEmbg() {
        return embg;
    }

    public void setEmbg(Long embg) {
        this.embg = embg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
