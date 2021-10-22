package com.refugee.controller;

import com.refugee.controller.request.CreatePetFeedRequest;
import com.refugee.controller.request.CreatePetRequest;
import com.refugee.controller.request.CreateShelterRequest;
import com.refugee.model.Pet;
import com.refugee.model.Shelter;
import com.refugee.service.PetService;
import com.refugee.service.ShelterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AdoptionController {

    private final PetService petService;
    public AdoptionController(PetService petService) {
        this.petService = petService;
    }

    //Get all pets
    @GetMapping(value = "/pet")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    //Get all pets by id
    @GetMapping(value = "/pet/{id}")
    public Pet getPet(@PathVariable(value = "id") Long petId) {
        return petService.findById(petId);
    }

    //Create new pet
    @PostMapping(value = "/pet", consumes = "application/json")
    public List<Pet> addPet(@RequestBody @Valid List<CreatePetRequest> createPetRequests) {
        return petService.save(createPetRequests);
    }

    //Update pet
    @PostMapping(value = "/pet/feed", consumes = "application/json")
    public Pet addPetFeed(@RequestBody @Valid CreatePetFeedRequest petFeedRequest) {
        return petService.addNewPetFeed(petFeedRequest);
    }
}