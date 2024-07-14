package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Integer> {

}