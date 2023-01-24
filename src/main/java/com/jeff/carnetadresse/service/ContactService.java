package com.jeff.carnetadresse.service;

import com.jeff.carnetadresse.domain.dto.ContactDto;

import java.util.List;

public interface ContactService {

    List<ContactDto> getAll();

    ContactDto getById(Long id);

    ContactDto save(ContactDto contactDto);

    ContactDto update(ContactDto contactDto, Long id);

    void deleteById(Long id);
}
