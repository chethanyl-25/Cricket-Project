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
public class Wicket {
    @Id
    @SequenceGenerator(name = "wicket_seq",sequenceName = "wicket_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "wicket_seq",strategy = GenerationType.SEQUENCE)
    private long wicketId;
    @ManyToOne
    @JoinColumn(name = "bowler_id",referencedColumnName = "playerId")
    private Player blower;
    @ManyToOne
    @JoinColumn(name = "batsman_id",referencedColumnName = "playerId")
    private Player batsman;
    private String wicketType;
    @ManyToOne
    @JoinColumn(name = "taken_by",referencedColumnName = "playerId")
    private Player takenBy;
    @ManyToOne
    @JoinColumn(name = "match_id",referencedColumnName = "matchId")
    private MatchDetails matchDetails;
}
