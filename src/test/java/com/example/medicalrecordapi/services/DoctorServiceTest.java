package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.exception.DoctorNotFoundException;
import com.example.medicalrecordapi.dto.mapper.DoctorMapper;
import com.example.medicalrecordapi.repository.DoctorRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.medicalrecordapi.utils.DoctorUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorMapper doctorMapper;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void testGivenDoctorDTOThenReturnSuccessSavedMessage() {

        DoctorDTO doctorDTO = createFakeDoctorDTO();
        Doctor expectedDoctor =  createFakeEntity();

        when(doctorMapper.toModel(doctorDTO)).thenReturn(expectedDoctor);

        when(doctorRepository.save(expectedDoctor)).thenReturn(expectedDoctor);

        MessageResponseDTO expectedSucessMessage = CreateMessageResponse(expectedDoctor.getId());

        MessageResponseDTO successMessage = doctorService.salvar(doctorDTO);

        assertNotNull(expectedDoctor.getId());
        assertEquals(expectedSucessMessage,successMessage);

    }

    @Test
    void testGivenValidDoctorThenReturnThisDoctor() throws DoctorNotFoundException {

        DoctorDTO expectedDoctorDTO = createFakeDoctorDTO();
        Doctor expectedDoctor =  createFakeEntity();

        when(doctorRepository.findById(expectedDoctor.getId())).thenReturn(Optional.of(expectedDoctor));
        when(doctorMapper.toDTO(expectedDoctor)).thenReturn(expectedDoctorDTO);

        DoctorDTO doctorDTO = doctorService.getDoctorById(expectedDoctor.getId());

        assertEquals(expectedDoctorDTO, doctorDTO);

        assertEquals(expectedDoctorDTO.getCrm(), doctorDTO.getCrm());
        assertEquals(expectedDoctorDTO.getName(), doctorDTO.getName());
    }

    @Test
    void testGivenNoDataThenReturnAllDoctors(){
        List<Doctor> expectedAllDoctors = Collections.singletonList(createFakeEntity());
        DoctorDTO doctorDTO = createFakeDoctorDTO();

        when(doctorRepository.findAll()).thenReturn(expectedAllDoctors);
        when(doctorMapper.toDTO(any(Doctor.class))).thenReturn(doctorDTO);

        List<DoctorDTO> allDoctors = doctorService.findAllDoctors();

        assertFalse(allDoctors.isEmpty());
        assertEquals(expectedAllDoctors.get(0).getId(), allDoctors.get(0).getId());

    }



    private MessageResponseDTO CreateMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created doctor with ID: " + id)
                .build();
    }
}
