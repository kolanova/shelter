package com.refugee.controller.request;

import com.refugee.model.PetType;
import lombok.*;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePetRequest {
    private PetType petType;
    @NotBlank(message = "Please, give your pet a NAME")
    private String name;
    private Long shelterId;
}
