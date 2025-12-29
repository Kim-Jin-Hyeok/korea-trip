package com.trip.korea_trip.spot.service;

import com.trip.korea_trip.spot.Spot;
import com.trip.korea_trip.spot.dto.request.SpotCreateReuqest;
import com.trip.korea_trip.spot.dto.response.SpotResponse;
import com.trip.korea_trip.spot.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {
    private final SpotRepository spotRepository;

    @Transactional
    public SpotResponse createSpot(SpotCreateReuqest request) {
        Spot spot = new Spot(
                request.getName(),
                request.getRegion(),
                request.getCategory(),
                request.getAddress(),
                null,
                null,
                request.getDescription()
        );

        Spot saved = spotRepository.save(spot);

        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<SpotResponse> getSpots(String region) {
        List<Spot> spots = (region == null || region.isBlank()) ? spotRepository.findAll() : spotRepository.findByRegion(region);

        return spots.stream().map(this::toResponse).toList();
    }

    private SpotResponse toResponse(Spot spot) {
        return SpotResponse.builder()
                .id(spot.getId())
                .name(spot.getName())
                .region(spot.getRegion())
                .category(spot.getCategory())
                .address(spot.getAddress())
                .description(spot.getDescription())
                .build();
    }
}
