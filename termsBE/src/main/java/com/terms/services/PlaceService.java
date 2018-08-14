package com.terms.services;

import com.terms.DTO.PlaceDTO;
import com.terms.config.TokenCoder;
import com.terms.domen.Place;
import com.terms.domen.Region;
import com.terms.domen.RegistrationPlace;
import com.terms.repository.PlaceInfoRepository;
import com.terms.repository.PlaceRepository;
import com.terms.repository.RegistrationPlaceRepository;
import com.terms.services.interfaces.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PlaceService implements IPlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    PlaceInfoService placeInfoService;

    @Autowired
    UserServices userServices;

    @Autowired
    RegistrationPlaceRepository registrationPlaceRepository;

    public RegistrationPlace findOne(Long placeId) {

        RegistrationPlace registrationPlace = registrationPlaceRepository.findAllByPlace(placeId);
        registrationPlace.setPlace(placeRepository.findOne(placeId));
        return registrationPlace;
    }

    @Transactional
    public RegistrationPlace save(RegistrationPlace registrationPlace) {

        registrationPlace.getPlace().setPlaceInfo(placeInfoService.save(registrationPlace.getPlace().getPlaceInfo()));
        registrationPlace.setPlace(this.save(registrationPlace.getPlace()));
        registrationPlace.setUser(userServices.findOneByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        registrationPlace.setActivationKey(TokenCoder.encode(new Date().toString()));
        registrationPlace.setDateCreated(new Date());
        registrationPlace.setValidFrom(new Date());
        registrationPlace.setActive(false);
        return registrationPlaceRepository.save(registrationPlace);
    }

    public void delete(Place place) {
        placeRepository.delete(place);
    }

    public List<Place> findAllPlaceByRegion(Region region) {
        return placeRepository.findAllByRegion(region);
    }

    public List<Place> findAllPlaces() {
        return placeRepository.findAll();
    }

    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }

    public List<Place> findAllPlaceLikeCity(String name) {
        return placeRepository.findAllByLikeName(name);
    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }

}
