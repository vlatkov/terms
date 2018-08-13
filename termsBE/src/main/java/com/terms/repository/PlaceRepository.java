package com.terms.repository;

import com.terms.domen.Place;
import com.terms.domen.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByRegion(Region region);

    @Query(value = "select place from Place place " +
            "join fetch place.region region " +
            "join fetch region.city city " +
            "where city.name like CONCAT(?1, '%')")
    List<Place> findAllByLikeName(@Param("name") String name);


}
