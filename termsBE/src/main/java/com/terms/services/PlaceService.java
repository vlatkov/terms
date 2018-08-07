package com.terms.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.terms.DTO.PlaceDTO;
import com.terms.domen.Place;
import com.terms.domen.Region;
import com.terms.repository.PlaceInfoRepository;
import com.terms.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaceService {

    private PlaceInfoRepository placeInfoRepository;
    private PlaceRepository placeRepository;
    //const DI
    public PlaceService(PlaceRepository placeRepository, PlaceInfoRepository placeInfoRepository)
    {
        this.placeInfoRepository = placeInfoRepository;
        this.placeRepository = placeRepository;

    }

    public PlaceDTO findOne(Long placeId){
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setPlaceInfos(placeInfoRepository.findByPlace(placeId));
        placeDTO.setPlace(placeRepository.findOne(placeId));

        return placeDTO;
    }

    public void delete(Place place){
        placeRepository.delete(place);
    }

    public List<Place> findAllPlaceByRegion(Region region){
            return placeRepository.findAllByRegion(region);
    }

    public List<Place> findAll(){
        return placeRepository.findAll();
    }
}
