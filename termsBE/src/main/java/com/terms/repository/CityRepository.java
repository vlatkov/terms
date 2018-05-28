package com.terms.repository;

import com.terms.domen.City;
import com.terms.domen.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByName(String name);
    List<City> findAllByCountry(Country country);
    City findAllById(Long id);
}
