package com.example.medicalrecordapi.mapper;

import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")

    Patient toModel(PatientDTO patientDTO);

    PatientDTO toDTO (Patient patient);
}
