package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.PersonaServices.GeneralServices;
import com.cric.scorer.PersonaServices.ScorerService;
import com.cric.scorer.Repository.MatchDetailsRepo;
import com.cric.scorer.Repository.PlayerRepo;
import com.cric.scorer.Repository.TeamRepo;
import com.cric.scorer.Repository.TeamSquadRepo;
import com.cric.scorer.entity.MatchDetails;
import com.cric.scorer.entity.Player;
import com.cric.scorer.entity.Team;
import com.cric.scorer.entity.TeamSquad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScorerServiceImpl implements ScorerService {
    @Autowired
    private MatchDetailsRepo matchDetailsRepo;
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private TeamSquadRepo teamSquadRepo;
    @Autowired
    private GeneralServices generalServices;
    @Override
    public void selectPlaying11(long matchId, String teamName, List<Player> playerList) {
        long teamId=this.teamRepo.findByTeamNameAndMatch(teamName,matchId);
        Team team=this.teamRepo.findById(teamId).get();
        TeamSquad teamSquad=new TeamSquad();
        teamSquad.setTeam(team);
        teamSquad.setPlaying(true);
        for(Player player:playerList)
        {
            teamSquad.setPlayer(player);
            this.teamSquadRepo.save(teamSquad);
        }
    }

    @Override
    public void setCaptaionAndWicketKeeper(long matchId, String teamName, List<Player> playerList) {
        long teamId=this.teamRepo.findByTeamNameAndMatch(teamName,matchId);
        Team team=this.teamRepo.findById(teamId).get();
        Player captain=playerList.get(0);
        Player wicketKeeper=playerList.get(1);
        team.setCaptainId(captain);
        team.setWicketKeeperId(wicketKeeper);
        this.teamRepo.save(team);
    }
}
