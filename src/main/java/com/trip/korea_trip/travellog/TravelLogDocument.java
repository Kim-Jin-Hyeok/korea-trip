package com.trip.korea_trip.travellog;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "travel_logs")
public class TravelLogDocument {

    @Id
    private String id;

    private Long userId;
    private Long tripPlanId; // 어떤 Trip에 대한 로그인지 (선택)

    private LocalDate date;  // 여행 날짜 (startDate + n일차 같은 느낌)

    private String title;
    private String content;          // 자유 텍스트
    private List<String> photoUrls;  // 사진 URL 리스트

    // 자유 형식 메타데이터 (기분, 날씨, 이동수단 등)
    private Map<String, Object> metadata;

    private LocalDateTime createdAt;

    protected TravelLogDocument() {
    }

    public TravelLogDocument(Long userId, Long tripPlanId,
                             LocalDate date, String title, String content,
                             List<String> photoUrls, Map<String, Object> metadata) {
        this.userId = userId;
        this.tripPlanId = tripPlanId;
        this.date = date;
        this.title = title;
        this.content = content;
        this.photoUrls = photoUrls;
        this.metadata = metadata;
        this.createdAt = LocalDateTime.now();
    }

    // getter들...
}
