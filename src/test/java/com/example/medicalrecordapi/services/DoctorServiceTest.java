package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.request.DoctorDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Doctor;
import com.example.medicalrecordapi.exception.DoctorNotFoundException;
import com.example.medicalrecordapi.repository.DoctorRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.medicalrecordapi.utils.DoctorUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorService doctorService;

    @Test
    void testGivenDoctorDTO() throws DoctorNotFoundException {

        DoctorDTO doctorDTO = createFakeDoctorDTO();
        Doctor expectedDoctor =  createFakeEntity();

        when(doctorRepository.save(expectedDoctor)).thenReturn(expectedDoctor);

        MessageResponseDTO expectedSucessMessage = CreateMessageResponse(expectedDoctor.getId());

        MessageResponseDTO successMessage = doctorService.salvar(doctorDTO);

        assertEquals(expectedSucessMessage,successMessage);


    }

    private MessageResponseDTO CreateMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created doctor with ID: " + id)
                .build();
    }
}
