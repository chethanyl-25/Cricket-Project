package com.cric.scorer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    @Id
    @SequenceGenerator(name = "team_seq",sequenceName = "team_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "team_seq")
    private long teamId;
    private String teamName;

    @OneToOne
    @JoinColumn(name = "captain_id",referencedColumnName = "playerId")
    private Player captainId;

    @OneToOne
    @JoinColumn(name="wicket_keeper_id",referencedColumnName = "playerId")
    private Player wicketKeeperId;

    @OneToOne
    @JoinColumn(name = "match_id",referencedColumnName = "matchId")
    private MatchDetails match;

    @OneToMany(mappedBy = "team")
    private List<TeamSquad> teamSquadList;
}
