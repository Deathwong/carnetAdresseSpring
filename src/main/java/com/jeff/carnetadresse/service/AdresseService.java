package com.jeff.carnetadresse.service;

import com.jeff.carnetadresse.domain.dto.AdresseDto;

import java.util.List;

public interface AdresseService {
    List<AdresseDto> getAll();

    AdresseDto getById(Long id);

    AdresseDto save(AdresseDto adresseDto);

    AdresseDto update(AdresseDto adresseDto, Long id);

    void deleteById(Long id);
}
