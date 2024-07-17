package com.example.my_bd_spring.DTO;

public class TicketPurchaseDTO {
    private long visitorId;
    private int animalId;
    private Long eventId;
    private String visitDate;
    private int quantity;
    private int cost;

    public long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(long visitorId) {
        this.visitorId = visitorId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
