package com.mycompany.rental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CarFleet(
        String make,
        String model,
        boolean automaticTransmission,
        String fuelType,
        double weeklyRentalPrice

) {
}