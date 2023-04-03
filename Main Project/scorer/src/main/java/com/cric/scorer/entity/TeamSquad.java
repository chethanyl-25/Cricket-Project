package com.cric.scorer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(TeamSquadId.class)
public class TeamSquad {

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "team_id",referencedColumnName = "teamID")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id",referencedColumnName = "playerId")
    private Player player;

    @Column(columnDefinition = "boolean default false")
    private boolean isPlaying;
}
