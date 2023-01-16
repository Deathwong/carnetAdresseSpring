package com.jeff.carnetadresse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AdresseDto {

    private Long id;
    private Integer numeroRue;
    private String nomRue;
    private String ville;
    private String pays;
    private String codePostal;
    private String region;
    private String departement;
    private String lieuDit;
    private String complementUn;
    private String complementDeux;
    private String complementTrois;
}
