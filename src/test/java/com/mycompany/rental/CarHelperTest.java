package com.mycompany.rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class CarHelperTest {

    @Test
    void load() {
        // TODO create resources folder on test and add a test file there and find the root path to send to the function
        CarLoader.loadCars("C:/Users/abel matos/IdeaProjects/rental-server/data",new ObjectMapper());
    }
}