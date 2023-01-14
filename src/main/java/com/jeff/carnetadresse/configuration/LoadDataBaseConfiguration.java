package com.jeff.carnetadresse.configuration;

import com.jeff.carnetadresse.entity.Adresse;
import com.jeff.carnetadresse.entity.Contact;
import com.jeff.carnetadresse.repository.AdresseRepository;
import com.jeff.carnetadresse.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDataBaseConfiguration {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBaseConfiguration.class);

    @Bean
    CommandLineRunner iniDatabase(ContactRepository contactRepository, AdresseRepository adresseRepository) {

        Adresse adresse = Adresse.builder()
                .numeroRue(2)
                .nomRue("nomRue")
                .codePostal("Code")
                .departement("departement")
                .ville("ville")
                .pays("pays")
                .region("region")
                .lieuDit("lieuDit")
                .complementDeux("complementDeux")
                .complementTrois("complementTrois")
                .complementUn("complementUn")
                .build();

        adresseRepository.save(adresse);

        Contact contact = Contact.builder()
                .nom("nom")
                .age(20)
                .email("email")
                .dateAnniversaire(LocalDate.now())
                .sexe("sexe")
                .prenom("prenom")
                .surnom("surnom")
                .note("note")
                .reseauSocial("reseauSocial")
                .telephone("telephone")
                .profession("profession")
                .situationFamiliale("situationFamiliale")
                .adresse(adresse)
                .build();

        contactRepository.save(contact);
        return args -> {
            log.info("preloading success !!");
        };
    }
}
