package com.terms.DTO;


import com.terms.domen.Region;

import java.util.List;

public class RegionDTO {

    private Region region;
    private List<PlaceDTO> placeDTOS;

    public RegionDTO(){}

    public RegionDTO(Region region, List<PlaceDTO> placeDTOS){
        this.region = region;
        this.placeDTOS = placeDTOS;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<PlaceDTO> getPlaceDTOS() {
        return placeDTOS;
    }

    public void setPlaceDTOS(List<PlaceDTO> placeDTOS) {
        this.placeDTOS = placeDTOS;
    }
}
