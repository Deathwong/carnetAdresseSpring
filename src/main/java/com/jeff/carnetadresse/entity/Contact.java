package com.jeff.carnetadresse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Contact {
    private Long id;
    private String nom;
    private String prenom;
    private String surnom;
    private String telephone;
    private String email;
    private Long age;
    private LocalDate dateAnniversaire;
    private String sexe;
    private String reseauSocial;
    private String profession;
    private String situationFamiliale;
    private String note;
    private Adresse adresse;
}
