package com.terms.DTO;


import com.terms.domen.*;
import org.springframework.security.core.context.SecurityContext;

import java.util.List;

public class PlaceDTO {

    private Place place;
    private PlaceInfo placeInfo;
    private RegistrationPlace registrationPlace;


    public PlaceDTO(){}

    public PlaceDTO(Place place, PlaceInfo placeInfo, RegistrationPlace registrationPlace) {
        this.place = place;
        this.placeInfo = placeInfo;
        this.registrationPlace = registrationPlace;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public PlaceInfo getPlaceInfo() {
        return placeInfo;
    }

    public void setPlaceInfo(PlaceInfo placeInfo) {
        this.placeInfo = placeInfo;
    }

    public RegistrationPlace getRegistrationPlace() {
        return registrationPlace;
    }

    public void setRegistrationPlace(RegistrationPlace registrationPlace) {
        this.registrationPlace = registrationPlace;
    }
}
