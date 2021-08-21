package com.so.energy.dlbackendtechnicalinterview.controller;

import com.so.energy.dlbackendtechnicalinterview.BeerNotFoundException;
import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import com.so.energy.dlbackendtechnicalinterview.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/beerapi/v1")
public class BeerController {

    @Autowired
    BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping(value="/createbeer",produces = "application/json")
    public String createBeer(@RequestBody final Beer beer){
        beerService.createBeer(beer);
        return "Beer added successfully";
    }

    @GetMapping("/beers")
    public ResponseEntity<List<Beer>> getBeers(){
        List<Beer> beerList = beerService.listBeers();
        return new ResponseEntity<List<Beer>>(beerList, HttpStatus.OK);
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable("id") long id){
        try{
            return new ResponseEntity<Beer>(beerService.findById(id),HttpStatus.OK);
        }catch (BeerNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Beer Not Found");
        }
    }

    @GetMapping("/beers/{name}")
    public ResponseEntity<List<Beer>> getBeerByName(@PathVariable("name") String name){
        try{
            List<Beer> beerList = beerService.findByName(name);
            return new ResponseEntity<List<Beer>>(beerList,HttpStatus.OK);
        }catch (BeerNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Beer Not Found");
        }
    }

    @GetMapping("/beer/random")
    public ResponseEntity<Beer> getRandomBeer(){
        try{
            return new ResponseEntity<Beer>(beerService.random(),HttpStatus.OK);
        }catch (BeerNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Beer Not Found");
        }
    }



}
