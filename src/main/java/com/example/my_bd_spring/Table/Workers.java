package com.example.my_bd_spring.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Работники")
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Workers;

    @Column(name = "Должность")
    private String Post;

    @Column(name = "ФИО")
    private String FIO;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id_Zoo")
    private Zoo zoo;

    @ManyToMany
    @JoinTable(name = "Уход",
            joinColumns = @JoinColumn(name = "id_Workers"),
            inverseJoinColumns = @JoinColumn(name = "id_Animals"))
    private Set<Animals> animals;


    public Workers(String Post, String FIO, Zoo zoo){
        this.Post = Post;
        this.FIO = FIO;
        this.zoo = zoo;
    }

    public int getId_Workers() {
        return id_Workers;
    }

    public void setId_Workers(int id_Workers) {
        this.id_Workers = id_Workers;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Set<Animals> animals() {
        return animals;
    }
    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }
}