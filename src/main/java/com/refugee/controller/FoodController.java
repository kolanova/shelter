package com.refugee.controller;

import com.refugee.controller.request.CreateFoodRequest;
import com.refugee.exception.ServiceNotAvaliable;
import com.refugee.service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;
import java.time.Clock;
import java.time.LocalDateTime;

public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //Create food itself
    @PostMapping("/food")
    public ResponseEntity createFood(@RequestBody @Valid CreateFoodRequest request) {

        //if time is later than 10am, trow an error "503-SERVICE UNAVALIABLE"
        if(LocalDateTime.now(Clock.systemUTC()).isAfter(LocalDateTime.parse("2021-10-15T08:00:00"))) {
            throw new ServiceNotAvaliable("This service is not avaliable at this moment");
        }
        //returns a value from a previous method
        foodService.save(request.getBrand(),request.getDescription());
        return ResponseEntity.created(URI.create("/food/message")).body("Food Brand Message");
    }
}
