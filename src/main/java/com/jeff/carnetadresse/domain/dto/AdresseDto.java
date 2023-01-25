package com.jeff.carnetadresse.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Size(max = 50)
    private String nomRue;

    @NotBlank
    @Size(max = 50)
    private String ville;

    @NotBlank
    @Size(max = 50)
    private String pays;

    @NotBlank
    @Size(max = 50)
    private String codePostal;

    @Size(max = 50)
    private String region;

    @Size(max = 50)
    private String departement;

    @Size(max = 100)
    private String lieuDit;

    @Size(max = 50)
    private String complementUn;

    @Size(max = 50)
    private String complementDeux;

    @Size(max = 50)
    private String complementTrois;
}
