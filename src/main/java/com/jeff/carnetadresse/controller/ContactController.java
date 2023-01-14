package com.jeff.carnetadresse.controller;

import com.jeff.carnetadresse.entity.Contact;
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
    Contact getContactById(@PathVariable Long id) throws Exception {
        return contactRepository.findById(id).orElseThrow(() -> new Exception("Contact not found"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Contact saveContact(@RequestBody Contact contact) {
        adresseRepository.save()
        return contactRepository.save(contact);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Contact updateContact(@RequestBody Contact contact, @PathVariable Long id) throws Exception {
        boolean exist = contactRepository.existsById(id);

        if (exist) {
            return contactRepository.save(contact);
        } else {
            throw new Exception("Contact not found");
        }
    }

    @DeleteMapping("/{id}")
    void deleteContact(@PathVariable Long id) throws Exception {
        contactRepository.deleteById(id);
    }
}
