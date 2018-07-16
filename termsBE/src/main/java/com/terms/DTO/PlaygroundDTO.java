package com.terms.DTO;


import com.terms.domen.Place;
import com.terms.domen.PlaceInfo;

import java.util.List;

public class PlaygroundDTO {

    private Place place;
    private List<PlaceInfo> placeInfos;

    public PlaygroundDTO(){}

    public PlaygroundDTO(Place place, List<PlaceInfo> placeInfo) {
        this.place = place;
        this.placeInfos = placeInfo;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<PlaceInfo> getPlaceInfos() {
        return placeInfos;
    }

    public void setPlaceInfos(List<PlaceInfo> placeInfos) {
        this.placeInfos = placeInfos;
    }
}
