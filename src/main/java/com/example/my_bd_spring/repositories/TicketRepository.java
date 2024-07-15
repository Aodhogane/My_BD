package com.example.my_bd_spring.repositories;

import com.example.my_bd_spring.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Нет необходимости что-либо добавлять, если нет пользовательских запросов
}
