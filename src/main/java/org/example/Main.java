package org.example;

import Table.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zoo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Zoo zoo = new Zoo(200, 200,);

        //em.persist(zoo);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}