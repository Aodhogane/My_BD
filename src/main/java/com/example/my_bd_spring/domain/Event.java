package com.example.my_bd_spring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Ивент")
public class Event extends BaseEntity {
    private String data_c;
    private String data_do;
    private Zoo zoo;
    private Animals animals;

    public Event(String data_c, String data_do) {
        this.data_c = data_c;
        this.data_do = data_do;
    }

    public Event() {}

    @Column(name = "Дата с")
    public String getData_c() {
        return data_c;
    }

    public void setData_c(String data_c) {
        this.data_c = data_c;
    }

    @Column(name = "Дата до")
    public String getData_do() {
        return data_do;
    }

    public void setData_do(String data_do) {
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Animals", referencedColumnName = "id")
    public Animals getAnimals() {
        return animals;
    }

    public void setAnimals(Animals animals) {
        this.animals = animals;
    }

    // Метод валидации внутри класса Event
    public boolean isWithinDateRange(String startDate, String endDate) {
        return this.data_c.compareTo(startDate) >= 0 && this.data_do.compareTo(endDate) <= 0;
    }
}
