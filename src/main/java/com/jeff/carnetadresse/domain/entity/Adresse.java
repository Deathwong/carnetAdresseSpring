package com.jeff.carnetadresse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "adresse")
@Entity
public class Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_rue")
    private Integer numeroRue;

    @Column(name = "nom_rue", length = 50)
    private String nomRue;

    @Column(name = "ville", nullable = false, length = 50)
    private String ville;

    @Column(name = "pays", nullable = false, length = 50)
    private String pays;

    @Column(name = "code_postal", nullable = false, length = 20)
    private String codePostal;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "departement", length = 50)
    private String departement;

    @Column(name = "lieu_dit", length = 100)
    private String lieuDit;

    @Column(name = "complement_un", length = 50)
    private String complementUn;

    @Column(name = "complement_deux", length = 50)
    private String complementDeux;

    @Column(name = "complement_trois", length = 50)
    private String complementTrois;
}
