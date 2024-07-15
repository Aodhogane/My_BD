package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Cell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CellRepository extends JpaRepository<Cell, Integer> {
}