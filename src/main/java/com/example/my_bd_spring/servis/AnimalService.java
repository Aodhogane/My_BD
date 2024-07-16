package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.AddAnimalRequestDTO;
import com.example.my_bd_spring.DTO.AddAnimalResponseDTO;
import com.example.my_bd_spring.repositories.AnimalRepository;
import com.example.my_bd_spring.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final WorkerRepository workerRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, WorkerRepository workerRepository) {
        this.animalRepository = animalRepository;
        this.workerRepository = workerRepository;
    }

    public AddAnimalResponseDTO addNewAnimalAndAssign(AddAnimalRequestDTO request, Integer workerId) {
        if (!workerRepository.existsById(workerId)) {
            throw new RuntimeException("Работник с ID " + workerId + " не найден");
        }

        Integer newAnimalId = animalRepository.addNewAnimalAndAssign(
                request.getSpecies(),
                request.getClassId(),
                request.getZooId(),
                request.getCellId(),
                workerId
        );

        return new AddAnimalResponseDTO(newAnimalId, request.getCellId(), workerId);
    }
}