package com.mycompany.rental;

import com.mycompany.rental.model.RentalFleet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car/v1/")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping("/")
    public RentalFleet getRentalFleet() {
        return repository.getAllCars();
    }

    @GetMapping("/reload")
    public RentalFleet reloadRentalFleet() {
        repository.reload();
        return repository.getAllCars();
    }

}