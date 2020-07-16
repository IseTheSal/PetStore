package com.example.demo.controller;


import com.example.demo.domain.Pet;
import com.example.demo.domain.PetStatus;
import com.example.demo.service.PetService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping(path = "/pet")
public class PetController {

    private final PetService petService;

    @PostMapping(path = "/add")
    public ResponseEntity<Pet> add(@RequestBody Pet pet) {
        return new ResponseEntity<>(petService.add(pet));
    }

    @GetMapping(path = "/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(@RequestParam PetStatus status) {
        return new ResponseEntity<>(petService.findByStatus(status), HttpStatus.OK);
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<Optional<Pet>> findById(@RequestParam Integer id){
        return new ResponseEntity<>(petService.findById(id),HttpStatus.OK);
    }


    @PostMapping(path = "/updatePetCategoryAndStatusById")
    public ResponseEntity<Pet> updatePetCategoryAndStatusById(@RequestParam Integer id, @RequestBody Pet pet){
        return new ResponseEntity<>(petService.updatePetCategoryAndStatusById(id, pet));
    }

    @DeleteMapping(path = "/deletePetById")
    public ResponseEntity<Pet> deletePetById(@RequestParam Integer id){
        return new ResponseEntity<>(petService.deletePet(id));
    }


}
