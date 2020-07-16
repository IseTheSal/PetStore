package com.example.demo.repository;

import com.example.demo.domain.Pet;
import com.example.demo.domain.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findAllByPetStatus(PetStatus petStatus);

}
