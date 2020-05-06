package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.model.Patient;
import com.example.medicalrecordapi.repository.PatientRepository;
import com.example.medicalrecordapi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public Optional getById(@PathVariable long id){
        return patientService.getPatientById(id);
    }

}
