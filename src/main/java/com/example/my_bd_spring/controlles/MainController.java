package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.servis.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping("/create-ticket")
    public void createTicket(
            @RequestParam("visitorId") int visitorId,
            @RequestParam("zooId") int zooId,
            @RequestParam("quantity") int quantity,
            @RequestParam("cost") int cost,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        mainService.createTicket(visitorId, zooId, quantity, cost, startDate, endDate);
    }
}