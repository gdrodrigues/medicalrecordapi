package com.example.medicalrecordapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EthnicityGroups {

    BRANCO("Branco"),
    PRETO ("Preto"),
    PARDO ("Pardo"),
    INDÍGENA ("Indigena");

    private final String description;


}
