package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Workers;
import com.example.my_bd_spring.repositories.WorkersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkersService {

    private final WorkersRepository workersRepository;

    public WorkersService(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    public List<Workers> getWorkerAnimalDetails() {
        return workersRepository.findWorkerAnimalDetails();
    }
}