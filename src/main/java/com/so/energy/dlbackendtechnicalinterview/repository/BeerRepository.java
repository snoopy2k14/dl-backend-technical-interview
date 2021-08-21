package com.so.energy.dlbackendtechnicalinterview.repository;

import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {


    Beer findById(long id);
    List<Beer> findByName(String name);

}
