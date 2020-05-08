package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.mapper.DoctorMapper;
import com.example.medicalrecordapi.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
//@AllArgsConstructor(onConstructor = @__(Autowired))
public class DoctorService {

    private final DoctorMapper doctorMapper = DoctorMapper.INSTANCE;

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {

        this.doctorRepository = doctorRepository;
    }


    public List<Doctor> findAll() {

        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(long id) {
        return doctorRepository.findById(id);
    }

    public MessageResponseDTO salvar(DoctorDTO doctorDTO) {
        Doctor doctorToSave = doctorMapper.toModel(doctorDTO);

        Doctor savedDoctor = doctorRepository.save(doctorToSave);
        return MessageResponseDTO
                .builder()
                .message("Created doctor with ID: " + savedDoctor.getId())
                .build();
    }


}
