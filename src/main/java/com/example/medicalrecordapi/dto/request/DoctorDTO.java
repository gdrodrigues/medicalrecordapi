package com.example.medicalrecordapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String birthDate;

    @NotEmpty
    @Size(min=7, max=13)
    private String crm;

}
