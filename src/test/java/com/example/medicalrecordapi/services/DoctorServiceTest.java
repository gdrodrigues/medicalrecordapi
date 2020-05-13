package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.exception.DoctorNotFoundException;
import com.example.medicalrecordapi.mapper.DoctorMapper;
import com.example.medicalrecordapi.repository.DoctorRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.medicalrecordapi.utils.DoctorUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    DoctorRepository doctorRepository;

    @Mock
    DoctorMapper doctorMapper;

    @InjectMocks
    DoctorService doctorService;

    @Test
    void testGivenDoctorDTOThenReturnSuccessSavedMessage() {

        DoctorDTO doctorDTO = createFakeDoctorDTO();
        Doctor expectedDoctor =  createFakeEntity();

        //when(doctorMapper.toModel(doctorDTO)).thenReturn(expectedDoctor);

        when(doctorRepository.save(expectedDoctor)).thenReturn(expectedDoctor);

        MessageResponseDTO expectedSucessMessage = CreateMessageResponse(expectedDoctor.getId());

        MessageResponseDTO successMessage = doctorService.salvar(doctorDTO);

        assertNotNull(expectedDoctor.getId());
        assertEquals(expectedSucessMessage,successMessage);

    }

    @Test
    void testGivenDoctorDTOThenReturnThisDoctor() throws DoctorNotFoundException {

        DoctorDTO expectedDoctorDTO = createFakeDoctorDTO();
        Doctor expectedDoctor =  createFakeEntity();
        Optional<Doctor> doctorO = Optional.of(expectedDoctor);

        when(doctorRepository.findById(expectedDoctor.getId())).thenReturn(doctorO);
        when(doctorMapper.toDTO(doctorO.get())).thenReturn(expectedDoctorDTO);

        DoctorDTO doctorDTO = doctorService.getDoctorById(expectedDoctor.getId());

        assertNotNull(expectedDoctor.getId());
        assertEquals(expectedDoctorDTO, doctorDTO);

        assertEquals(expectedDoctorDTO.getCrm(), doctorDTO.getCrm());
        assertEquals(expectedDoctorDTO.getName(), doctorDTO.getName());

    }

    private MessageResponseDTO CreateMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created doctor with ID: " + id)
                .build();
    }
}
