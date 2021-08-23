package com.so.energy.dlbackendtechnicalinterview;

import com.google.gson.Gson;
import com.so.energy.dlbackendtechnicalinterview.entity.Beer;
import com.so.energy.dlbackendtechnicalinterview.repository.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class DlBackendTechnicalInterviewApplication {

	private static final Logger log = LoggerFactory.getLogger(DlBackendTechnicalInterviewApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DlBackendTechnicalInterviewApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoBeerEnquiry(BeerRepository beerRepository) throws IOException, URISyntaxException {

		return args -> {

			URL resource = getClass().getClassLoader().getResource("so-energy-beers.json");
			File inputFile;
			if (resource == null) {
				throw new IllegalArgumentException("so-energy-beers.json file not found!");
			} else {
				// failed if files have whitespaces or special characters
				inputFile = new File(resource.toURI());
			}

			String beerInfoJson= new String(Files.readAllBytes(Paths.get(inputFile.toString())));
			Gson gson = new Gson();
			BeerInfo[] beerInfoArray = gson.fromJson(beerInfoJson, BeerInfo[].class);

			for(int i=0;i<beerInfoArray.length;i++){
				beerRepository.save(new Beer(beerInfoArray[i].getBeer_name(),beerInfoArray[i].getBeer_description()));
			}

			for(Beer beer: beerRepository.findAll()){
				log.info("The Beer is: " + beer.toString());
			}

		};

	}

}
