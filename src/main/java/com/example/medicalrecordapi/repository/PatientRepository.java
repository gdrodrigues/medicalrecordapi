package com.example.medicalrecordapi.repository;

import com.example.medicalrecordapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
