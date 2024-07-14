//package com.example.my_bd_spring.start;
//
//import com.example.my_bd_spring.domain.Clas;
//import com.example.my_bd_spring.servis.ClasServis;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class ClasStart implements CommandLineRunner {
//
//    private final ClasServis clasServis;
//
//    public ClasStart(ClasServis clasServis) {
//        this.clasServis = clasServis;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Добавляем билеты в базу данных через сервис
//        clasServis.saveAllClas(Arrays.asList(
//                new Clas("Млекопитающие"),
//                new Clas("Паукообразные")
//        ));
//    }
//}
