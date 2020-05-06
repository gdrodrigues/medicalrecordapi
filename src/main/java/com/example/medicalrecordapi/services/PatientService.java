package com.example.medicalrecordapi.services;


import com.example.medicalrecordapi.model.Patient;
import com.example.medicalrecordapi.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService  {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){

        this.patientRepository=patientRepository;
    }

    public Optional getPatientById(long id){
        Optional patient = patientRepository.findById(id);
        return patient;
    }


}
