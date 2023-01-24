package com.jeff.carnetadresse.domain.mapper;

import com.jeff.carnetadresse.domain.dto.AdresseDto;
import com.jeff.carnetadresse.domain.entity.Adresse;
import org.springframework.stereotype.Component;

@Component
public class AdresseMapper {

    public Adresse getAdresse(AdresseDto adresseDto) {
        Adresse adresse = Adresse
                .builder()
                .id(adresseDto.getId())
                .numeroRue(adresseDto.getNumeroRue())
                .nomRue(adresseDto.getNomRue())
                .ville(adresseDto.getVille())
                .pays(adresseDto.getPays())
                .codePostal(adresseDto.getCodePostal())
                .region(adresseDto.getRegion())
                .departement(adresseDto.getDepartement())
                .lieuDit(adresseDto.getLieuDit())
                .complementUn(adresseDto.getComplementUn())
                .complementDeux(adresseDto.getComplementDeux())
                .complementTrois(adresseDto.getComplementTrois())

                .build();
        return adresse;
    }

    public AdresseDto getAdresse(Adresse adresse) {
        AdresseDto adresseDto = AdresseDto.builder()
                .id(adresse.getId())
                .numeroRue(adresse.getNumeroRue())
                .nomRue(adresse.getNomRue())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .codePostal(adresse.getCodePostal())
                .region(adresse.getRegion())
                .departement(adresse.getDepartement())
                .lieuDit(adresse.getLieuDit())
                .complementUn(adresse.getComplementUn())
                .complementDeux(adresse.getComplementDeux())
                .complementTrois(adresse.getComplementTrois())

                .build();
        return adresseDto;
    }
}
