package com.example.my_bd_spring.servis;

import com.example.my_bd_spring.DTO.WorkersResponseDTO;

public interface WorkersServiceContract {

    WorkersResponseDTO getWorkerById(Integer workerId);

}
