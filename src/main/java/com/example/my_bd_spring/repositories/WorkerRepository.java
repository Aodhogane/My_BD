package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Workers, Integer> {
    Optional<Workers> findByPostAndZoo_Id(String post, int zooId);
}

