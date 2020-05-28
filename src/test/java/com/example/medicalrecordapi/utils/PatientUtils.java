package com.example.medicalrecordapi.utils;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.enums.EthnicityGroups;
import com.example.medicalrecordapi.enums.MaritalStatus;

import java.time.LocalDate;

public class PatientUtils {

    private static final String NAME = "Gabriel Duarte Rodrigues";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1995, 07, 19);
    private static final EthnicityGroups ETHNICITY_GROUP = EthnicityGroups.PRETO;
    private static final MaritalStatus MARITAL_STATUS = MaritalStatus.SOLTEIRO;
    private static final String ADRESS = "Rua Santo Cristo 161";
    private static final String CEP = "24130445";
    private static final String CPF = "15605750771";

    public static PatientDTO createFakePatientDTO(){

        return PatientDTO.builder()
                .nome(NAME)
                .birthDate("19-07-1995")
                .ethnicityGroups(ETHNICITY_GROUP)
                .maritalStatus(MARITAL_STATUS)
                .adress(ADRESS)
                .CEP(CEP)
                .CPF(CPF)
                .build();
    }

    public static Patient createFakeEntity(){
        return Patient.builder()
                .nome(NAME)
                .birthDate(BIRTH_DATE)
                .ethnicityGroups(ETHNICITY_GROUP)
                .maritalStatus(MARITAL_STATUS)
                .adress(ADRESS)
                .CEP(CEP)
                .CPF(CPF)
                .build();
    }


}
