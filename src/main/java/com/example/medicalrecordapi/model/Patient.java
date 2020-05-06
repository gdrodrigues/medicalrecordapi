package com.example.medicalrecordapi.model;

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

    private String ethnicityGroup;


    private String maritalStatus;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String CEP;

    @Column(nullable = false)
    private String Tel;

    @Column(nullable = false, unique = true)
    private String CPF;

}
