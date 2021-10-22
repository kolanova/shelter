package com.refugee.service;

import com.refugee.model.Food;
import com.refugee.model.FoodType;
import com.refugee.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //Create food by brand
    public void save(FoodType brand, String description) {
        foodRepository.save(Food
                .builder()
                .brand(brand)
                .description(description)
                .build());
    }
}
