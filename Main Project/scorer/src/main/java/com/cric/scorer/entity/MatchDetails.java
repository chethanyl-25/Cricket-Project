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
public class MatchDetails {
    @Id
    @SequenceGenerator(name = "match_seq",sequenceName = "match_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "match_seq",strategy = GenerationType.SEQUENCE)
    private long matchId;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "team_A",referencedColumnName = "teamId",nullable = true)
    private Team teamA;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "team_B",referencedColumnName = "teamId",nullable = true)
    private Team teamB;
    private int overs;
    private String umpires;
    @OneToOne
    @JoinColumn(name = "toss_won",referencedColumnName = "teamId")
    private Team tossWon;
    private String tossSelection;
    @OneToOne
    @JoinColumn(name = "won_by",referencedColumnName = "teamId")
    private Team wonBy;
    private String result;
    @OneToOne
    @JoinColumn(name="man_of_the_match",referencedColumnName = "playerId")
    private Player manOfTheMatch;
    @Column(columnDefinition = "varchar(20) default 'upcoming'")
    private String status;

    @Override
    public String toString() {
        return "MatchDetails{" +
                "matchId=" + matchId +
                ", teamA=" + teamA +
                ", teamB=" + teamB +
                ", overs=" + overs +
                ", umpires='" + umpires + '\'' +
                ", tossWon=" + tossWon +
                ", tossSelection='" + tossSelection + '\'' +
                ", wonBy=" + wonBy +
                ", result='" + result + '\'' +
                ", manOfTheMatch=" + manOfTheMatch +
                ", status='" + status + '\'' +
                '}';
    }
}
