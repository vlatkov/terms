package com.terms.repository;

import com.terms.domen.RegistrationPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationPlaceRepository extends JpaRepository<RegistrationPlace, Long> {

    RegistrationPlace findAllByPlace(Long Id);
}
