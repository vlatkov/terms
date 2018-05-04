package com.terms.DTO;


import com.terms.domen.Region;

import java.util.List;

public class RegionDTO {

    private Region region;
    private List<PlaygroundDTO> playgroundsDtos;

    public RegionDTO(){}

    public RegionDTO(Region region, List<PlaygroundDTO> playgroundsDtos){
        this.region = region;
        this.playgroundsDtos = playgroundsDtos;
    }

    public RegionDTO(Region region){
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public List<PlaygroundDTO> getPlaygroundsDtos() {
        return playgroundsDtos;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setPlaygroundsDtos(List<PlaygroundDTO> playgroundsDtos) {
        this.playgroundsDtos = playgroundsDtos;
    }
}
