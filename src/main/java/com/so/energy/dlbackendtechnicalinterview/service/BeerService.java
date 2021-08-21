package com.so.energy.dlbackendtechnicalinterview.service;

import com.so.energy.dlbackendtechnicalinterview.entity.Beer;

import java.util.List;

public interface BeerService {

    List<Beer> listBeers();
    Beer findById(long id);
    List<Beer> findByName(String beerName);
    Beer random();
    void createBeer(Beer beer);
}


