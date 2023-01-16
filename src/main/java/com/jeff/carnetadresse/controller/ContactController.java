package com.jeff.carnetadresse.controller;

import com.jeff.carnetadresse.domain.dto.ContactDto;
import com.jeff.carnetadresse.domain.entity.Contact;
import com.jeff.carnetadresse.domain.mapper.ContactMapper;
import com.jeff.carnetadresse.domain.rest.response.DtoOutput;
import com.jeff.carnetadresse.exception.EntityNotFoundException;
import com.jeff.carnetadresse.repository.AdresseRepository;
import com.jeff.carnetadresse.repository.ContactRepository;
import com.jeff.carnetadresse.utils.Constant;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    private final ContactRepository contactRepository;
    private final AdresseRepository adresseRepository;
    private final ContactMapper contactMapper;

    public ContactController(ContactRepository contactRepository, AdresseRepository adresseRepository,
                             ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.adresseRepository = adresseRepository;
        this.contactMapper = contactMapper;
    }

    @GetMapping
    ResponseEntity<DtoOutput> getAllContact() {

        List<Contact> contacts = contactRepository.findAll();
        List<ContactDto> contactsDto = contacts
                .stream()
                .map(contactMapper::getContact)
                .toList();

        return ResponseEntity.ok().body(new DtoOutput(contactsDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<DtoOutput> getContactById(@PathVariable Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(Contact.class.getSimpleName(), id));
        }

        Contact contact = contactOptional.get();
        ContactDto contactDto = contactMapper.getContact(contact);

        return ResponseEntity.ok().body(new DtoOutput(contactDto));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DtoOutput> saveContact(@RequestBody ContactDto contactDto) {
        Contact contact = contactMapper.getContact(contactDto);
        adresseRepository.save(contact.getAdresse());
        contactRepository.save(contact);

        return ResponseEntity.ok().body(new DtoOutput(contact));
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DtoOutput> updateContact(@RequestBody ContactDto contactDto, @PathVariable Long id) {
        boolean exist = contactRepository.existsById(id);

        if (exist) {
            Contact contact = contactMapper.getContact(contactDto);

            adresseRepository.save(contact.getAdresse());
            contact = contactRepository.save(contact);

            contactDto = contactMapper.getContact(contact);
            return ResponseEntity.ok().body(new DtoOutput(contactDto));
        } else {
            throw new EntityNotFoundException(Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(
                    Contact.class.getSimpleName(), id));
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DtoOutput> deleteContact(@PathVariable Long id) {
        Long idAdresse = adresseRepository.findIdByContactId(id);
        contactRepository.deleteById(id);
        adresseRepository.deleteById(idAdresse);

        return ResponseEntity.ok().body(new DtoOutput());
    }
}
