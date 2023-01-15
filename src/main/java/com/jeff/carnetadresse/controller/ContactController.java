package com.jeff.carnetadresse.controller;

import com.jeff.carnetadresse.entity.Adresse;
import com.jeff.carnetadresse.entity.Contact;
import com.jeff.carnetadresse.exception.ContactNotFoundException;
import com.jeff.carnetadresse.repository.AdresseRepository;
import com.jeff.carnetadresse.repository.ContactRepository;
import org.springframework.http.MediaType;
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
    List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    Contact getContactById(@PathVariable Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Contact saveContact(@RequestBody Contact contact) {
        Adresse adresse = contact.getAdresse();
        adresseRepository.save(adresse);
        return contactRepository.save(contact);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Contact updateContact(@RequestBody Contact contact, @PathVariable Long id) throws Exception {
        boolean exist = contactRepository.existsById(id);

        if (exist) {
            Adresse adresse = contact.getAdresse();
            adresseRepository.save(adresse);
            return contactRepository.save(contact);
        } else {
            throw new ContactNotFoundException(id);
        }
    }

    @DeleteMapping("/{id}")
    void deleteContact(@PathVariable Long id) {
        Long idAdresse = adresseRepository.findIdByContactId(id);
        contactRepository.deleteById(id);
        adresseRepository.deleteById(idAdresse);
    }
}
