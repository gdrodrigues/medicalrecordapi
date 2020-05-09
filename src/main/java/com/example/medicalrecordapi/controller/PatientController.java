package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.exception.PatientNotFoundException;
import com.example.medicalrecordapi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService){

        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDTO> getAllPatients(){
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable long id) throws PatientNotFoundException {
        return patientService.getPatientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarPatient(@RequestBody @Valid PatientDTO patientDTO){

        return patientService.salvar(patientDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable long id, @RequestBody @Valid PatientDTO patientDTO) throws PatientNotFoundException {
        return patientService.updateById(id, patientDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) throws PatientNotFoundException {
        patientService.delete(id);
    }
}
