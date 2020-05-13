package com.example.medicalrecordapi.utils;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.entity.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DoctorUtils {

    private static final String NAME = "Gabriel Duarte Rodrigues";
    private static final String CRM = "12345/RJ";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1995, 07, 19);;

    public static DoctorDTO createFakeDoctorDTO(){
        return DoctorDTO.builder()
                .name(NAME)
                .crm(CRM)
                .birthDate("19-07-1995")
                .build();
    }

    public static Doctor createFakeEntity(){
        return Doctor.builder()
                .name(NAME)
                .crm(CRM)
                .birthDate(BIRTH_DATE)
                .build();
    }

}
