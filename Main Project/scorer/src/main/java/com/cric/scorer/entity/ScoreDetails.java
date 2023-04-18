package com.cric.scorer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreDetails {
    @Id
    @SequenceGenerator(name = "Score_details_seq",sequenceName = "Score_details_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Score_details_seq")
    private long ballId;
    @ManyToOne
    @JoinColumn(name = "match_id",referencedColumnName = "matchId")
    private MatchDetails match;
    @ManyToOne
    @JoinColumn(name="bowling_team_id",referencedColumnName = "teamId")
    private Team bowlingTeam;
    @ManyToOne
    @JoinColumn(name="batting_team_id",referencedColumnName = "teamId")
    private Team battingTeam;
    @ManyToOne
    @JoinColumn(name="bowler_id",referencedColumnName = "playerId")
    private Player bowler;
    @ManyToOne
    @JoinColumn(name="striker_id",referencedColumnName = "playerId")
    private Player striker;
    @ManyToOne
    @JoinColumn(name="Non_striker_id",referencedColumnName = "playerId")
    private Player nonStriker;
    private int runs;
    private String event;
    private int overs;
    private int ballNo;
    @OneToOne
    @JoinColumn(name = "wicket_id",referencedColumnName = "wicketId")
    private Wicket wicket;

    @Column
    @CreationTimestamp
    private Timestamp creationTime;
}
