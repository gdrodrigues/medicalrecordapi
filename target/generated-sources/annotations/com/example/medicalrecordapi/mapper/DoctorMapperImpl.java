package com.example.medicalrecordapi.mapper;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.request.DoctorDTO.DoctorDTOBuilder;
import com.example.medicalrecordapi.entity.Doctor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-08T09:33:47-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public Doctor toModel(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        if ( doctorDTO.getBirthDate() != null ) {
            doctor.setBirthDate( LocalDate.parse( doctorDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        doctor.setId( doctorDTO.getId() );
        doctor.setName( doctorDTO.getName() );
        doctor.setCrm( doctorDTO.getCrm() );

        return doctor;
    }

    @Override
    public DoctorDTO toDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTOBuilder doctorDTO = DoctorDTO.builder();

        doctorDTO.id( doctor.getId() );
        doctorDTO.name( doctor.getName() );
        if ( doctor.getBirthDate() != null ) {
            doctorDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( doctor.getBirthDate() ) );
        }
        doctorDTO.crm( doctor.getCrm() );

        return doctorDTO.build();
    }
}
