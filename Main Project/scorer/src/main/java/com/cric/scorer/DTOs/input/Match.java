package com.cric.scorer.DTOs.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {
    private String teamA;
    private String teamB;
    private int overs;
}
