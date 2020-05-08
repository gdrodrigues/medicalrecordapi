package com.example.medicalrecordapi.services;


import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService  {

    private PatientRepository patientRepository;

    @Autowired // Injetar dependencia
    public PatientService(PatientRepository patientRepository){

        this.patientRepository=patientRepository;
    }

    public Optional getPatientById(long id){
        Optional patient = patientRepository.findById(id);
        return patient;
    }

    public MessageResponseDTO salvar(Patient patient){

        return MessageResponseDTO
                .builder()
                .message("Created patient with ID: " + patient.getId())
                .build();
    }


}
