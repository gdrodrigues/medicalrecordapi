package com.example.medicalrecordapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends Exception {

    public DoctorNotFoundException(long id){
        super("Doctor not found with id " + id);
    }
}
