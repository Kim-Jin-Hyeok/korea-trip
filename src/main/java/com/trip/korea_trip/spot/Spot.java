package com.trip.korea_trip.spot;

import jakarta.persistence.*;

/**
 * uk : name-region
 */
@Entity
@Table(name = "spots")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 예) 협재 해수욕장
    @Column(nullable = false, length = 100)
    private String name;

    // 예) 제주시, 서귀포시, 한림, 애월 등
    @Column(nullable = false, length = 50)
    private String region;

    // 예) BEACH, MOUNTAIN, CAFE, MUSEUM, PARK 등
    @Column(length = 50)
    private String category;

    @Column(length = 200)
    private String address;

    // 위도/경도 (필요 없으면 나중에 빼도 됨)
    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(length = 1000)
    private String description;

    protected Spot() {
    }

    public Spot(String name, String region, String category, String address,
                Double latitude, Double longitude, String description) {
        this.name = name;
        this.region = region;
        this.category = category;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getRegion() { return region; }
    public String getCategory() { return category; }
    public String getAddress() { return address; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getDescription() { return description; }

    public void update(String name, String region, String category, String address, String description) {
        this.name = name;
        this.region = region;
        this.category = category;
        this.address = address;
        this.description = description;
    }
}
