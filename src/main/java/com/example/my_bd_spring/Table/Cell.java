package com.example.my_bd_spring.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Клетки")
public class Cell extends BaseEntity {

    private String view_cell;
    private Zoo zoo;
    private Set<Animals> animals;

    public Cell(String view_cell){
        this.view_cell = view_cell;
    }

    @Column(name = "Вид клетки")
    public String getView_cell() {
        return view_cell;
    }
    public void setView_cell(String view_cell) {
        this.view_cell = view_cell;
    }


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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





