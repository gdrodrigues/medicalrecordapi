package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.repository.DoctorRepository;
import com.example.medicalrecordapi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    public String getDoctor(){
        return "Teste";
    }

}
