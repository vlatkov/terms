package com.terms.resource;

import com.terms.services.PlaygroundService;
import com.terms.services.RegionServices;
import org.hyalinedto.exception.HyalineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "${api.path}")
@Transactional
public class RegionRest {

    private final Logger log = LoggerFactory.getLogger(RegionRest.class);

    @Autowired
    RegionServices regionServices;

    @Autowired
    PlaygroundService playgroundService;

    @RequestMapping(value = "/region/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> findAllUser(@PathVariable Long id){
        log.info("GET region api with ID =  ", id);
        return regionServices.findOneMappedRegion(id);
    }

    @RequestMapping(value = "/region/{regionId}/playgrounds",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object allPlaygroundsFromRegion(@PathVariable Long regionId) throws HyalineException {
        log.info("GET playgrounds for region ID =  ", regionId );
        return regionServices.getPlaygroundsFromRegion(regionId);
    }
}
