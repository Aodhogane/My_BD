package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.repositories.TicketRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServes {

    @PersistenceContext
    private EntityManager entityManager;
    private final TicketRepositories ticketRepositories;

    @Autowired
    public TicketServes(TicketRepositories ticketRepositories){
        this.ticketRepositories = ticketRepositories;
    }

    public List<Ticket> getAllTicket(int col) {
        return ticketRepositories.findAllTicket(col);
    }

    @Transactional
    public void saveAllTicket(List<Ticket> ticket) {
        for (Ticket tickets : ticket) {
            entityManager.persist(tickets);
        }
    }
}
