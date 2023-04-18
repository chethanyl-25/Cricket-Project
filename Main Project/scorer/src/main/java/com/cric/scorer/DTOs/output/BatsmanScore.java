package com.cric.scorer.DTOs.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatsmanScore {
    private String playerName;
    private int runsScored;
    private int ballsFaced;
    private int fours;
    private int sixes;
    private double strikeRate;
    private WicketDetails wicketDetails;
}
