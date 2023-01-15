package com.jeff.carnetadresse.controller;

import com.jeff.carnetadresse.entity.Adresse;
import com.jeff.carnetadresse.entity.Contact;
import com.jeff.carnetadresse.exception.ContactNotFoundException;
import com.jeff.carnetadresse.repository.AdresseRepository;
import com.jeff.carnetadresse.repository.ContactRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    private final ContactRepository contactRepository;
    private final AdresseRepository adresseRepository;

    public ContactController(ContactRepository contactRepository, AdresseRepository adresseRepository) {
        this.contactRepository = contactRepository;
        this.adresseRepository = adresseRepository;
    }

    @GetMapping
    ResponseEntity<List<Contact>> getAllContact() {
        return ResponseEntity.ok().body(contactRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok().body(contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Adresse adresse = contact.getAdresse();
        adresseRepository.save(adresse);
        return ResponseEntity.ok().body(contactRepository.save(contact));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        boolean exist = contactRepository.existsById(id);

        if (exist) {
            Adresse adresse = contact.getAdresse();
            adresseRepository.save(adresse);
            return ResponseEntity.ok().body(contactRepository.save(contact));
        } else {
            throw new ContactNotFoundException(id);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        Long idAdresse = adresseRepository.findIdByContactId(id);
        contactRepository.deleteById(id);
        adresseRepository.deleteById(idAdresse);
        return ResponseEntity.ok().build();
    }
}
