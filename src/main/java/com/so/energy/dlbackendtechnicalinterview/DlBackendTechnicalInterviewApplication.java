package com.so.energy.dlbackendtechnicalinterview;

import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import com.so.energy.dlbackendtechnicalinterview.repository.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DlBackendTechnicalInterviewApplication {

	private static final Logger log = LoggerFactory.getLogger(DlBackendTechnicalInterviewApplication.class);

	public static void main(String[] args) {

		System.out.println("In main");
		SpringApplication.run(DlBackendTechnicalInterviewApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoBeerEnquiry(BeerRepository beerRepository){

		return args -> {
			beerRepository.save(new Beer("Budwiser","Nice Beer"));
			beerRepository.save(new Beer("Haywords","Strong Beer"));
			beerRepository.save(new Beer("Kingfisher","Class Beer"));
			beerRepository.save(new Beer("Peroni","Different Beer"));
			beerRepository.save(new Beer("Fosters","Strange Beer"));

			for(Beer beer: beerRepository.findAll()){
				log.info("The Beer is: " + beer.toString());
			}


		};

	}

}
