package com.example.medicalrecordapi.controller;

import com.example.medicalrecordapi.model.Doctor;
import com.example.medicalrecordapi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



@RequestMapping("/doctor")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    DoctorController(DoctorService doctorService){

        this.doctorService = doctorService;
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "id") long id){
        Optional<Doctor> doctorO = doctorService.getDoctorById(id);

        if(!doctorO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Doctor>(doctorO.get(), HttpStatus.OK);
        }

    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> listDoctors = doctorService.findAll();

        if(!listDoctors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Doctor>>(listDoctors, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Doctor> criarDoctor(@RequestBody @Valid Doctor doctor){
        Doctor doctor1 = doctorService.salvar(doctor);
        return new ResponseEntity<Doctor>(doctor1, HttpStatus.CREATED);
    }



}
