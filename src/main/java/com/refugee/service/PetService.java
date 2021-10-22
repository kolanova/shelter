package com.refugee.service;

import com.refugee.controller.request.CreatePetFeedRequest;
import com.refugee.controller.request.CreatePetRequest;
import com.refugee.exception.PetNotFound;
import com.refugee.model.Pet;
import com.refugee.model.Shelter;
import com.refugee.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final ShelterService shelterService;

    public PetService(PetRepository petRepository, ShelterService shelterService) {
        this.petRepository = petRepository;
        this.shelterService = shelterService;
    }

    //Find all pets
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    //Saving Pets from list by ID in Shelter
    public List<Pet> save(List<CreatePetRequest> createPetRequestList) {
        List<Pet> newPetList = new ArrayList<>();
        Pet newPet;
        Shelter shelter;
        for (CreatePetRequest createPetRequest : createPetRequestList) {
            shelter = shelterService.getShelterById(createPetRequest.getShelterId());
            newPet = Pet.builder().petType(createPetRequest.getPetType()).name(createPetRequest.getName()).shelter(shelter).build();
            petRepository.save(newPet);
            newPetList.add(newPet);
        }
        return newPetList;
    }

    //Finding pets by id, if it not exists give a specific message to user
    public Pet findById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFound("This pet doesn't exist"));
    }

    //Add request to feed a pet
    public Pet addNewPetFeed(CreatePetFeedRequest createPetFeedRequest) {
        return null;
    }

    //Verify if pet exists if not, trow an exception and give 503 not found to user
    public boolean checkIfPetIsOnShelter(Pet pet) {
        if (pet.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pet not found");
        }
        return this.petRepository.existsById(pet.getId());
    }
}
