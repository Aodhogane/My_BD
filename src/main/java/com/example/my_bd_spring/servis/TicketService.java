package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.domain.Visitor;
import com.example.my_bd_spring.domain.Zoo;
import com.example.my_bd_spring.domain.Event;
import com.example.my_bd_spring.DTO.TicketPurchaseDTO;
import com.example.my_bd_spring.repositories.EventRepository;
import com.example.my_bd_spring.repositories.TicketRepository;
import com.example.my_bd_spring.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket purchaseTicket(TicketPurchaseDTO dto) {
        LocalDate visitDate = LocalDate.parse(dto.getVisitDate());

        Optional<Event> eventOptional = eventRepository.findById(dto.getEventId());
        if (!eventOptional.isPresent()) {
            throw new RuntimeException("Ивент не найден");
        }

        Event event = eventOptional.get();
        if (event.getAnimals().getId() != dto.getAnimalId() ||
                visitDate.isBefore(LocalDate.parse(event.getData_c())) ||
                visitDate.isAfter(LocalDate.parse(event.getData_do()))) {
            throw new RuntimeException("Животное недоступно для посещения в указанную дату");
        }

        Zoo zoo = event.getZoo();

        Visitor visitor = visitorRepository.findById(dto.getVisitorId())
                .orElseThrow(() -> new RuntimeException("Посетитель не найден"));

        Ticket ticket = new Ticket();
        ticket.setVisitor(visitor);
        ticket.setZoo(zoo);
        ticket.setCost(dto.getCost());
        ticket.setCol(dto.getQuantity());

        return ticketRepository.save(ticket);
    }
}
