package com.example.medicalrecordapi.mapper;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.entity.Patient.PatientBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-08T09:02:35-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient toModel(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        PatientBuilder patient = Patient.builder();

        if ( patientDTO.getBirthDate() != null ) {
            patient.birthDate( LocalDate.parse( patientDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        patient.id( patientDTO.getId() );
        patient.nome( patientDTO.getNome() );
        patient.ethnicityGroups( patientDTO.getEthnicityGroups() );
        patient.maritalStatus( patientDTO.getMaritalStatus() );
        patient.adress( patientDTO.getAdress() );
        patient.CEP( patientDTO.getCEP() );
        patient.CPF( patientDTO.getCPF() );

        return patient.build();
    }

    @Override
    public PatientDTO toDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( patient.getId() );
        patientDTO.setNome( patient.getNome() );
        if ( patient.getBirthDate() != null ) {
            patientDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( patient.getBirthDate() ) );
        }
        patientDTO.setEthnicityGroups( patient.getEthnicityGroups() );
        patientDTO.setMaritalStatus( patient.getMaritalStatus() );
        patientDTO.setAdress( patient.getAdress() );
        patientDTO.setCEP( patient.getCEP() );
        patientDTO.setTel( patient.getTel() );
        patientDTO.setCPF( patient.getCPF() );

        return patientDTO;
    }
}
