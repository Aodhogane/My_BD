package com.example.my_bd_spring.Table;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Посетитель")
public class Visitor extends BaseEntity {

    private String FIO;
    private String Age;
    private Set<Ticket> tickets;

    public Visitor(String FIO, String Age){
        this.FIO = FIO;
        this.Age = Age;
    }

    @Column(name = "ФИО")
    public String getFIO() {
        return FIO;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Column(name = "Возраст")
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        this.Age = age;
    }

    @OneToMany(mappedBy = "visitor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

}