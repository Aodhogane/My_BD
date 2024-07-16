package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.DTO.TicketPurchaseDTO;
import com.example.my_bd_spring.servis.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody TicketPurchaseDTO dto) {
        Ticket ticket = ticketService.purchaseTicket(dto);
        return ResponseEntity.ok(ticket);
    }
}