package com.cric.scorer.DTOs.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreviousBallsByBatsmen implements BallsPlayed {
    int runs;
    Long ballId;
}
