package com.terms.DTO;


import com.terms.domen.Place;
import com.terms.domen.PlaceInfo;
import com.terms.domen.Region;

import java.util.List;

public class PlaceDTO {

    private Place place;
    private Region region;
    private List<PlaceInfo> placeInfos;

    public PlaceDTO(){}

    public PlaceDTO(Place place, List<PlaceInfo> placeInfo) {
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
