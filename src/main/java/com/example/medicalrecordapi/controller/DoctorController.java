package com.example.medicalrecordapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    public String getDoctor(){
        return "Teste";
    }

}
