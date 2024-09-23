package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.contract.AnimalRepositoryContract;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

@Repository
public class AnimalRepository implements AnimalRepositoryContract {

    @PersistenceContext
    private EntityManager entityManager;

    private final DataSource dataSource;

    public AnimalRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Transactional
    public Integer addNewAnimalAndAssign(String species, Integer classId, Integer zooId, Integer cellId, Integer workerId) {
        Integer newAnimalId = null;
        String insertAnimalQuery = "INSERT INTO public.животные (id_cell, id_clas, id_zoo, \"вид животного\") VALUES (?, ?, ?, ?) RETURNING id";
        String assignWorkerQuery = "INSERT INTO public.уход (id_animals, id_workers) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement pst = connection.prepareStatement(insertAnimalQuery)) {
                pst.setInt(1, cellId);
                pst.setInt(2, classId);
                pst.setInt(3, zooId);
                pst.setString(4, species);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    newAnimalId = rs.getInt(1);
                }
            }

            if (newAnimalId != null) {
                try (PreparedStatement pst = connection.prepareStatement(assignWorkerQuery)) {
                    pst.setInt(1, newAnimalId);
                    pst.setInt(2, workerId);
                    pst.executeUpdate();
                }
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection connection = dataSource.getConnection()) {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }

        return newAnimalId;
    }
}