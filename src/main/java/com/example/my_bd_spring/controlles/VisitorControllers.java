package com.example.my_bd_spring.controlles;

import com.example.my_bd_spring.servis.VisitorServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor")
public class VisitorControllers {

    private final VisitorServis visitorServis;

    @Autowired
    public VisitorControllers(VisitorServis visitorServis){
        this.visitorServis = visitorServis;
    }
}
