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
        try {
            logger.info("Получен запрос на идентификатор работника: {}", workerId);
            WorkersResponseDTO worker = workersService.getWorkerById(workerId);
            logger.info("Рабочий найден: {}", worker);
            return ResponseEntity.ok(worker);
        } catch (RuntimeException ex) {
            logger.error("Ошибка ", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ошибка: " + ex.getMessage());
        }
    }
}