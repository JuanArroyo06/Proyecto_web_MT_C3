package com.misiontic.USA.Ortesis.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="category")
public class Category implements Serializable {
    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    //Llaves


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Ortopedic> ortopedics;


    //Getter and Setter


    public List<Ortopedic> getOrtopedics() {
        return ortopedics;
    }

    public void setOrtopedics(List<Ortopedic> ortopedics) {
        this.ortopedics = ortopedics;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

