package com.example.my_bd_spring.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Клетки")
public class Cell extends BaseEntity {

    private String viewСell;
    private Zoo zoo;
    private Set<Animals> animals;

    public Cell(String viewСell){
        this.viewСell = viewСell;
    }

    public Cell() {}

    @Column(name = "Вид клетки")
    public String getviewСell() {
        return viewСell;
    }
    public void setviewСell(String viewСell) {
        this.viewСell = viewСell;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id")
    public Zoo getZoo() {
        return zoo;
    }
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @OneToMany(mappedBy = "cell", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Animals> getAnimals() {
        return animals;
    }
    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }
}