package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    boolean existsById(Integer id);
}
