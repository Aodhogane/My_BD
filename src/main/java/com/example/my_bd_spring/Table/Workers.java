package com.example.my_bd_spring.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Работники")
public class Workers extends BaseEntity{

    private String Post;
    private String FIO;
    private Zoo zoo;
    private Set<Animals> animals;

    public Workers(String Post, String FIO, Zoo zoo){
        this.Post = Post;
        this.FIO = FIO;
        this.zoo = zoo;
    }

    @Column(name = "Должность")
    public String getPost() {
        return Post;
    }
    public void setPost(String post) {
        Post = post;
    }

    @Column(name = "ФИО")
    public String getFIO() {
        return FIO;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id")
    public Zoo getZoo() {
        return zoo;
    }
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @ManyToMany
    @JoinTable(name = "Уход",
            joinColumns = @JoinColumn(name = "id_Workers"),
            inverseJoinColumns = @JoinColumn(name = "id_Animals"))
    public Set<Animals> getAnimals() {
        return animals;
    }
    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }


}