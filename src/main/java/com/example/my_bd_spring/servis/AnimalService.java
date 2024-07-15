//package com.example.my_bd_spring.servis;
//
//import com.example.my_bd_spring.domain.Animals;
//import com.example.my_bd_spring.domain.Cell;
//import com.example.my_bd_spring.domain.Clas;
//import com.example.my_bd_spring.domain.Workers;
//import com.example.my_bd_spring.domain.Zoo;
//import com.example.my_bd_spring.repositories.AnimalRepository;
//import com.example.my_bd_spring.repositories.CellRepository;
//import com.example.my_bd_spring.repositories.ClasRepository;
//import com.example.my_bd_spring.repositories.WorkerRepository;
//import com.example.my_bd_spring.repositories.ZooRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AnimalService {
//
//    @Autowired
//    private AnimalRepository animalRepository;
//
//    @Autowired
//    private WorkerRepository workerRepository;
//
//    @Autowired
//    private CellRepository cellRepository;
//
//    @Autowired
//    private ZooRepository zooRepository;
//
//    @Autowired
//    private ClasRepository clasRepository;
//
//    @Transactional
//    public Animals addAnimalToZoo(int zooId, int workerId, int cellId, String typeAni, int clasId) {
//        //Проверка наличия зоопарка
//        Zoo zoo = zooRepository.findById(zooId).orElseThrow(() -> new RuntimeException("Зоопарк не найден"));
//
//        //Проверка наличия клетки
//        Cell cell = cellRepository.findById(cellId).orElseThrow(() -> new RuntimeException("Клетка не найдена"));
//
//        //Проверка наличия работника
//        Workers worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("Работник не нвайден"));
//
//        // Проверка наличия класса
//        Clas clas = clasRepository.findById(clasId).orElseThrow(() -> new RuntimeException("Клас не найден"));
//
//        //Создание нового животного
//        Animals animal = new Animals(typeAni, clas);
//        animal.setZoo(zoo);
//        animal.setCell(cell);
//        animal.setClas(clas);
//
//        // Сохранение животного
//        return animalRepository.save(animal);
//    }
//}