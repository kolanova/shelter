package com.refugee.controller;
import com.refugee.controller.request.CreateShelterRequest;
import com.refugee.model.Shelter;
import com.refugee.service.ShelterService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

public class ShelterController {
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    //Create new shelter
    @PostMapping(value ="/shelter", consumes = "application/json", produces = "application/json")
    public Shelter createShelter(@RequestBody @Valid CreateShelterRequest createShelterRequest)  {
        Shelter newShelter = Shelter
                .builder()
                .name(createShelterRequest.getName())
                .shelterTypes(createShelterRequest.getShelterTypes())
                .location(createShelterRequest.getLocation())
                .build();
        return shelterService.createShelter(newShelter);
    }
    //Create pets within a shelter
    @PostMapping(value ="/shelter/{id}", consumes = "application/json", produces = "application/json")
    public Shelter createShelterWithPets(@RequestBody @Valid List<Long> petIdList, @PathVariable(value = "id") Long shelterId) {
        Shelter getShelter = shelterService.getShelterById(shelterId);
        return shelterService.addPetsToShelter(getShelter, petIdList);
    }

    //Get all shelters
    @GetMapping(value = "/shelter/{name}")
    public Shelter getShelterByName(@PathVariable(value = "name") @Valid String name){
        return shelterService.getShelterByName(name);
    }

    //Get shelters by id
    @GetMapping(value = "/shelter/{id}")
    public Shelter getShelterById(@PathVariable(value = "id") Long shelterId) {
        return shelterService.getShelterById(shelterId);
    }

    //Delete shelter
    @DeleteMapping(path = "shelter/{id}")
    public void deleteShelter(@PathVariable(value = "id") Long shelterId) {
        shelterService.deleteById(shelterId);
    }
}
