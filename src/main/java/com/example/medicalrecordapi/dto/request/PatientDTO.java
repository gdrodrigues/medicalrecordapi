package com.example.medicalrecordapi.dto.request;


import com.example.medicalrecordapi.enums.EthnicityGroups;
import com.example.medicalrecordapi.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private long id;

    @NotEmpty
    @Size(min=2, max=100)
    private String nome;

    @NotEmpty
    private String birthDate;

    @Enumerated(value = EnumType.STRING)
    private EthnicityGroups ethnicityGroups;

    @Enumerated(value = EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotEmpty
    private String adress;

    @NotEmpty
    private String CEP;

    private String Tel;

    @NotEmpty
    @CPF
    private String CPF;
}
