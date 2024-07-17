package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Workers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Workers findById(Integer workerId) {
        return entityManager.find(Workers.class, workerId);
    }

    public List<Object[]> findWorkerAnimalDetails() {
        String queryStr = "SELECT w.id as workerId, w.fio as workerFio, w.post as workerPosition, " +
                "a.id as animalId, a.typeAni as animalType " +
                "FROM Workers w " +
                "JOIN w.animals a";
        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        return query.getResultList();
    }
}