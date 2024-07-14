package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Zoo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooServis {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAllZoo(List<Zoo> zoo) {
        for (Zoo zoos : zoo ) {
            entityManager.persist(zoos);
        }
    }
}
