package com.cric.scorer.DTOs.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchInfo {
    private long matchId;
    private String teamA;
    private String teamB;
    private int overs;
    private String umpires;
    private String tossWon;
    private String tossSelection;
    private String wonBy;
    private String result;
    private String manOfTheMatch;
    private String status;

}
