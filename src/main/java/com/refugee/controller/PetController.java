package com.refugee.controller;

import com.refugee.services.PetService;
import com.refugee.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getPets(){

        Pet pet = new Pet("name", "type");

        List<Pet> pets = petService.listPets();
        return ResponseEntity
                .ok().body(pets);
    }

}
