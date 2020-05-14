package com.example.medicalrecordapi.dto.mapper;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PatientMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")

    Patient toModel(PatientDTO patientDTO);

    PatientDTO toDTO (Patient patient);
}
