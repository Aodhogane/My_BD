package com.example.my_bd_spring.DTO;

public class AddAnimalResponseDTO {
    private Integer newAnimalId;
    private Integer cageId;
    private Integer workerId;

    public AddAnimalResponseDTO() { }

    public AddAnimalResponseDTO(Integer newAnimalId, Integer cageId, Integer workerId) {
        this.newAnimalId = newAnimalId;
        this.cageId = cageId;
        this.workerId = workerId;
    }

    public Integer getNewAnimalId() {
        return newAnimalId;
    }

    public void setNewAnimalId(Integer newAnimalId) {
        this.newAnimalId = newAnimalId;
    }

    public Integer getCageId() {
        return cageId;
    }

    public void setCageId(Integer cageId) {
        this.cageId = cageId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
}