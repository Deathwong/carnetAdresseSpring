package com.jeff.carnetadresse.entity;

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
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "numeroRue")
    private Integer numeroRue;

    @Column(name = "nomRue", length = 50)
    private String nomRue;

    @Column(name = "ville", nullable = false, length = 50)
    private String ville;

    @Column(name = "pays", nullable = false, length = 20)
    private String pays;

    @Column(name = "codePostal", nullable = false, length = 5)
    private String codePostal;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "departement", length = 50)
    private String departement;

    @Column(name = "lieuDit", length = 50)
    private String lieuDit;

    @Column(name = "complementUn", length = 50)
    private String complementUn;

    @Column(name = "complementDeux", length = 50)
    private String complementDeux;

    @Column(name = "complementTrois", length = 50)
    private String complementTrois;
}
