package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Integer> {

    @Query(value = "SELECT r.id as workerId, r.\"фио\" as workerFio, r.\"должность\" as workerPosition, " +
            "j.id as animalId, j.\"вид животного\" as animalType " +
            "FROM public.\"работники\" r " +
            "JOIN public.\"уход\" u ON r.id = u.id_workers " +
            "JOIN public.\"животные\" j ON u.id_animals = j.id " +
            "ORDER BY r.id, j.id", nativeQuery = true)
    List<Object[]> findWorkerAnimalDetails();
}