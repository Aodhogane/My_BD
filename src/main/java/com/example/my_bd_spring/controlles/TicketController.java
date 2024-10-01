package com.example.my_bd_spring.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_bd_spring.DTO.TicketPurchaseDTO;
import com.example.my_bd_spring.DTO.TicketResponseDTO;
import com.example.my_bd_spring.servis.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public ResponseEntity<TicketResponseDTO>
    purchaseTicket(@RequestBody TicketPurchaseDTO dto) {
        TicketResponseDTO ticketResponse = ticketService.purchaseTicket(dto, dto.getVisitorId());
        return ResponseEntity.ok(ticketResponse);
    }

    @PostMapping("/purchase/{visitorId}")
    public ResponseEntity<TicketResponseDTO>
    purchaseTicketWithVisitorId(@PathVariable Long visitorId,
                                @RequestBody TicketPurchaseDTO dto) {
        TicketResponseDTO ticketResponse = ticketService.purchaseTicket(dto, visitorId);
        return ResponseEntity.ok(ticketResponse);
    }
}