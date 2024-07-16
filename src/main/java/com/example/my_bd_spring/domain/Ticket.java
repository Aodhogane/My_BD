package com.example.my_bd_spring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Билеты")
public class Ticket extends BaseEntity {
    private int Cost;
    private int Col;
    private Zoo zoo;
    private Visitor visitor;

    public Ticket() {
    }

    @Column (name = "Стоимость")
    public int getCost() {
        return Cost;
    }
    public void setCost(int cost) {
        Cost = cost;
    }

    @Column (name = "Количество")
    public int getCol() {
        return Col;
    }
    public void setCol(int col) {
        Col = col;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Visitor", referencedColumnName = "id")
    public Visitor getVisitor() {
        return visitor;
    }
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id")
    public Zoo getZoo() {
        return zoo;
    }
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
