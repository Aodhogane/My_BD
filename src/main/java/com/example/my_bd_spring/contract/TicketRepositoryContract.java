package com.example.my_bd_spring.contract;

import com.example.my_bd_spring.domain.Ticket;

public interface TicketRepositoryContract {
    void save(Ticket ticket);
}