package com.example.breedex;

import com.example.breedex.model.Breed;
import com.example.breedex.repository.BreedRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BreedExApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreedExApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BreedRepository breedRepository) {

        return args -> {
            InputStream inputStream = BreedExApplication.class.getResourceAsStream("/json/dogs.json");
            Map<String, List<String>> data = new ObjectMapper().readValue(inputStream, new TypeReference<Map<String, List<String>>>() {
            });

            List<Breed> breeds = new ArrayList<>();
            Long count = 1L;
            for (String key : data.keySet()) {
                List<String> value = data.get(key);
                Breed breed = new Breed(count, key, value);
                count++;
                breeds.add(breed);
                breedRepository.save(breed);
            }
            System.out.println("Upload JSON file successful");
        };
    }
}