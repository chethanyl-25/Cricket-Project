package com.cric.scorer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "teamSquadList")
public class Player {
    @Id
    @SequenceGenerator(name = "player_seq",sequenceName = "player_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "player_seq")
    private Long playerId;
    private String name;
    private String nationality;
    private String role;
    private String battingStyle;
    private String bowlingStyle;

//    @OneToMany(mappedBy = "player",fetch = FetchType.LAZY)
//    private List<TeamSquad> teamSquadList;
}
