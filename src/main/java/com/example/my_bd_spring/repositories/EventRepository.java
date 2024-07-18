package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Event findById(Long id) {
        return entityManager.find(Event.class, id);
    }

    public List<Event> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Event e", Event.class);
        return query.getResultList();
    }
}