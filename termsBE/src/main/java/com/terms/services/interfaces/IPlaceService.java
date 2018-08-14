package com.terms.services.interfaces;

import com.terms.domen.Place;
import com.terms.domen.Region;
import com.terms.domen.RegistrationPlace;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPlaceService {

    RegistrationPlace save(RegistrationPlace registrationPlace);

    void delete(Place place);

    List<Place> findAllPlaceByRegion(Region region);

    List<Place> findAllPlaces();

    Place savePlace(Place place);

    List<Place> findAllPlaceLikeCity(String name);

    Place save(Place place);
}
