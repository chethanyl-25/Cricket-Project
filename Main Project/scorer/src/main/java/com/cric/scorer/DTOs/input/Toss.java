package com.cric.scorer.DTOs.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Toss {
    private String tossWon;
    private String tossSelection;
    private String umpires;
}
