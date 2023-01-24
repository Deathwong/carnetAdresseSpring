package com.jeff.carnetadresse.controller;

import com.jeff.carnetadresse.domain.dto.ContactDto;
import com.jeff.carnetadresse.domain.rest.response.DtoOutput;
import com.jeff.carnetadresse.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contact")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    ResponseEntity<DtoOutput> getAllContact() {
        List<ContactDto> contactsDto = contactService.getAll();
        return ResponseEntity.ok().body(new DtoOutput(contactsDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<DtoOutput> getContactById(@PathVariable Long id) {
        ContactDto contactDto = contactService.getById(id);
        return ResponseEntity.ok().body(new DtoOutput(contactDto));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DtoOutput> saveContact(@RequestBody ContactDto contactDto) {
        ContactDto contactDtoReturn = contactService.save(contactDto);
        return ResponseEntity.ok().body(new DtoOutput(contactDtoReturn));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DtoOutput> updateContact(@RequestBody ContactDto contactDto, @PathVariable Long id) {
        ContactDto contactDtoReturn = contactService.update(contactDto, id);
        return ResponseEntity.ok().body(new DtoOutput(contactDtoReturn));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DtoOutput> deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
        return ResponseEntity.ok().body(new DtoOutput());
    }
}
