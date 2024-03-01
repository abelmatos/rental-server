package com.mycompany.rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.rental.model.RentalFleet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

    @Value("${rental.data.path}")
    private String rootPath;
    private final ObjectMapper objectMapper;
    private RentalFleet rentalFleet;

    public CarRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void reload() {
        rentalFleet = CarLoader.loadCars(rootPath, objectMapper);
    }

    public RentalFleet getAllCars() {
        // try to load data if there is no cars loaded
        if (rentalFleet == null) reload();

        return rentalFleet;
    }
}