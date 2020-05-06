package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.model.Patient;
import com.example.medicalrecordapi.repository.PatientRepository;
import com.example.medicalrecordapi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") long id){
        Optional<Patient> patientO = patientService.getPatientById(id);

        if(!patientO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Patient>(patientO.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Patient> criarPatient(@RequestBody Patient patient){
        Patient patient1 = patientService.salvar(patient);
        return new ResponseEntity<Patient>(patient1, HttpStatus.CREATED);
    }


}
