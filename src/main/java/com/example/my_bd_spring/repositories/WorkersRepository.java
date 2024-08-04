package com.example.my_bd_spring.repositories;


import com.example.my_bd_spring.contract.WorkersRepositoryContract;
import com.example.my_bd_spring.domain.Workers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkersRepository implements WorkersRepositoryContract {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Workers findById(Integer workerId) {
        return entityManager.find(Workers.class, workerId);
    }

    @Override
    public List<Object[]> findWorkerAnimalDetails() {
        String queryStr = "SELECT w.id as workerId, w.fio as workerFio, w.post as workerPosition, " +
                "a.id as animalId, a.typeAni as animalType " +
                "FROM Workers w " +
                "JOIN w.animals a";
        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        return query.getResultList();
    }
}