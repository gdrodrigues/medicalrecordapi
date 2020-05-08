package com.example.medicalrecordapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatus {

    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    VIÚVO("Viúvo"),
    DIVORCIADO("Divorciado");

    private final String description;
}
