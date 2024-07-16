package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Event e WHERE e.zoo.id = :zooId " +
            "AND e.animals.id = :animalId AND e.data_c <= :endDate AND e.data_do >= :startDate")
    boolean checkEventForAnimal(@Param("zooId") int zooId, @Param("animalId") int animalId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query("SELECT e.animals.id FROM Event e WHERE e.zoo.id = :zooId AND e.data_c <= :endDate AND e.data_do >= :startDate")
    Optional<Object[]> findAnimalIdForZooAndDateRange(@Param("zooId") int zooId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}