//package com.example.my_bd_spring.controlles;
//
//import com.example.my_bd_spring.domain.Animals;
//import com.example.my_bd_spring.servis.AnimalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class AnimalController {
//
//    @Autowired
//    private AnimalService animalService;
//
//    @PostMapping("/add-animal")
//    public Animals addAnimalToZoo(
//            @RequestParam int zooId,
//            @RequestParam int workerId,
//            @RequestParam int cellId,
//            @RequestParam String typeAni,
//            @RequestParam int clasId) {
//        return animalService.addAnimalToZoo(zooId, workerId, cellId, typeAni, clasId);
//    }
//}

//Не рабочий запрос. В дороботке