package com.refugee.repository;

        import com.refugee.model.Pet;
        import org.springframework.stereotype.Repository;
        import java.util.ArrayList;
        import java.util.List;
@Repository
public class PetRepository {
    private List<Pet> pets = new ArrayList<Pet>();
    public void addPet(Pet pet){
        pets.add(pet);
    }

    public List<Pet> getPets(){
        return pets;
    }
}
