package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END FROM Event e JOIN e.animals a WHERE a.zoo.id = :zooId AND e.data_c <= :startDate AND e.data_do >= :endDate")
    boolean checkEventForAnimal(@Param("zooId") Integer zooId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}