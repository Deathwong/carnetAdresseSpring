package com.jeff.carnetadresse.domain.mapper;

import com.jeff.carnetadresse.domain.dto.AdresseDto;
import com.jeff.carnetadresse.domain.dto.ContactDto;
import com.jeff.carnetadresse.domain.entity.Adresse;
import com.jeff.carnetadresse.domain.entity.Contact;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class ContactMapper {

    public ContactDto getContact(Contact contact) {
        ContactDto contactDto;
        contactDto = ContactDto.builder()
                .id(contact.getId())
                .nom(contact.getNom())
                .prenom(contact.getPrenom())
                .surnom(contact.getSurnom())
                .telephone(contact.getTelephone())
                .email(contact.getEmail())
                .dateAnniversaire(contact.getDateAnniversaire())
                .sexe(contact.getSexe())
                .reseauxSociaux(contact.getReseauxSociaux())
                .profession(contact.getProfession())
                .situationFamiliale(contact.getSituationFamiliale())
                .note(contact.getNote())
                .adresse(AdresseDto
                        .builder()
                        .id(contact.getAdresse().getId())
                        .numeroRue(contact.getAdresse().getNumeroRue())
                        .nomRue(contact.getAdresse().getNomRue())
                        .ville(contact.getAdresse().getVille())
                        .pays(contact.getAdresse().getPays())
                        .codePostal(contact.getAdresse().getCodePostal())
                        .region(contact.getAdresse().getRegion())
                        .departement(contact.getAdresse().getDepartement())
                        .lieuDit(contact.getAdresse().getLieuDit())
                        .complementUn(contact.getAdresse().getComplementUn())
                        .complementDeux(contact.getAdresse().getComplementDeux())
                        .complementTrois(contact.getAdresse().getComplementTrois())
                        .build()
                )
                .build();
        return contactDto;
    }

    public Contact getContact(ContactDto contactDto) {
        Contact contact = Contact.builder()
                .id(contactDto.getId())
                .nom(contactDto.getNom())
                .prenom(contactDto.getPrenom())
                .surnom(contactDto.getSurnom())
                .telephone(contactDto.getTelephone())
                .email(contactDto.getEmail())
                .age(
                        contactDto.getDateAnniversaire() != null ?
                                Period.between(contactDto.getDateAnniversaire(), LocalDate.now()).getYears() : null
                )
                .dateAnniversaire(contactDto.getDateAnniversaire())
                .sexe(contactDto.getSexe())
                .reseauxSociaux(contactDto.getReseauxSociaux())
                .profession(contactDto.getProfession())
                .situationFamiliale(contactDto.getSituationFamiliale())
                .note(contactDto.getNote())
                .adresse(Adresse
                        .builder()
                        .id(contactDto.getAdresse().getId())
                        .numeroRue(contactDto.getAdresse().getNumeroRue())
                        .nomRue(contactDto.getAdresse().getNomRue())
                        .ville(contactDto.getAdresse().getVille())
                        .pays(contactDto.getAdresse().getPays())
                        .codePostal(contactDto.getAdresse().getCodePostal())
                        .region(contactDto.getAdresse().getRegion())
                        .departement(contactDto.getAdresse().getDepartement())
                        .lieuDit(contactDto.getAdresse().getLieuDit())
                        .complementUn(contactDto.getAdresse().getComplementUn())
                        .complementDeux(contactDto.getAdresse().getComplementDeux())
                        .complementTrois(contactDto.getAdresse().getComplementTrois())
                        .build()
                )
                .build();
        return contact;
    }

}
