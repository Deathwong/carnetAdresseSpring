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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "age")
    private Integer age;

    @Column(name = "date_anniversaire")
    private LocalDate dateAnniversaire;

    @Column(name = "sexe", length = 50)
    private String sexe;

    @Column(name = "reseaux_sociaux", length = 100)
    private String reseauxSociaux;

    @Column(name = "profession", length = 100)
    private String profession;

    @Column(name = "situation_familiale", length = 100)
    private String situationFamiliale;

    @Column(name = "note", length = 100)
    private String note;

    @OneToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;
}

