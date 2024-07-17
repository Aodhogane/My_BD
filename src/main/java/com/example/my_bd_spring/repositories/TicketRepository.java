package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Ticket ticket) {
        if (ticket.getId() == 0) {
            entityManager.persist(ticket);
        } else {
            entityManager.merge(ticket);
        }
    }
}