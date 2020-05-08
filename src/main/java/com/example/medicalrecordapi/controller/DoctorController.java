package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
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
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "id") long id) {
        Optional<Doctor> doctorO = doctorService.getDoctorById(id);

        if (!doctorO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Doctor>(doctorO.get(), HttpStatus.OK);
        }

    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> listDoctors = doctorService.findAll();

        if (!listDoctors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Doctor>>(listDoctors, HttpStatus.OK);
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return doctorService.salvar(doctorDTO);

    }


}
