package com.so.energy.dlbackendtechnicalinterview.service;

import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeerService {

    List<Beer> listBeers();
    Beer findById(long id);
    List<Beer> findByName(String name);
    Beer random();
    void createBeer(Beer beer);
}


