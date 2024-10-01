package com.example.my_bd_spring.contract;

import java.util.List;

import com.example.my_bd_spring.domain.Workers;

public interface WorkersRepositoryContract {
    Workers findById(Integer workerId);  // Находит работника по ID
    List<Object[]> findWorkerAnimalDetails();  // Извлекает детали по типам животных, за которыми наблюдает работник

    default Workers getWorkerById(Integer workerId) {
        // Ограничение: workerId не должен быть null или меньше 1
        if (workerId == null || workerId <= 0) {
            return null; // Или выбросьте исключение, если необходимо
        }
        return findById(workerId);
    }
}
