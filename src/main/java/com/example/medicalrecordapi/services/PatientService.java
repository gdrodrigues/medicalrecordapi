package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.exception.PatientNotFoundException;
import com.example.medicalrecordapi.dto.mapper.PatientMapper;
import com.example.medicalrecordapi.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired)) //injecao de dependencia automático
public class PatientService  {

    private final PatientMapper patientMapper;

    private final PatientRepository patientRepository;

    public PatientDTO getPatientById(long id) throws PatientNotFoundException {
        Optional<Patient> patientO = VerifyIfExists(id);

        return patientMapper.toDTO(patientO.get());
    }

    public MessageResponseDTO salvar(PatientDTO patientDTO){
        Patient patientToSave = patientMapper.toModel(patientDTO);

        Patient updatedPatient = patientRepository.save(patientToSave);
        return CreateMessageResponse(updatedPatient.getId(), "Created patient with ID: ");
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

    public MessageResponseDTO updateById(long id, PatientDTO patientDTO) throws PatientNotFoundException {

        VerifyIfExists(id);
        Patient patientToUpdate = patientMapper.toModel(patientDTO);

        Patient savedPatient = patientRepository.save(patientToUpdate);
        return CreateMessageResponse(savedPatient.getId(), "Updated patient with ID: ");
    }

    private Optional<Patient> VerifyIfExists(long id) throws PatientNotFoundException {
        Optional<Patient> patientO = patientRepository.findById(id);
        if (patientO.isEmpty()) {
            throw new PatientNotFoundException(id);
        }
        return patientO;
    }

    private MessageResponseDTO CreateMessageResponse(long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}
