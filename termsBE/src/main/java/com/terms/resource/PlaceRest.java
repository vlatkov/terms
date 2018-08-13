package com.terms.resource;


import com.terms.domen.Place;
import com.terms.repository.PlaceRepository;

import com.terms.repository.RegionRepository;
import com.terms.services.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "${api.path}",
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PlaceRest {

    private final Logger log = LoggerFactory.getLogger(PlaceRest.class);

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "/place")
    @PreAuthorize(value = "hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<List<Place>> getAllPlaces(){
        List<Place> places = placeService.findAllPlaces();
        return Optional.ofNullable(places)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/place",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Place> savePlace(@RequestBody Place place){
        log.info("POST new Place " +place.toString());
        return Optional.ofNullable(placeService.savePlace(place))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @RequestMapping(value = "/place/{city}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<Place>> getPlaceFromCity(@PathVariable(value = "city") String city){
        log.info("POST new Place " + city);

        return Optional.ofNullable(placeService.findAllPlaceLikeCity(city))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
