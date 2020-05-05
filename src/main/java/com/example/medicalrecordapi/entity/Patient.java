package com.example.medicalrecordapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
