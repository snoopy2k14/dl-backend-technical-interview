package com.so.energy.dlbackendtechnicalinterview.repository;

import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {

    Beer findById(long id);
    List<Beer> findByName(String name);

}
