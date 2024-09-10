package com.example.my_bd_spring.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.my_bd_spring.contract.WorkersRepositoryContract;
import com.example.my_bd_spring.domain.Workers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public final class WorkersRepository implements WorkersRepositoryContract {

    @PersistenceContext
    private final EntityManager entityManager;

    public WorkersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public final Workers findById(final Integer workerId) {
        return entityManager.find(Workers.class, workerId);
    }

    @Override
    public final List<Object[]> findWorkerAnimalDetails() {
        String query = "SELECT w.fio, a.typeAni FROM Workers w JOIN w.animals a";
        return entityManager.createQuery(query).getResultList();
    }
}