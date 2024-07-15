package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Clas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasRepository extends JpaRepository<Clas, Integer> {
}