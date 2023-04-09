package com.cric.scorer.DTOs.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateScore {
    private String battingTeamName;
    private String bowlingTeamName;
    private long bowlerId;
    private long strikerId;
    private long nonStrikerId;
    private String event;
    private int overs;
    private int ballNo;
    private int runs;
    private WicketTaken wicketTaken;
}
