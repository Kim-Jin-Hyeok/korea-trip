package com.trip.korea_trip.trip;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip_days")
public class TripDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 부모 계획
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_plan_id", nullable = false)
    private TripPlan tripPlan;

    // 1일차, 2일차 등
    @Column(nullable = false)
    private int dayOrder;

    // 실제 날짜 (startDate + dayOrder - 1)
    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "tripDay", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("itemOrder ASC")
    private List<TripPlanItem> items = new ArrayList<>();

    protected TripDay() {
    }

    public TripDay(int dayOrder, LocalDate date) {
        this.dayOrder = dayOrder;
        this.date = date;
    }

    void setTripPlan(TripPlan tripPlan) {
        this.tripPlan = tripPlan;
    }

    public void addItem(TripPlanItem item) {
        this.items.add(item);
        item.setTripDay(this);
    }

    public Long getId() { return id; }
    public TripPlan getTripPlan() { return tripPlan; }
    public int getDayOrder() { return dayOrder; }
    public LocalDate getDate() { return date; }
    public List<TripPlanItem> getItems() { return items; }
}
