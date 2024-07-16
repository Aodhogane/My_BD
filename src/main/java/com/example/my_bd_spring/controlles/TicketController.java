package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.DTO.TicketPurchaseDTO;
import com.example.my_bd_spring.DTO.TicketResponseDTO;
import com.example.my_bd_spring.servis.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public ResponseEntity<TicketResponseDTO> purchaseTicket(@RequestBody TicketPurchaseDTO dto) {
        TicketResponseDTO ticketResponse;
        try {
            ticketResponse = ticketService.purchaseTicket(dto, dto.getVisitorId());
            return ResponseEntity.ok(ticketResponse);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/purchase/{visitorId}")
    public ResponseEntity<TicketResponseDTO> purchaseTicketWithVisitorId(@PathVariable Long visitorId, @RequestBody TicketPurchaseDTO dto) {
        try {
            TicketResponseDTO ticketResponse = ticketService.purchaseTicket(dto, visitorId);
            return ResponseEntity.ok(ticketResponse);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}