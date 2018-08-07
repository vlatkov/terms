package com.terms.resource;


import com.google.gson.GsonBuilder;
import com.terms.domen.Place;
import com.terms.domen.Region;
import com.terms.domen.SubCategory;
import com.terms.repository.PlaceRepository;

import com.terms.repository.RegionRepository;
import com.terms.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "${api.path}",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaceRest {

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "/place")
    public List<Place> getAllPlaces(){

        List<Place> places = placeService.findAll();
        Region region = new Region();
        region.setId(places.get(0).getRegion().getId());
        region.setCity(places.get(0).getRegion().getCity());

        Place place = places.get(0);
        place.setRegion(regionRepository.findOne(places.get(0).getRegion().getId()));

        place.setRegion(region);
        Long subCategory = place.getSubCategory().getId();
        return places;

    }

    @RequestMapping(value = "/region")
    public List<Region> getAllRegions(){

    return regionRepository.findAll();
    }
}
