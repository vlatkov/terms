package com.terms.repository;

import com.terms.domen.Playground;
import com.terms.domen.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaygroundRepository extends JpaRepository<Playground, Long> {

    List<Playground> findAllByRegion(Region region);

}
