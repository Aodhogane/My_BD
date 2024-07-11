package com.example.my_bd_spring.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Клетки")
public class Cell {

    private int id_cell;
    private String view_cell;
    private Zoo zoo;
    private Set<Animals> animals;

    public Cell(String view_cell){
        this.view_cell = view_cell;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_cell() {
        return id_cell;
    }

    public void setId_cell(int id_cell) {
        this.id_cell = id_cell;
    }

    @Column(name = "Вид клетки")
    public String getView_cell() {
        return view_cell;
    }

    public void setView_cell(String view_cell) {
        this.view_cell = view_cell;
    }


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id_Zoo")
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





