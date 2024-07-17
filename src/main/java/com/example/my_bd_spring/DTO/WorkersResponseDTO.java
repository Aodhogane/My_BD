package com.example.my_bd_spring.DTO;

import java.util.List;

public class WorkersResponseDTO {
    private Integer id;
    private String fio;
    private String post;
    private List<String> animalTypes; // Список типов животных за которыми закреплен работник

    public WorkersResponseDTO() {
    }

    public WorkersResponseDTO(Integer id, String fio, String post, List<String> animalTypes) {
        this.id = id;
        this.fio = fio;
        this.post = post;
        this.animalTypes = animalTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<String> getAnimalTypes() {
        return animalTypes;
    }

    public void setAnimalTypes(List<String> animalTypes) {
        this.animalTypes = animalTypes;
    }
}