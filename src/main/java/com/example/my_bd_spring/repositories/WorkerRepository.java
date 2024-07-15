package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Workers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkerRepository extends JpaRepository<Workers, Integer> {

}

