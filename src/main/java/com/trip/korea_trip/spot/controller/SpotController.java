package com.trip.korea_trip.spot.controller;

import com.trip.korea_trip.spot.dto.request.SpotCreateReuqest;
import com.trip.korea_trip.spot.dto.response.SpotResponse;
import com.trip.korea_trip.spot.service.SpotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spots")
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

    @PostMapping
    public SpotResponse createSpot(@Valid @RequestBody SpotCreateReuqest request) {
        return spotService.createSpot(request);
    }

    @GetMapping
    public List<SpotResponse> getSpots(@RequestParam(required = false) String region) {
        return spotService.getSpots(region);
    }
}
