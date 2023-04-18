package com.cric.scorer.DTOs.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WicketDetails {
    private String bowler;
    public String wicketType;
    public String takenBy;
}
