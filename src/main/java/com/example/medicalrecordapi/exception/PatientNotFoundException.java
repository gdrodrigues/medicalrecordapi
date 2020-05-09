package com.example.medicalrecordapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception {

    public PatientNotFoundException(long id) {
         super("Person not found with id " + id);
    }
}
