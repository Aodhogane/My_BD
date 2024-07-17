package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Visitor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Visitor findById(Long id) {
        return entityManager.find(Visitor.class, id);
    }
}