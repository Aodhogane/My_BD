package com.example.my_bd_spring.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Животные")
public class Animals extends BaseEntity {

    private String typeAni;
    private Zoo zoo;
    private Clas clas;
    private Cell cell;
    private Event event;
    private Set<Workers> workers;

    public Animals(String typeAni, Clas clas){
        this.typeAni = typeAni;
        this.clas = clas;
    }

    public Animals() {}

    @Column(name = "Вид животного")
    public String getTypeAni() {
        return typeAni;
    }
    public void setTypeAni(String typeAni) {
        this.typeAni = typeAni;
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
    @JoinColumn(name = "id_clas", referencedColumnName = "id")
    public Clas getClas() {
        return clas;
    }
    public void setClas(Clas clas) {
        this.clas = clas;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cell", referencedColumnName = "id")
    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @ManyToMany(mappedBy = "animals")
    public Set<Workers> getWorkers() {
        return workers;
    }
    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }
}