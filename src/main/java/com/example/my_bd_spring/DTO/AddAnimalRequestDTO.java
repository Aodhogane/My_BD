package com.example.my_bd_spring.DTO;

public class AddAnimalRequestDTO {
    private String species;
    private Integer classId;
    private Integer zooId;
    private Integer cellId;
    private Integer workerId;

    public AddAnimalRequestDTO() { }

    public AddAnimalRequestDTO(String species, Integer classId,
                               Integer zooId, Integer cellId, Integer workerId) {
        this.species = species;
        this.classId = classId;
        this.zooId = zooId;
        this.cellId = cellId;
        this.workerId = workerId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getZooId() {
        return zooId;
    }

    public void setZooId(Integer zooId) {
        this.zooId = zooId;
    }

    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
}