package com.example.my_bd_spring.contract;

import java.util.List;

import com.example.my_bd_spring.domain.Event;

public interface EventRepositoryContract {
    Event findById(Long id);
    List<Event> findAll();

    // Метод для проверки события по диапазону дат
    default boolean validateEventByDate(Long id, String startDate, String endDate) {
        Event event = findById(id);
        return event != null && event.isWithinDateRange(startDate, endDate);
    }
}
