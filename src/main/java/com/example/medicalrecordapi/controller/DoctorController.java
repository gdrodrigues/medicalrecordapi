package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.exception.DoctorNotFoundException;
import com.example.medicalrecordapi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/doctor")
@RestController
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    DoctorController(DoctorService doctorService) {

        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable long id) throws DoctorNotFoundException {
        return doctorService.getDoctorById(id);

    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {

        return doctorService.findAllDoctors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return doctorService.salvar(doctorDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById( @PathVariable long id) throws DoctorNotFoundException {
        doctorService.delete(id);
    }


}
