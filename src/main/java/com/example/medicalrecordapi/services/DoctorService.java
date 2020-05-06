package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor(onConstructor = @__(Autowired))
public class DoctorService {

    private DoctorRepository doctorRepository;



}
