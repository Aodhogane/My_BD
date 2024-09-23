package com.example.my_bd_spring.contract;

import com.example.my_bd_spring.domain.Visitor;

public interface VisitorRepositoryContract {
    Visitor findById(Long id);
}