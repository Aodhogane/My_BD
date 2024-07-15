package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Integer> {

    @Query("SELECT w FROM Workers w JOIN w.animals a")
    List<Workers> findWorkerAnimalDetails();
}
