package com.example.medicalrecordapi.mapper;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")

    Doctor toModel(DoctorDTO doctorDTO);

    DoctorDTO toDTO(Doctor doctor);
}
