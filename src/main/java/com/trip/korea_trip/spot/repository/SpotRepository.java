package com.trip.korea_trip.spot.repository;

import com.trip.korea_trip.spot.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findByRegion(String region);
}
