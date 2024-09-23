package com.example.my_bd_spring.contract;

import com.example.my_bd_spring.domain.Event;

import java.util.List;

public interface EventRepositoryContract {
    Event findById(Long id);
    List<Event> findAll();
}