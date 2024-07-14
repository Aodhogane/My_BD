package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorRepositories extends JpaRepository<Ticket, Long> {

    @Query("select t from Visitor t where t.age = :age")
    List<Ticket> findAllVisitor(@Param("age") int age);
}
