import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_bd_spring.DTO.WorkersResponseDTO;
import com.example.my_bd_spring.servis.WorkersServiceContract;

@RestController
@RequestMapping("/api")
public class WorkersController {

    private static final Logger logger = LoggerFactory.getLogger(WorkersController.class);

    private final WorkersServiceContract workersService;

    @Autowired
    public WorkersController(WorkersServiceContract workersService) {
        this.workersService = workersService; 
    }

    @GetMapping("/worker/{workerId}")
    public ResponseEntity<?> getWorkerById(@PathVariable Integer workerId) {
        logger.info("Получаем работника с ID: " + workerId); 

        WorkersResponseDTO worker = workersService.getWorkerById(workerId);

        return ResponseEntity.ok(worker);
    }
}