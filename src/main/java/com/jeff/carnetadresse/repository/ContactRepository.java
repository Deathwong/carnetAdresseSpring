package com.jeff.carnetadresse.repository;

import com.jeff.carnetadresse.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}