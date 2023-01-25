package com.jeff.carnetadresse.service;

import com.jeff.carnetadresse.domain.dto.AdresseDto;
import com.jeff.carnetadresse.domain.entity.Adresse;
import com.jeff.carnetadresse.domain.mapper.AdresseMapper;
import com.jeff.carnetadresse.exception.EntityNotFoundException;
import com.jeff.carnetadresse.exception.EntityNotSaveException;
import com.jeff.carnetadresse.repository.AdresseRepository;
import com.jeff.carnetadresse.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;
    private final AdresseMapper adresseMapper;

    public List<AdresseDto> getAll() {
        List<Adresse> adresses = adresseRepository.findAll();
        return adresses
                .stream()
                .map(adresseMapper::getAdresse)
                .toList();
    }

    public AdresseDto getById(Long id) {
        Optional<Adresse> adresseOptional = adresseRepository.findById(id);

        if (adresseOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(Adresse.class.getSimpleName(), id));
        }

        Adresse adresse = adresseOptional.get();
        return adresseMapper.getAdresse(adresse);
    }

    public AdresseDto save(AdresseDto adresseDto) {

        Adresse adresse = adresseMapper.getAdresse(adresseDto);
        adresse = adresseRepository.save(adresse);

        return adresseMapper.getAdresse(adresse);
    }

    public AdresseDto update(AdresseDto adresseDto, Long id) {
        boolean existAdresse = adresseExist(id);

        if (existAdresse) {
            Adresse adresse = adresseMapper.getAdresse(adresseDto);
            adresse.setId(id);

            try {
                adresse = adresseRepository.save(adresse);
            } catch (Exception exception) {
                throw new EntityNotSaveException(Constant.NOT_SAVE_MESSAGE);
            }

            return adresseMapper.getAdresse(adresse);
        } else {
            throw new EntityNotFoundException(Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(Adresse.class.getSimpleName(),
                    id));
        }
    }

    public void deleteById(Long id) {
        boolean existAdresse = adresseRepository.existsById(id);

        if (existAdresse) {
            adresseRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(Adresse.class.getSimpleName(),
                    id));
        }
    }

    private boolean adresseExist(Long id) {
        return adresseRepository.existsById(id);
    }
}
