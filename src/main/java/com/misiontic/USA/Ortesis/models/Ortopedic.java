package com.misiontic.USA.Ortesis.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ortopedic")
public class Ortopedic implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @Column(name = "Years")
    private Integer year;
    private String description;

    //Llaves


    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("ortopedic")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="ortopedic")
    @JsonIgnoreProperties({"ortopedic","client"})
    private List<Message> message;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="ortopedic")
    @JsonIgnoreProperties({"ortopedic","message"})
    public List<Reservation> reservation;


    //Getter and Setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}
