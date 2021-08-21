package com.so.energy.dlbackendtechnicalinterview.service;

import com.so.energy.dlbackendtechnicalinterview.BeerNotFoundException;
import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import com.so.energy.dlbackendtechnicalinterview.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.util.Optional.*;

@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public List<Beer> listBeers(){
        return (List<Beer>) beerRepository.findAll();
    }

    @Override
    public Beer findById(long id) {
        Optional<Beer> optionalBeer = ofNullable(beerRepository.findById(id));

        if(optionalBeer.isPresent())
            return optionalBeer.get();
        else
            throw new BeerNotFoundException("Beer Not Found");
    }

    @Override
    public List<Beer> findByName(String beerName) {
        return (List<Beer>) beerRepository.findByName(beerName);
    }

    @Override
    public Beer random() {

        Random random = new Random();
        long id = random.nextInt(50);
        Optional<Beer> optionalBeer = ofNullable(beerRepository.findById(id));

        if(optionalBeer.isPresent())
            return optionalBeer.get();
        else
            throw new BeerNotFoundException("Beer Not Found");
    }


    @Override
    public void createBeer(Beer beer) {
        beerRepository.save(beer);
    }


}
