package com.example.my_bd_spring.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Класс")
public class Clas extends BaseEntity {

    public Clas() {}

    private String view_ani;
    private Set<Animals> animals;
    public Clas(String view_ani) {
        this.view_ani = view_ani;
    }

    @Column(name = "Вид животного")
    public String getView_ani() {
        return view_ani;
    }
    public void setView_ani(String view_ani) {
        this.view_ani = view_ani;
    }

    @OneToMany(mappedBy = "clas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Animals> getAnimals() {
        return animals;
    }
    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }

}