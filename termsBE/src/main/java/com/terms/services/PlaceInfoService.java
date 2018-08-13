package com.terms.services;

import com.terms.domen.PlaceInfo;
import com.terms.repository.PlaceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaceInfoService {

    @Autowired
    PlaceInfoRepository placeInfoRepository;

    /*
    * @param placeInfo object for save
    * */
    public PlaceInfo save(PlaceInfo placeInfo)
    {
        return placeInfoRepository.save(placeInfo);
    }

    /*
    * @param Id from placeinfo object
    * */
    public PlaceInfo findOne(Long id)
    {
        return placeInfoRepository.findOne(id);
    }

}
