package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.TicketPurchaseDTO;
import com.example.my_bd_spring.DTO.TicketResponseDTO;
import com.example.my_bd_spring.domain.Ticket;
import com.example.my_bd_spring.domain.Event;
import com.example.my_bd_spring.domain.Visitor;
import com.example.my_bd_spring.repositories.EventRepository;
import com.example.my_bd_spring.repositories.TicketRepository;
import com.example.my_bd_spring.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final VisitorRepository visitorRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, EventRepository eventRepository, VisitorRepository visitorRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.visitorRepository = visitorRepository;
    }

    public TicketResponseDTO purchaseTicket(TicketPurchaseDTO dto, Long visitorId) {
        LocalDate visitDate = LocalDate.parse(dto.getVisitDate()); // Преобразование строки даты посещения в объект LocalDate

        // Поиск события по ID
        Event event = eventRepository.findById(dto.getEventId());

        // Поиск посетителя по ID
        Visitor visitor = visitorRepository.findById(visitorId);

        // Проверка, что событие и посетитель существуют
        if (event == null || visitor == null) {
            // Возвращает пустой объект TicketResponseDTO, если событие или посетитель не найдены
            return new TicketResponseDTO();
        }
        // Создание нового объекта Ticket (Билет)
        Ticket ticket = new Ticket();

        ticket.setVisitor(visitor);          // Установка посетителя
        ticket.setZoo(event.getZoo());       // Установка зоопарка, связанного с событием
        ticket.setCost(dto.getCost());       // Установка стоимости билета
        ticket.setCol(dto.getQuantity());    // Установка количества билетов

        // Сохранение билета в базе данных
        ticketRepository.save(ticket);

        // Возврат объекта TicketResponseDTO с данными о созданном билете
        return new TicketResponseDTO(visitorId, dto.getAnimalId(), dto.getEventId(),
                dto.getVisitDate(), dto.getQuantity(), dto.getCost());
    }
}