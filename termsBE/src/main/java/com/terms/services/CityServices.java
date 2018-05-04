package com.terms.services;

import com.terms.domen.City;
import com.terms.domen.Country;
import com.terms.repository.CityRepository;
import com.terms.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServices {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private RegionRepository regionRepository;

    public List<City> findAllCitiesByCountry(Country country){
        return cityRepository.findAllByCountry(country);
    }
    public List<City> findAllByName(String name){
        return cityRepository.findAllByName(name);
    }

    public City getOneCity(Long cityId){
        return cityRepository.findOne(cityId);
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

}
