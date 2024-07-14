//package com.example.my_bd_spring.start;
//
//import com.example.my_bd_spring.domain.Ticket;
//import com.example.my_bd_spring.servis.TicketServes;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class TicketStart implements CommandLineRunner {
//
//    private final TicketServes ticketServes;
//
//    public TicketStart(TicketServes ticketServes) {
//        this.ticketServes = ticketServes;
//    }
//
//    @Override
//    public void run(String... args) throws Exception{
//        ticketServes.saveAllTicket(Arrays.asList(
//                new Ticket(300, 3),
//                new Ticket(100,1)
//        ));
//    }
//}
