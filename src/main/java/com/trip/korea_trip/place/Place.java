package com.trip.korea_trip.place;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Place {

    public enum PlaceType {
        ACCOMMODATION, // 숙소
        RESTAURANT,    // 식당
        CAFE,
        ETC
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 예) "OO 호텔", "OO 횟집"
    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PlaceType type;

    @Column(nullable = false, length = 50)
    private String region;

    @Column(length = 200)
    private String address;

    @Column(length = 30)
    private String phone;

    // 1박 최소 가격, 1인 예상 가격 같은 용도
    @Column
    private Integer averagePrice;

    @Column(length = 1000)
    private String description;

    protected Place() {
    }

    public Place(String name, PlaceType type, String region,
                 String address, String phone, Integer averagePrice, String description) {
        this.name = name;
        this.type = type;
        this.region = region;
        this.address = address;
        this.phone = phone;
        this.averagePrice = averagePrice;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public PlaceType getType() { return type; }
    public String getRegion() { return region; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public Integer getAveragePrice() { return averagePrice; }
    public String getDescription() { return description; }
}
