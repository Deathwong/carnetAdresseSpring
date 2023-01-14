package com.jeff.carnetadresse.repository;

import com.jeff.carnetadresse.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
