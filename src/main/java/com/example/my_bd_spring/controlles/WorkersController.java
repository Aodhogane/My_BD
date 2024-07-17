package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.DTO.WorkersResponseDTO;
import com.example.my_bd_spring.servis.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class WorkersController {

    private static final Logger logger = LoggerFactory.getLogger(WorkersController.class);

    private final WorkersService workersService;

    @Autowired
    public WorkersController(WorkersService workersService) {
        this.workersService = workersService;
    }

    @GetMapping("/worker/{workerId}")
    public ResponseEntity<?> getWorkerById(@PathVariable Integer workerId) {
        WorkersResponseDTO worker = workersService.getWorkerById(workerId);
        return ResponseEntity.ok(worker);
    }
}