package com.trip.korea_trip.spot.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpotUpdateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String region;
    private String category;
    private String address;
    private String description;
}
