//package com.example.my_bd_spring.repositories;
//
//import com.example.my_bd_spring.domain.Cell;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface CellRepository extends JpaRepository<Cell, Integer> {
//    Optional<Cell> findByViewCellAndZoo_Id(String viewCell, int zooId);
//}