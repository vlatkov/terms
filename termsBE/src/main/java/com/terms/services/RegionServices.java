package com.terms.services;

import com.terms.domen.Place;
import com.terms.domen.Region;
import com.terms.repository.RegionRepository;
import org.hyalinedto.api.DTO;
import org.hyalinedto.api.Hyaline;
import org.hyalinedto.exception.HyalineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegionServices {

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    PlaceService placeService;
    @Autowired
    RegionServices regionServices;

    private Map<String, Object> attributes = new HashMap<>();

    /*public RegionServices(RegionRepository regionRepository, PlaygroundService playgroundService, RegionServices regionServices){
        this.regionRepository = regionRepository;
        this.playgroundService = playgroundService;
        this.regionServices = regionServices;
    }*/

    /*
        @Test komentar
    */
    public Map<String, Object> findOneMappedRegion(Long regionId) {

        try {

            Region region = regionRepository.findOne(regionId);
            List<Place> places = placeService.findAllPlaceByRegion(region);
            attributes.put("region",region);
            attributes.put("place", places);

        } catch (Exception e){
            return new HashMap<String, Object>(){{put("error",e.getMessage());}};
        }

        return attributes;
    }

    /*
        @Test komentar
    */
    public Object getPlaceFromRegion(Long regionId) throws HyalineException {
        return Hyaline.dtoFromScratch(new DTO() {

            private Region region = regionServices.findOne(regionId);
            private List<Place> places = placeService.findAllPlaceByRegion(region);

        });
    }

    /*
    @Test komentar
    */
    public List<Region> allRegion(){
        return regionRepository.findAll();
    }

    /*
      @Test komentar
    */
    public Region findOne(Long Id){
        return regionRepository.findOne(Id);
    }
}
