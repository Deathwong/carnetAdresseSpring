package com.jeff.carnetadresse.service;

import com.jeff.carnetadresse.domain.dto.ContactDto;
import com.jeff.carnetadresse.domain.entity.Contact;
import com.jeff.carnetadresse.domain.mapper.ContactMapper;
import com.jeff.carnetadresse.exception.EntityNotFoundException;
import com.jeff.carnetadresse.exception.EntityNotSaveException;
import com.jeff.carnetadresse.repository.AdresseRepository;
import com.jeff.carnetadresse.repository.ContactRepository;
import com.jeff.carnetadresse.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    
    private final ContactRepository contactRepository;
    private final AdresseRepository adresseRepository;
    private final ContactMapper contactMapper;

    public List<ContactDto> getAll() {
        List<Contact> contacts = contactRepository.findAll();

        return contacts
                .stream()
                .map(contactMapper::getContact)
                .toList();
    }

    public ContactDto getById(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isEmpty()) {
            throw new EntityNotFoundException(Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(Contact.class.getSimpleName(),
                    id));
        }
        Contact contact = contactOptional.get();

        return contactMapper.getContact(contact);
    }

    public ContactDto save(ContactDto contactDto) {
        try {
            Contact contact = contactMapper.getContact(contactDto);

            adresseRepository.save(contact.getAdresse());
            contact = contactRepository.save(contact);

            return contactMapper.getContact(contact);
        } catch (Exception exception) {
            throw new EntityNotSaveException(Constant.NOT_SAVE);
        }
    }

    public ContactDto update(ContactDto contactDto, Long id) {

        Contact contact = contactMapper.getContact(contactDto);

        boolean existContact = contactExist(id);

        if (existContact) {
            try {
                contact.setId(id);
                adresseRepository.save(contact.getAdresse());
                contact = contactRepository.save(contact);

                return contactMapper.getContact(contact);
            } catch (Exception exception) {
                throw new EntityNotSaveException(Constant.NOT_SAVE);
            }
        } else {
            throw new EntityNotFoundException(Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(Contact.class.getSimpleName()
                    , id));
        }

    }

    public void deleteById(Long id) {
        boolean existContact = contactExist(id);

        if (existContact) {
            Long idAdresse = adresseRepository.findIdByContactId(id);
            contactRepository.deleteById(id);
            adresseRepository.deleteById(idAdresse);
        } else {
            throw new EntityNotFoundException(Constant.ENTITY_NOT_FOUND_MESSAGE.formatted(
                    Contact.class.getSimpleName(), id));
        }
    }

    private boolean contactExist(Long id) {
        return contactRepository.existsById(id);
    }
}
