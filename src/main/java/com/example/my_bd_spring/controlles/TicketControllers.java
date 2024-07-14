package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.servis.TicketServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketControllers {

    private final TicketServes ticketServes;

    @Autowired
    public TicketControllers(TicketServes ticketServes) {
        this.ticketServes = ticketServes;
    }

    @GetMapping("/price/{col}")
    public List<Ticket> getAllTicket(@PathVariable("col") int price) {
       return ticketServes.getAllTicket(price);
   }
}
