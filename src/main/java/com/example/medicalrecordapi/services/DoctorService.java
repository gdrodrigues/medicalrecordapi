package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.model.Doctor;
import com.example.medicalrecordapi.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor(onConstructor = @__(Autowired))
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService (DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(long id){
        return doctorRepository.findById(id);
    }

    public Doctor salvar(Doctor doctor){
        return doctorRepository.save(doctor);
    }


}
