package com.mirran.growappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "plant_name")
    private String name;
    private String so;
    private String harvest;

    public Plant() {
    }

    public Plant(long id, String name, String so, String harvest) {
        this.id = id;
        this.name = name;
        this.so = so;
        this.harvest = harvest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String harvest) {
        this.harvest = harvest;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", so='" + so + '\'' +
                ", harvest='" + harvest + '\'' +
                '}';
    }
}

