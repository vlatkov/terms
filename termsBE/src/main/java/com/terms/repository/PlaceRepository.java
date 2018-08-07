package com.terms.repository;

import com.terms.domen.Place;
import com.terms.domen.Place;
import com.terms.domen.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByRegion(Region region);

}
