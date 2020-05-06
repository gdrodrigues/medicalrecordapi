package com.example.medicalrecordapi.repository;

import com.example.medicalrecordapi.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
