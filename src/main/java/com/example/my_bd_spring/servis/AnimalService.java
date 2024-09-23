package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.AddAnimalRequestDTO;
import com.example.my_bd_spring.DTO.AddAnimalResponseDTO;
import com.example.my_bd_spring.contract.AnimalRepositoryContract;
import com.example.my_bd_spring.repositories.WorkersRepository;
import com.example.my_bd_spring.domain.Workers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalService {
    private final AnimalRepositoryContract animalRepository;
    private final WorkersRepository workersRepository;

    @Autowired
    public AnimalService(AnimalRepositoryContract animalRepository, WorkersRepository workersRepository) {
        this.animalRepository = animalRepository;
        this.workersRepository = workersRepository;
    }

    public AddAnimalResponseDTO addNewAnimalAndAssign(AddAnimalRequestDTO request, Integer workerId) {
        Workers worker = workersRepository.findById(workerId);
        if (worker == null) {
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