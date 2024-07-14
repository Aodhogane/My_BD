package com.example.my_bd_spring.domain;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "Ивент")
public class Event extends BaseEntity{

    private Timestamp data_c;
    private Timestamp data_do;
    private Zoo zoo;
    private Animals animals;

    public Event(Timestamp data_c, Timestamp data_do) {
        this.data_c = data_c;
        this.data_do = data_do;
    }

    @Column(name = "Дата с")
    public Timestamp getData_c() {
        return data_c;
    }
    public void setData_c(Timestamp data_c) {
        this.data_c = data_c;
    }

    @Column(name = "Дата до")
    public Timestamp getData_do() {
        return data_do;
    }
    public void setData_do(Timestamp data_do) {
        this.data_do = data_do;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id")
    public Zoo getZoo() {
        return zoo;
    }
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

}
