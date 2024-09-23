package com.example.my_bd_spring.contract;

import java.util.List;

import com.example.my_bd_spring.domain.Workers;

public interface WorkersRepositoryContract {
    Workers findById(Integer workerId);  // Находит работника по ID
    List<Object[]> findWorkerAnimalDetails();  // Извлекает детали по типам животных, за которыми наблюдает работник
}