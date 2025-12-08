package com.trip.korea_trip.review;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "reviews")
public class ReviewDocument {

    public enum TargetType {
        SPOT,
        PLACE
    }

    @Id
    private String id;

    private Long userId;
    private TargetType targetType;
    private Long targetId; // Spot.id 또는 Place.id

    private int rating; // 1 ~ 5
    private String content;
    private List<String> photoUrls;

    private LocalDateTime createdAt;

    protected ReviewDocument() {
    }

    public ReviewDocument(Long userId, TargetType targetType, Long targetId,
                          int rating, String content, List<String> photoUrls) {
        this.userId = userId;
        this.targetType = targetType;
        this.targetId = targetId;
        this.rating = rating;
        this.content = content;
        this.photoUrls = photoUrls;
        this.createdAt = LocalDateTime.now();
    }

    // getter들...
}
