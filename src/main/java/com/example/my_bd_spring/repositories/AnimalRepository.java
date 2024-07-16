package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animals, Integer> {
    @Query(value = "WITH new_animal AS (" +
            "    INSERT INTO public.животные (id_cell, id_clas, id_zoo, \"вид животного\")" +
            "    VALUES (:cellId, :classId, :zooId, :species)" +
            "    RETURNING id" +
            "), care_record AS (" +
            "    INSERT INTO public.уход (id_animals, id_workers)" +
            "    VALUES ((SELECT id FROM new_animal), :workerId)" +
            ") SELECT id FROM new_animal", nativeQuery = true)
    Integer addNewAnimalAndAssign(
            @Param("species") String species,
            @Param("classId") Integer classId,
            @Param("zooId") Integer zooId,
            @Param("cellId") Integer cellId,
            @Param("workerId") Integer workerId
    );
}