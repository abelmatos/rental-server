package com.mycompany.rental.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Car (
     String name,
     String transmissionType,
     RentalCost rentalCostPerDay,
     boolean isElectric,
     boolean isDiesel,
     boolean isPetrol

){}