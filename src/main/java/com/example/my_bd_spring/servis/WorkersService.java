package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.WorkersResponseDTO;
import com.example.my_bd_spring.domain.Workers;
import com.example.my_bd_spring.repositories.WorkersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkersService {
    private final WorkersRepository workersRepository;

    public WorkersService(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    public WorkersResponseDTO getWorkerById(Integer workerId) {
        Workers worker = workersRepository.findById(workerId);

        // Проверка, если работник не найден, возвращаем пустой объект WorkersResponseDTO
        if (worker == null) {
            return new WorkersResponseDTO();
        }

        // Извлечение и преобразование типов животных, за которыми ухаживает работник, в список строк
        List<String> animalTypes = worker.getAnimals().stream()
                .map(animal -> animal.getTypeAni())
                .collect(Collectors.toList());

        // Возврат объекта WorkersResponseDTO с данными о работнике и типах животных
        return new WorkersResponseDTO(worker.getId(), worker.getFio(), worker.getPost(), animalTypes);
    }
}