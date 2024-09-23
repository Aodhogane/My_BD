package com.example.my_bd_spring.contract;

public interface AnimalRepositoryContract {
    Integer addNewAnimalAndAssign(String species, Integer classId, Integer zooId, Integer cellId, Integer workerId);

    default Integer addNewAnimalAndAssignWithRestrictions(String species, Integer classId, Integer zooId, 
    Integer cellId, Integer workerId) {
        // реализация метода с ограничениями
        return null; // или любое другое значение типа Integer
    }
}