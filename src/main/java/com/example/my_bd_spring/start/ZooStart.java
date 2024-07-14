//package com.example.my_bd_spring.start;
//
//import com.example.my_bd_spring.domain.Zoo;
//import com.example.my_bd_spring.servis.ZooServis;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class ZooStart implements CommandLineRunner {
//
//    private final ZooServis zooServis;
//
//    public ZooStart(ZooServis zooServis) {
//        this.zooServis = zooServis;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Добавляем билеты в базу данных через сервис
//        zooServis.saveAllZoo(Arrays.asList(
//                new Zoo(300, 300)
//        ));
//    }
//}
