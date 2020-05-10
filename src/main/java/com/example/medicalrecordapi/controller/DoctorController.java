package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.exception.DoctorNotFoundException;
import com.example.medicalrecordapi.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/doctor")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DoctorController {

    private DoctorService doctorService;


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
    public MessageResponseDTO newDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return doctorService.salvar(doctorDTO);

    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable long id, @RequestBody @Valid DoctorDTO doctorDTO) throws DoctorNotFoundException {
        return doctorService.updateById(id, doctorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById( @PathVariable long id) throws DoctorNotFoundException {
        doctorService.delete(id);
    }


}
