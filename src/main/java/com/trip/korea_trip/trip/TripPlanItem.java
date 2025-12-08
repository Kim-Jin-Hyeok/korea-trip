package com.trip.korea_trip.trip;

import com.trip.korea_trip.spot.Spot;
import com.trip.korea_trip.place.Place;
import jakarta.persistence.*;

@Entity
@Table(name = "trip_plan_items")
public class TripPlanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어떤 날의 일정인지
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_day_id", nullable = false)
    private TripDay tripDay;

    // 하루 중 순서 (1: 아침, 2: 점심, 3: 오후, 4: 저녁...)
    @Column(nullable = false)
    private int itemOrder;

    // 방문할 Spot (관광지) - 없을 수도 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spot_id")
    private Spot spot;

    // 방문할 Place (숙소/식당/카페 등) - 없을 수도 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    // 메모 (예: 이동수단, 비용, 약속시간 등)
    @Column(length = 500)
    private String memo;

    protected TripPlanItem() {
    }

    public TripPlanItem(int itemOrder, Spot spot, Place place, String memo) {
        this.itemOrder = itemOrder;
        this.spot = spot;
        this.place = place;
        this.memo = memo;
    }

    void setTripDay(TripDay tripDay) {
        this.tripDay = tripDay;
    }

    public Long getId() { return id; }
    public TripDay getTripDay() { return tripDay; }
    public int getItemOrder() { return itemOrder; }
    public Spot getSpot() { return spot; }
    public Place getPlace() { return place; }
    public String getMemo() { return memo; }
}
