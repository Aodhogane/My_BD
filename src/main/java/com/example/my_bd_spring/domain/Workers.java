package com.example.my_bd_spring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Работники")
public class Workers extends BaseEntity {

    private String post;
    private String fio;
    private Zoo zoo;
    private Clas clas;
    private Set<Animals> animals;

    public Workers(String post, String fio, Zoo zoo) {
        this.post = post;
        this.fio = fio;
        this.zoo = zoo;
    }

    public Workers() {}

    @Column(name = "Должность")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Column(name = "ФИО")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id")
    @JsonBackReference
    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Clas", referencedColumnName = "id")
    public Clas getClas() {
        return clas;
    }

    public void setClas(Clas clas) {
        this.clas = clas;
    }

    @ManyToMany
    @JoinTable(
            name = "Уход",
            joinColumns = @JoinColumn(name = "id_Workers"),
            inverseJoinColumns = @JoinColumn(name = "id_Animals")
    )
    public Set<Animals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }
}