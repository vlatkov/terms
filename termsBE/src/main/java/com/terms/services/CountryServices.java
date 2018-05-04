package com.terms.services;

import com.terms.domen.City;
import com.terms.domen.Country;
import com.terms.repository.CountryRepository;
import org.hyalinedto.api.DTO;
import org.hyalinedto.api.Hyaline;
import org.hyalinedto.exception.HyalineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CountryServices implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CityServices cityServices;

    private Map<String, Object> map = new HashMap<>();


    public Object findAllCitiesByCountry(Long Id) throws HyalineException {
        return Hyaline.dtoFromScratch(new DTO() {

            private Country country = countryRepository.findOne(Id);
            private List<City> cities = cityServices.findAllCitiesByCountry(country);

        });

    }

    /*private List<City> formatData(List<City> cities){
        cities.forEach((s)-> s.setCountry(new Country()));
        return cities;
    }*/

}
