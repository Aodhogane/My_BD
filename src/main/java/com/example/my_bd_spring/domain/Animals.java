package com.example.my_bd_spring.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Животные")
public class Animals extends BaseEntity {

    private String type_ani;
    private Zoo zoo;
    private Clas clas;
    private Cell cell;
    private Event event;
    private Set<Workers> workers;

    public Animals(String type_ani, Clas clas){
        this.type_ani = type_ani;
        this.clas = clas;
    }

    @Column(name = "Вид животного")
    public String getType_ani() {
        return type_ani;
    }
    public void setType_ani(String type_ani) {
        this.type_ani = type_ani;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Event", referencedColumnName = "id")
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }

    @ManyToMany(mappedBy = "animals")
    public Set<Workers> getWorkers() {
        return workers;
    }
    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }

}
