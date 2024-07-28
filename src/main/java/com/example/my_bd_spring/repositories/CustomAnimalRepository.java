package com.example.my_bd_spring.repositories;

public interface CustomAnimalRepository {
    Integer addNewAnimalAndAssign(String species, Integer classId, Integer zooId, Integer cellId, Integer workerId);
}