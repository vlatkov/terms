package com.terms.resource;

import com.terms.domen.RegistrationPlace;
import com.terms.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Optional;


@RestController
@RequestMapping(value = "${api.path}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RegistrationPlaceRest {

    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "/registration-place",method = RequestMethod.POST)
    public ResponseEntity<RegistrationPlace> registerPlace(@RequestBody RegistrationPlace registrationPlace){

        return Optional.ofNullable(placeService.save(registrationPlace))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
