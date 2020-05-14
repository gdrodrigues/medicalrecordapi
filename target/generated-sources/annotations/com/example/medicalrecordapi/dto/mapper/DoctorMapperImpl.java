package com.example.medicalrecordapi.dto.mapper;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.request.DoctorDTO.DoctorDTOBuilder;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.entity.Doctor.DoctorBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-14T15:23:23-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public Doctor toModel(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        DoctorBuilder doctor = Doctor.builder();

        if ( doctorDTO.getBirthDate() != null ) {
            doctor.birthDate( LocalDate.parse( doctorDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        doctor.id( doctorDTO.getId() );
        doctor.name( doctorDTO.getName() );
        doctor.crm( doctorDTO.getCrm() );

        return doctor.build();
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
