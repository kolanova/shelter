package com.refugee.services;

import com.refugee.model.Pet;
import com.refugee.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
 private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }


    public List<Pet> listPets() {
       return repository.getPets();
    }

}
