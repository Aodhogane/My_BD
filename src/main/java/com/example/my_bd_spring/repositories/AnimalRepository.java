package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animals, Integer> {

}