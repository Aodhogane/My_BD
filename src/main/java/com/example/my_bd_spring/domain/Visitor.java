package com.example.my_bd_spring.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Посетитель")
public class Visitor extends BaseEntity {

    private String FIO;
    private int Age;
    private Set<Ticket> tickets;

    public Visitor(String FIO, int Age){
        this.FIO = FIO;
        this.Age = Age;
    }

    public Visitor() {}

    @Column(name = "ФИО")
    public String getFIO() {
        return FIO;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Column(name = "Возраст")
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }

    @OneToMany(mappedBy = "visitor",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

}