package com.example.medicalrecordapi.mapper;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.entity.Doctor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-09T10:21:19-0300",
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

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( doctor.getId() );
        doctorDTO.setName( doctor.getName() );
        if ( doctor.getBirthDate() != null ) {
            doctorDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( doctor.getBirthDate() ) );
        }
        doctorDTO.setCrm( doctor.getCrm() );

        return doctorDTO;
    }
}
