package com.cric.scorer.DTOs.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreSummary {
    private String teamName;
    private int totalRuns;
    private int totalWickets;
    private int extras;
    private int currentOver;
    private int currentBallNo;
    private double currentRunRate;
}
