package com.example.demo.service;


import com.example.demo.domain.Category;
import com.example.demo.domain.Pet;
import com.example.demo.domain.PetStatus;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PetRepository;
import com.example.demo.repository.TagRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class PetService {

    private final PetRepository petRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    //FIXME

    public HttpStatus add(Pet pet) {
        tagRepository.saveAll(pet.getTags());
        categoryRepository.save(pet.getCategory());
        petRepository.save(pet);
        return HttpStatus.CREATED;
    }

    public List<Pet> findByStatus(PetStatus petStatus) {
        return petRepository.findAllByPetStatus(petStatus);
    }

    public Optional<Pet> findById(Integer id) {
        return petRepository.findById(id);
    }


    public HttpStatus updatePetCategoryAndStatusById(Integer id, Pet newPet) {
        Optional<Pet> pet = (Optional<Pet>) findById(id);
        if (pet.isPresent()) {
            Pet myPet = pet.get();
            myPet.setCategory(newPet.getCategory());
            categoryRepository.save(newPet.getCategory());
            myPet.setPetStatus(newPet.getPetStatus());
            petRepository.save(myPet);
            return HttpStatus.OK;
        } else return HttpStatus.BAD_GATEWAY;
    }

    public HttpStatus deletePet(Integer id) {
        petRepository.deleteById(id);
        return HttpStatus.OK;
    }


}
