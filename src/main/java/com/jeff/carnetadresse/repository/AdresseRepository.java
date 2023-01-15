package com.jeff.carnetadresse.repository;

import com.jeff.carnetadresse.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    @Query(value = "select adr.id from Contact con join Adresse adr on adr.id = con.adresse.id where con.id = :idContact")
    Long findIdByContactId(@Param("idContact") Long idContact);
}
