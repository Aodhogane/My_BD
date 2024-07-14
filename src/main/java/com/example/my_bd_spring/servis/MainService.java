package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.domain.Visitor;
import com.example.my_bd_spring.domain.Zoo;
import com.example.my_bd_spring.repositories.EventRepository;
import com.example.my_bd_spring.repositories.TicketRepository;
import com.example.my_bd_spring.repositories.VisitorRepository;
import com.example.my_bd_spring.repositories.ZooRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ZooRepository zooRepository;

    @Transactional
    public void createTicket(int visitorId, int zooId, int quantity, int cost, String startDate, String endDate) {
        // Step 1: Check if visitor exists
        if (!visitorRepository.existsById(visitorId)) {
            throw new RuntimeException("Visitor not found");
        }

        // Step 2: Check if event for animal in the given zoo exists within the specified dates
        boolean eventExists = eventRepository.checkEventForAnimal(zooId, startDate, endDate);
        if (!eventExists) {
            throw new RuntimeException("Animal not found within the specified dates");
        }

        // Step 3: Add a ticket purchase record
        Ticket ticket = new Ticket(cost, quantity);
        Visitor visitor = visitorRepository.findById(visitorId).orElseThrow(() -> new RuntimeException("Visitor not found"));
        Zoo zoo = zooRepository.findById(zooId).orElseThrow(() -> new RuntimeException("Zoo not found"));

        ticket.setVisitor(visitor);
        ticket.setZoo(zoo);
        ticketRepository.save(ticket);
    }
}