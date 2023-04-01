package com.cric.scorer.DTOs.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMatch {
    private long matchId;
    private String teamA;
    private String teamB;
    private int overs;
}
