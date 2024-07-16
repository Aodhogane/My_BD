package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.TicketPurchaseDTO;
import com.example.my_bd_spring.DTO.TicketResponseDTO;
import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.domain.Event;
import com.example.my_bd_spring.domain.Visitor;
import com.example.my_bd_spring.repositories.EventRepository;
import com.example.my_bd_spring.repositories.TicketRepository;
import com.example.my_bd_spring.repositories.VisitorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final VisitorRepository visitorRepository;

    public TicketService(TicketRepository ticketRepository, EventRepository eventRepository, VisitorRepository visitorRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.visitorRepository = visitorRepository;
    }

    public TicketResponseDTO purchaseTicket(TicketPurchaseDTO dto, Long visitorId) {
        LocalDate visitDate = LocalDate.parse(dto.getVisitDate());

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Ивент не найден"));

        if (event.getAnimals().getId() != dto.getAnimalId() ||
                visitDate.isBefore(LocalDate.parse(event.getData_c())) ||
                visitDate.isAfter(LocalDate.parse(event.getData_do()))) {
            throw new RuntimeException("Животное недоступно для посещения в указанную дату");
        }

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Посетитель не найден"));

        Ticket ticket = new Ticket();
        ticket.setVisitor(visitor);
        ticket.setZoo(event.getZoo());
        ticket.setCost(dto.getCost());
        ticket.setCol(dto.getQuantity());

        Ticket savedTicket = ticketRepository.save(ticket);

        return new TicketResponseDTO(visitorId, dto.getAnimalId(), dto.getEventId(), dto.getVisitDate(), dto.getQuantity(), dto.getCost());
    }
}
