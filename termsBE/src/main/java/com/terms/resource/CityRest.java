package com.terms.resource;

import com.terms.domen.City;
import com.terms.services.CityServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "${api.path}/city",produces = MediaType.APPLICATION_JSON_VALUE)
public class CityRest implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Logger log = LoggerFactory.getLogger(CityRest.class);

    @Autowired
    CityServices cityServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<City>> getCity()
    {
        List<City> cities = cityServices.getAllCities();

        return Optional.ofNullable(cities)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }


    @RequestMapping(value = "/{cityId}", method = RequestMethod.GET)
    public City getOneCity(@PathVariable Long cityId)
    {
        return cityServices.getOneCity(cityId);
    }
}
