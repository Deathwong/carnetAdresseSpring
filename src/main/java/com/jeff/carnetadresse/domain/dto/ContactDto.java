package com.jeff.carnetadresse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ContactDto {

    private Long id;
    private String nom;
    private String prenom;
    private String surnom;
    private String telephone;
    private String email;
    private LocalDate dateAnniversaire;
    private String sexe;
    private String reseauxSociaux;
    private String profession;
    private String situationFamiliale;
    private String note;
    private AdresseDto adresse;
}
