package com.example.medicalrecordapi.services;

import com.example.medicalrecordapi.dto.mapper.PatientMapper;
import com.example.medicalrecordapi.dto.request.PatientDTO;
import com.example.medicalrecordapi.dto.response.MessageResponseDTO;
import com.example.medicalrecordapi.entity.Patient;
import com.example.medicalrecordapi.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.medicalrecordapi.utils.PatientUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientMapper patientMapper;

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private final long fakeId = 500L;

    @Test
    void testGivenPatientDTOThenReturnSuccessSavedMessage(){

        PatientDTO patientDTO = createFakePatientDTO();
        Patient expectedPatient = createFakeEntity();

        when(patientMapper.toModel(patientDTO)).thenReturn(expectedPatient);
        when(patientRepository.save(expectedPatient)).thenReturn(expectedPatient);

        MessageResponseDTO expectedSucessMessage = CreateMessageResponse(expectedPatient.getId());

        MessageResponseDTO sucessMessage = patientService.salvar(patientDTO);

        assertNotNull(expectedPatient.getId());

        assertEquals(expectedSucessMessage, sucessMessage);
    }

    private MessageResponseDTO CreateMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created patient with ID: " + id)
                .build();
    }

}
