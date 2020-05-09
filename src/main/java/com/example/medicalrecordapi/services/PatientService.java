package com.example.medicalrecordapi.services;


import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.exception.PatientNotFoundException;
import com.example.medicalrecordapi.mapper.PatientMapper;
import com.example.medicalrecordapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService  {

    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    private PatientRepository patientRepository;

    @Autowired // Injetar dependencia
    public PatientService(PatientRepository patientRepository){

        this.patientRepository=patientRepository;
    }

    public PatientDTO getPatientById(long id) throws PatientNotFoundException {
        Optional<Patient> patientO = VerifyIfExists(id);

        return patientMapper.toDTO(patientO.get());
    }

    public MessageResponseDTO salvar(PatientDTO patientDTO){
        Patient patientToSave = patientMapper.toModel(patientDTO);

        Patient savedPatient = patientRepository.save(patientToSave);
        return MessageResponseDTO
                .builder()
                .message("Created patient with ID: " + savedPatient.getId())
                .build();
    }

    public List<PatientDTO> findAll(){
        List<Patient> allPatients= patientRepository.findAll();
        return allPatients
                .stream()
                .map(patientMapper::toDTO)
                .collect(Collectors.toList());

    }


    public void delete(long id) throws PatientNotFoundException {
        VerifyIfExists(id);
        patientRepository.deleteById(id);
    }

    private Optional<Patient> VerifyIfExists(long id) throws PatientNotFoundException {
        Optional<Patient> patientO = patientRepository.findById(id);
        if (patientO.isEmpty()) {
            throw new PatientNotFoundException(id);
        }
        return patientO;
    }
}
