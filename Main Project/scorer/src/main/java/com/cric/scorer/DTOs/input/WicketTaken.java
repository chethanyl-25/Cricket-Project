package com.cric.scorer.DTOs.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WicketTaken {
    private String wicketType;
    private long batsmanId;
    private long takenBy;
}
