package com.example.medicalrecordapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor  // Contrutores
@AllArgsConstructor // Construtores
@Builder    // Padrao de projeto -> construçao dos objetos
@Data      // Getter e Setter
@Entity
@Table(name = "TB_Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia de geração de ID
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String crm;

}
