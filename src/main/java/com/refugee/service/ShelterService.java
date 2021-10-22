package com.refugee.service;

import com.refugee.model.Pet;
import com.refugee.model.Shelter;
import com.refugee.repository.PetRepository;
import com.refugee.repository.ShelterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final PetRepository petRepository;

    public ShelterService(ShelterRepository shelterRepository, PetRepository petRepository) {
        this.shelterRepository = shelterRepository;
        this.petRepository = petRepository;
    }

    public Shelter createShelter(Shelter newShelter){
        return shelterRepository.save(newShelter);
    }

    public Shelter getShelterById(Long aLong){
        return shelterRepository.getById(aLong);
    }

    //Creating list of pets by id on shelter
    public Shelter addPetsToShelter(Shelter getShelter, List<Long> petIdList) {
        List<Pet> petList = new ArrayList<>();
        for( Long id : petIdList){
            petList.add(petRepository.getById(id));
        }
        getShelter.setPetList(petList);
        return shelterRepository.save(getShelter);
    }
    //Looking for a specific Shelter based on a client input trough existing Shelters by their name
    public Shelter getShelterByName(String name) {
        List<Shelter> allShelters = shelterRepository.findAll();
        Shelter shelter;
        for(int id = 0; id < allShelters.size(); id++){
            if(allShelters.get(id).getName() == name)
                return allShelters.get(id);
        }
        return null;
    }

    public void deleteById(Long shelterId) {
        shelterRepository.deleteById(shelterId);
    }
}
