package com.example.my_bd_spring.domain;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
