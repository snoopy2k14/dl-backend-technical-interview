package com.so.energy.dlbackendtechnicalinterview.entity;

import javax.persistence.*;

@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="beer_identifier")
    private Long id;

    @Column(name="beer_name",nullable = false)
    private String name;
    
    @Column(length=2000)
    private String beer_description;

    public Beer(){

    }

    public Beer(String name, String beer_description) {
        this.name = name;
        this.beer_description = beer_description;
    }

    public Long getBeer_identifier() {
        return id;
    }

    public void setBeer_identifier(Long id) {
        this.id = id;
    }

    public String getBeer_name() {
        return name;
    }

    public void setBeer_name(String name) {
        this.name = name;
    }

    public String getBeer_description() {
        return beer_description;
    }

    public void setBeer_description(String beer_description) {
        this.beer_description = beer_description;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beer_description='" + beer_description + '\'' +
                '}';
    }
}
