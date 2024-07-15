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

        // Проверьте, существует ли посетитель
        if (!visitorRepository.existsById(visitorId)) {
            throw new RuntimeException("Посетитель не найден");
        }

        // Проверьте, существует ли событие для животного в данном зоопарке в указанные даты
        boolean eventExists = eventRepository.checkEventForAnimal(zooId, startDate, endDate);
        if (!eventExists) {
            throw new RuntimeException("Животное не найдено в указанные сроки");
        }

        // Добавьте запись о покупке билета
        Ticket ticket = new Ticket(cost, quantity);
        Visitor visitor = visitorRepository.findById(visitorId).orElseThrow(() -> new RuntimeException("Посетитель не найден"));
        Zoo zoo = zooRepository.findById(zooId).orElseThrow(() -> new RuntimeException("Зоопарк не найден"));

        ticket.setVisitor(visitor);
        ticket.setZoo(zoo);
        ticketRepository.save(ticket);
    }
}