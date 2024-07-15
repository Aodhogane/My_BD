package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.domain.Workers;
import com.example.my_bd_spring.servis.WorkersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class WorkersController {

    private final WorkersService workersService;

    public WorkersController(WorkersService workersService) {
        this.workersService = workersService;
    }

    @GetMapping("/worker-animal-details")
    public List<Objects> getWorkerAnimalDetails() {
        return workersService.getWorkerAnimalDetails();
    }
}