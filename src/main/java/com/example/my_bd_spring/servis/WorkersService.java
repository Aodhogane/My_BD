package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.repositories.WorkersRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WorkersService {

    private final WorkersRepository workersRepository;

    public WorkersService(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    public List<Map<String, Object>> getWorkerAnimalDetails() {
        List<Object[]> results = workersRepository.findWorkerAnimalDetails();
        return results.stream().map(result -> {
            Map<String, Object> map = new HashMap<>();
            map.put("workerId", result[0]);
            map.put("workerFio", result[1]);
            map.put("workerPosition", result[2]);
            map.put("animalId", result[3]);
            map.put("animalType", result[4]);
            return map;
        }).collect(Collectors.toList());
    }
}