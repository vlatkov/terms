package com.terms.DTO;


import com.terms.domen.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDTO {

    private City city;
    private List<RegionDTO> regionsDtos;

    public CityDTO(City city, List<RegionDTO> regionsDtos){
        this.city = city;
        this.regionsDtos = regionsDtos;
    }

    public CityDTO(City city){
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public List<RegionDTO> getRegionsDtos() {
        return regionsDtos;
    }

    public CityDTO(){
        super();
    }


}
