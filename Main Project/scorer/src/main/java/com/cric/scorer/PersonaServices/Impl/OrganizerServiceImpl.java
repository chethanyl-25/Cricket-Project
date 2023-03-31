package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.DTOs.input.Match;
import com.cric.scorer.DTOs.output.MatchCreated;
import com.cric.scorer.EntityServices.MatchDetailsService;
import com.cric.scorer.EntityServices.PlayerService;
import com.cric.scorer.EntityServices.TeamService;
import com.cric.scorer.PersonaServices.OrganizerService;
import com.cric.scorer.entity.MatchDetails;
import com.cric.scorer.entity.Player;
import com.cric.scorer.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private MatchDetailsService matchDetailsService;
    @Override
    public Player savePlayer(Player player) {
        return this.playerService.save(player);
    }

    @Override
    public List<Player> findByNameContaining(String name) {
        List<Player> playerList=this.playerService.findByNameContaining(name);
        System.out.println();
        if(playerList.size()>0)
            return playerList;
        else
            return null;
    }

    @Override
    public MatchCreated createMatch(Match match) {
        Team teamA=Team.builder()
                .teamName(match.getTeamA())
                .build();
        Team teamB=Team.builder()
                .teamName(match.getTeamB())
                .build();
        teamA=this.teamService.save(teamA);
        teamB=this.teamService.save(teamB);
        MatchDetails matchDetails=MatchDetails.builder()
                .teamA(teamA)
                .teamB(teamB)
                .overs(match.getOvers())
                .build();
        matchDetails=this.matchDetailsService.save(matchDetails);
        MatchCreated matchCreated=MatchCreated.builder()
                .matchId(matchDetails.getMatchId())
                .teamA(teamA.getTeamName())
                .teamB(teamB.getTeamName())
                .build();
        return matchCreated;
    }

    @Override
    public Player updatePlayer(Player player) {
        boolean updated=this.playerService.updatePlayer(player);
        if(updated)
            return player;
        else
            return null;
    }

    @Override
    public boolean deletePlayer(long id) {
        Player player=this.playerService.findById(id);
        if(player!=null){
            this.playerService.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteMatch(long id) {
        return this.matchDetailsService.deleteById(id);
    }
}
