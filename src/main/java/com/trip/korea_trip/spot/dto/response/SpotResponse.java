package com.trip.korea_trip.spot.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpotResponse {
    private final Long id;
    private final String name;
    private final String region;
    private final String category;
    private final String address;
    private final String description;
}
