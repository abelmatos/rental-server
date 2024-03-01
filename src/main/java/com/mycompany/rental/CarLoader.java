package com.mycompany.rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.rental.model.Car;
import com.mycompany.rental.model.CarFleet;
import com.mycompany.rental.model.RentalFleet;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarLoader {
    public static RentalFleet loadCars(String rootPath, ObjectMapper objectMapper) {
        List<Car> cars = new ArrayList<>();
        List<CarFleet> fleet = new ArrayList<>();

        try {
            List<Path> paths = Files.walk(Paths.get(rootPath), 1) //by mentioning max depth as 1 it will only traverse immediate level
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".json")) // fetch only the files which are ending with .JSON
                    .toList();

            // iterate all the paths
            // fetch data from corresponding file
            for (Path path : paths) {
                RentalFleet loadedCars = objectMapper.readValue(Files.newBufferedReader(path), RentalFleet.class);

                if (loadedCars.cars() == null) {
                    fleet.addAll(loadedCars.fleet());

                } else {
                    cars.addAll(loadedCars.cars());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RentalFleet(fleet, cars);
    }
}
