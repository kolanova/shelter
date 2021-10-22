package com.refugee.controller.request;
import com.refugee.model.FoodType;
import lombok.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFoodRequest {
    @Size(max = 255, message = "Please make your description shorter")
    private String description;
    private FoodType brand;
}
