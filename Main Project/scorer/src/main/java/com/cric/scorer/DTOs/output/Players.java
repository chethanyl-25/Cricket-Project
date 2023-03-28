package com.cric.scorer.DTOs.output;

import com.cric.scorer.entity.TeamSquad;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Players {
    private Long playerId;
    private String name;
    private String nationality;
    private String role;
    private String battingStyle;
    private String bowlingStyle;
}
