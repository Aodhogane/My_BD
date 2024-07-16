package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.DTO.AddAnimalRequestDTO;
import com.example.my_bd_spring.DTO.AddAnimalResponseDTO;
import com.example.my_bd_spring.servis.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping("/add-animals")
    public ResponseEntity<AddAnimalResponseDTO> addAnimalAndAssign(@RequestBody AddAnimalRequestDTO request) {
        AddAnimalResponseDTO response = animalService.addNewAnimalAndAssign(request);
        return ResponseEntity.ok(response);
    }
}