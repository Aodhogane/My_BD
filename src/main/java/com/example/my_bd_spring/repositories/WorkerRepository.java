package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Workers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Workers findById(Integer id) {
        return entityManager.find(Workers.class, id);
    }
}