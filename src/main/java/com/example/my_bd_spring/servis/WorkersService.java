package com.example.my_bd_spring.servis;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.my_bd_spring.DTO.WorkersResponseDTO;
import com.example.my_bd_spring.contract.WorkersRepositoryContract;
import com.example.my_bd_spring.domain.Workers;

@Service
public final class WorkersService implements WorkersServiceContract { 

    private final WorkersRepositoryContract workersRepository; 

    public WorkersService(final WorkersRepositoryContract workersRepository) {
        this.workersRepository = workersRepository;
    }

    public final WorkersResponseDTO getWorkerById(final Integer workerId) {
        final Workers worker = workersRepository.getWorkerById(workerId); // Используем метод с ограничением

        if (worker == null) {
            return new WorkersResponseDTO(); // Вернёт пустой DTO, если работник не найден
        }

        final List<String> animalTypes = worker.getAnimals().stream()
                .map(animal -> animal.getTypeAni())
                .collect(Collectors.toList());

        return new WorkersResponseDTO(worker.getId(), worker.getFio(), worker.getPost(), animalTypes);
    }
}
