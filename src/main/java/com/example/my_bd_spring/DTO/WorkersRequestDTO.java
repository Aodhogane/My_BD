package com.example.my_bd_spring.DTO;

public class WorkersRequestDTO {
    private String fio;
    private String post;

    public WorkersRequestDTO() {
    }

    public WorkersRequestDTO(String fio, String post) {
        this.fio = fio;
        this.post = post;

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
}