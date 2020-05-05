package com.example.medicalrecordapi.services;


import com.example.medicalrecordapi.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService  {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }


}
