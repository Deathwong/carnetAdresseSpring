package com.jeff.carnetadresse.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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

    @Size(min = 3, max = 50)
    @NotBlank()
    private String nom;

    @Size(min = 3, max = 50)
    @NotBlank()
    private String prenom;

    @Size(min = 3, max = 50)
    private String surnom;

    @Size(min = 4, max = 20)
    @NotBlank()
    private String telephone;

    @Size(min = 4, max = 100)
    @Email
    private String email;

    @PastOrPresent()
    private LocalDate dateAnniversaire;

    @Size(max = 50)
    private String sexe;

    @Size(max = 100)
    private String reseauxSociaux;

    @Size(max = 100)
    private String profession;

    @Size(max = 100)
    private String situationFamiliale;

    @Size(max = 100)
    private String note;


    private AdresseDto adresse;
}
