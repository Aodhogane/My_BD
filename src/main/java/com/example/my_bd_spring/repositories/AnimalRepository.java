package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AnimalRepository {
    private final String url = "jdbc:postgresql://localhost:5433/Zoo2.1";
    private final String user = "postgres";
    private final String password = "21qw03qw";

    public Integer addNewAnimalAndAssign(String species, Integer classId, Integer zooId, Integer cellId, Integer workerId) {
        Integer newAnimalId = null;
        String insertAnimalQuery = "INSERT INTO public.животные (id_cell, id_clas, id_zoo, \"вид животного\") VALUES (?, ?, ?, ?) RETURNING id";
        String assignWorkerQuery = "INSERT INTO public.уход (id_animals, id_workers) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

            try (PreparedStatement pst = connection.prepareStatement(assignWorkerQuery)) {
                pst.setInt(1, newAnimalId);
                pst.setInt(2, workerId);
                pst.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newAnimalId;
    }
}