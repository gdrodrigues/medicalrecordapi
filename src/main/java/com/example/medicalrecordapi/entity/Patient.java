package com.example.medicalrecordapi.entity;

import com.example.medicalrecordapi.enums.EthnicityGroups;
import com.example.medicalrecordapi.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String birthDate;

    @Enumerated(value = EnumType.STRING)
    private EthnicityGroups ethnicityGroups;

    @Enumerated(value = EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String CEP;

    @Column(nullable = false)
    private String Tel;

    @Column(nullable = false, unique = true)
    private String CPF;

}
