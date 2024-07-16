package com.example.my_bd_spring.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Класс")
public class Clas extends BaseEntity {
    private String viewAni;
    private Set<Animals> animals;

    public Clas(int animalClassId) {}

    public Clas(String viewAni) {
        this.viewAni = viewAni;
    }

    @Column(name = "Вид животного")
    public String getviewAni() {
        return viewAni;
    }
    public void setviewAni(String viewAni) {
        this.viewAni = viewAni;
    }

    @OneToMany(mappedBy = "clas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Animals> getAnimals() {
        return animals;
    }
    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }

}