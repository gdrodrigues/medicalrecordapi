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

    private final long fakeId = 500L;

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
    void testGivenInvalidDoctorThenReturnException(){

       when(doctorRepository.findById(fakeId)).thenReturn(Optional.ofNullable(any(Doctor.class)));

       assertThrows(DoctorNotFoundException.class, ()-> doctorService.getDoctorById(fakeId));
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

    @Test
    void testGivenValidDoctorIdThenReturnNoData() throws DoctorNotFoundException {
        Doctor expectedDoctor = createFakeEntity();

        when(doctorRepository.findById(expectedDoctor.getId())).thenReturn(Optional.of(expectedDoctor));

        doctorService.delete(expectedDoctor.getId());

        verify(doctorRepository, times(1)).deleteById(expectedDoctor.getId());


    }

    @Test
    void testGivenInvalidDoctorIdThenReturnNoData(){

        when(doctorRepository.findById(fakeId)).thenReturn(Optional.ofNullable(any(Doctor.class)));

        assertThrows(DoctorNotFoundException.class, ()-> doctorService.delete(fakeId));
    }

    @Test
    void testGivenValidDoctorThenReturnSucessUpdateMessage() throws DoctorNotFoundException {
        var updatedDoctorID = 2L;
        DoctorDTO updatedDoctorDTO = createFakeDoctorDTO();

        updatedDoctorDTO.setId(updatedDoctorID);
        updatedDoctorDTO.setName("Flavio Seixas");

        Doctor expectedDoctorUpdate = createFakeEntity();

        expectedDoctorUpdate.setId(updatedDoctorID);
        expectedDoctorUpdate.setName("Flavio Seixas");

        when(doctorRepository.findById(updatedDoctorID)).thenReturn(Optional.of(expectedDoctorUpdate));
        when(doctorMapper.toModel(updatedDoctorDTO)).thenReturn(expectedDoctorUpdate);
        when(doctorRepository.save(any(Doctor.class))).thenReturn(expectedDoctorUpdate);

        MessageResponseDTO sucessMessage = doctorService.updateById(updatedDoctorID, updatedDoctorDTO);

        assertEquals("Updated doctor with ID: "+updatedDoctorID, sucessMessage.getMessage());

    }


    private MessageResponseDTO CreateMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created doctor with ID: " + id)
                .build();
    }
}
