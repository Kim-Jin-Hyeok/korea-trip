package com.trip.korea_trip.spot.service;

import com.trip.korea_trip.spot.Spot;
import com.trip.korea_trip.spot.dto.request.SpotUpdateRequest;
import com.trip.korea_trip.spot.dto.response.SpotResponse;
import com.trip.korea_trip.spot.exception.SpotNotFoundException;
import com.trip.korea_trip.spot.repository.SpotRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class SpotServiceTest {
    @Mock
    SpotRepository spotRepository;

    @InjectMocks
    SpotService spotService;

    @Test
    @DisplayName("updateSpot - 정상케이스: 기존 Spot을 찾아서 필드를 업데이트한다")
    void updateSpot_success() {
        // given
        Long id = 1L;
        Spot spot = new Spot(
                "기존 이름",
                "기존 지역",
                "OLD_CAT",
                "기존 주소",
                null,
                null,
                "기존 설명"
        );

        given(spotRepository.findById(id)).willReturn(Optional.of(spot));

        SpotUpdateRequest request = new SpotUpdateRequest(
                "새 이름",
                "새 지역",
                "NEW_CAT",
                "새 주소",
                "새 설명"
        );

        // when
        SpotResponse response = spotService.updateSpot(id, request);

        // then
        // 응답 값 검증
        assertThat(response.getId()).isEqualTo(spot.getId());
        assertThat(response.getName()).isEqualTo("새 이름");
        assertThat(response.getRegion()).isEqualTo("새 지역");
        assertThat(response.getCategory()).isEqualTo("NEW_CAT");
        assertThat(response.getAddress()).isEqualTo("새 주소");
        assertThat(response.getDescription()).isEqualTo("새 설명");

        // 엔티티 상태가 실제로 바뀌었는지도 검증 (변경감지 기준)
        assertThat(spot.getName()).isEqualTo("새 이름");
        assertThat(spot.getRegion()).isEqualTo("새 지역");
    }

    @Test
    @DisplayName("updateSpot - 대상 Spot이 없으면 SpotNotFoundException을 던진다")
    void updateSpot_notFound() {
        // given
        Long id = 999L;
        given(spotRepository.findById(id)).willReturn(Optional.empty());

        SpotUpdateRequest request = new SpotUpdateRequest(
                "이름",
                "지역",
                "CAT",
                "주소",
                "설명"
        );

        // when & then
        assertThrows(SpotNotFoundException.class, () -> spotService.updateSpot(id, request));

        // 찾지 못하면 그 이후 동작은 없어야 함
        verify(spotRepository).findById(id);
        verify(spotRepository, never()).save(org.mockito.Mockito.any());
    }
}
