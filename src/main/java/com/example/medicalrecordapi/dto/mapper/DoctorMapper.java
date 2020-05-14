package com.example.medicalrecordapi.dto.mapper;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DoctorMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")

    Doctor toModel(DoctorDTO doctorDTO);

    DoctorDTO toDTO(Doctor doctor);
}
