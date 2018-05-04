package com.terms.resource;

import com.terms.services.CountryServices;
import org.hyalinedto.exception.HyalineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${api.path}/country")
public class CountryRest {

    @Autowired
    CountryServices countryServices;

    @RequestMapping(value = "/{countryId}/cities",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object findAllCitiesByCountry(@PathVariable Long countryId) throws HyalineException {

        return countryServices.findAllCitiesByCountry(countryId);

    }

}
