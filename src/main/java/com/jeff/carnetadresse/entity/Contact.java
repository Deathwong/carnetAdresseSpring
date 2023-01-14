package com.jeff.carnetadresse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "contact")
@Entity
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "surnom", length = 50)
    private String surnom;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "age", length = 3)
    private Integer age;

    @Column(name = "dateAnniversaire")
    private LocalDate dateAnniversaire;

    @Column(name = "sexe", length = 10)
    private String sexe;

    @Column(name = "reseauSocial", length = 50)
    private String reseauSocial;

    @Column(name = "profession", length = 100)
    private String profession;

    @Column(name = "situationFamiliale", length = 100)
    private String situationFamiliale;

    @Column(name = "note", length = 100)
    private String note;

    @OneToOne
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;
}

