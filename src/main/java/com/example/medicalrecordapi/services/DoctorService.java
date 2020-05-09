package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.exception.DoctorNotFoundException;
import com.example.medicalrecordapi.mapper.DoctorMapper;
import com.example.medicalrecordapi.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
//@AllArgsConstructor(onConstructor = @__(Autowired))
public class DoctorService {

    private final DoctorMapper doctorMapper = DoctorMapper.INSTANCE;

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {

        this.doctorRepository = doctorRepository;
    }


    public List<DoctorDTO> findAllDoctors() {

        List<Doctor> allDoctors = doctorRepository.findAll();
        return allDoctors
                .stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(long id) throws DoctorNotFoundException {
        Optional<Doctor> doctorO = VerifyIfExists(id);

        return doctorMapper.toDTO(doctorO.get());
    }

    public MessageResponseDTO salvar(DoctorDTO doctorDTO) {
        Doctor doctorToSave = doctorMapper.toModel(doctorDTO);

        Doctor savedDoctor = doctorRepository.save(doctorToSave);
        return MessageResponseDTO
                .builder()
                .message("Created doctor with ID: " + savedDoctor.getId())
                .build();
    }


    public void delete(long id) throws DoctorNotFoundException {
        VerifyIfExists(id);
        doctorRepository.deleteById(id);
    }

    private Optional<Doctor> VerifyIfExists(long id) throws DoctorNotFoundException {
        Optional<Doctor> doctorO = doctorRepository.findById(id);
        if (doctorO.isEmpty()) {
            throw new DoctorNotFoundException(id);
        }
        return doctorO;
    }
}
