package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.domain.Clas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasServis {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAllClas(List<Clas> clas) {
        for (Clas clas1 : clas ) {
            entityManager.persist(clas1);
        }
    }
}
