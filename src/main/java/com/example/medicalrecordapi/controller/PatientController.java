package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.exception.PatientNotFoundException;
import com.example.medicalrecordapi.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private final PatientService patientService;
    
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
