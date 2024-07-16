package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.AddAnimalRequestDTO;
import com.example.my_bd_spring.DTO.AddAnimalResponseDTO;
import com.example.my_bd_spring.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public AddAnimalResponseDTO addNewAnimalAndAssign(AddAnimalRequestDTO request) {
        Integer newAnimalId = animalRepository.addNewAnimalAndAssign(
                request.getSpecies(),
                request.getClassId(),
                request.getZooId(),
                request.getCellId(),
                request.getWorkerId()
        );

        return new AddAnimalResponseDTO(newAnimalId, request.getCellId(), request.getWorkerId());
    }
}