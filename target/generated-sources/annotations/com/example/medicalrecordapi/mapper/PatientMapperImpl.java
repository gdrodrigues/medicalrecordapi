package com.example.medicalrecordapi.mapper;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.entity.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-10T13:25:03-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient toModel(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        if ( patientDTO.getBirthDate() != null ) {
            patient.setBirthDate( LocalDate.parse( patientDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        patient.setId( patientDTO.getId() );
        patient.setNome( patientDTO.getNome() );
        patient.setEthnicityGroups( patientDTO.getEthnicityGroups() );
        patient.setMaritalStatus( patientDTO.getMaritalStatus() );
        patient.setAdress( patientDTO.getAdress() );
        patient.setCEP( patientDTO.getCEP() );
        patient.setTel( patientDTO.getTel() );
        patient.setCPF( patientDTO.getCPF() );

        return patient;
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
