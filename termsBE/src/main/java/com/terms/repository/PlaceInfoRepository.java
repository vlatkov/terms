package com.terms.repository;

import com.terms.domen.PlaceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceInfoRepository extends JpaRepository<PlaceInfo, Long> {

    List<PlaceInfo> findByPlace(Long id);
}
