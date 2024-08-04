package com.example.my_bd_spring.contract;

import com.example.my_bd_spring.domain.Workers;

import java.util.List;

public interface WorkersRepositoryContract {
    Workers findById(Integer workerId);
    List<Object[]> findWorkerAnimalDetails();
}