package com.example.my_bd_spring.domain;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Зоопарк")
public class Zoo extends BaseEntity {
    private int animals;
    private int rab;
    private Set<Workers> workers;

    public Zoo(int animals, int rab) {
        this.animals = animals;
        this.rab = rab;
    }
    public Zoo() {}

    @Column(name = "Количество животных")
    public int getAnimals() {
        return animals;
    }
    public void setAnimals(int animals) {
        this.animals = animals;
    }

    @Column(name = "Количество работников")
    public int getRab() {
        return rab;
    }
    public void setRab(int rab) {
        this.rab = rab;
    }

    @OneToMany(mappedBy = "zoo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    public Set<Workers> getWorkers() {
        return workers;
    }
    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }
}