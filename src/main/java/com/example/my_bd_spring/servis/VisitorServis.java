package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Visitor;
import com.example.my_bd_spring.domain.Zoo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServis {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAllVisitor(List<Visitor> visitor) {
        for (Visitor visitors : visitor ) {
            entityManager.persist(visitors);
        }
    }
}
