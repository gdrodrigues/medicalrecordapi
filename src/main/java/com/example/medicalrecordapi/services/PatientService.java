package com.example.medicalrecordapi.services;


import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.mapper.PatientMapper;
import com.example.medicalrecordapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService  {

    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    private PatientRepository patientRepository;

    @Autowired // Injetar dependencia
    public PatientService(PatientRepository patientRepository){

        this.patientRepository=patientRepository;
    }

    public Optional getPatientById(long id){
        Optional patient = patientRepository.findById(id);
        return patient;
    }

    public MessageResponseDTO salvar(PatientDTO patientDTO){
        Patient patientToSave = patientMapper.toModel(patientDTO);

        Patient savedPatient = patientRepository.save(patientToSave);
        return MessageResponseDTO
                .builder()
                .message("Created patient with ID: " + savedPatient.getId())
                .build();
    }


}
