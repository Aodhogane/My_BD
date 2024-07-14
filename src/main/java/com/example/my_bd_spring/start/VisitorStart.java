//package com.example.my_bd_spring.start;
//
//import com.example.my_bd_spring.domain.Visitor;
//import com.example.my_bd_spring.servis.VisitorServis;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class VisitorStart implements CommandLineRunner {
//
//    private final VisitorServis visitorServis;
//
//    public VisitorStart(VisitorServis visitorServis) {
//        this.visitorServis = visitorServis;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Добавляем билеты в базу данных через сервис
//        visitorServis.saveAllVisitor(Arrays.asList(
//                new Visitor("Альмур", 21)
//        ));
//    }
//}
