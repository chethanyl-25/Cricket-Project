package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.DTOs.output.MatchInfo;
import com.cric.scorer.EntityServices.MatchDetailsService;
import com.cric.scorer.PersonaServices.GeneralServices;
import com.cric.scorer.Repository.MatchDetailsRepo;
import com.cric.scorer.Repository.PlayerRepo;
import com.cric.scorer.Repository.TeamRepo;
import com.cric.scorer.Repository.TeamSquadRepo;
import com.cric.scorer.entity.MatchDetails;
import com.cric.scorer.entity.Player;
import com.cric.scorer.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralServicesImpl implements GeneralServices {
    @Autowired
    private MatchDetailsService matchDetailsService;
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private TeamSquadRepo teamSquadRepo;
    @Autowired
    private PlayerRepo playerRepo;
    @Override
    public MatchInfo getMatchDetails(long id) {

        MatchDetails matchDetails=this.matchDetailsService.findById(id);
        if (matchDetails==null)
            return null;
        MatchInfo matchInfo=new MatchInfo();
        matchInfo.setMatchId(matchDetails.getMatchId());
        matchInfo.setOvers(matchDetails.getOvers());
        matchInfo.setTeamA(matchDetails.getTeamA().getTeamName());
        matchInfo.setTeamB(matchDetails.getTeamB().getTeamName());
        if(matchDetails.getTossWon()!=null)
            matchInfo.setTossWon(matchDetails.getTossWon().getTeamName());
        if (matchDetails.getManOfTheMatch()!=null)
            matchInfo.setManOfTheMatch(matchDetails.getManOfTheMatch().getName());
        if(matchDetails.getWonBy()!=null)
            matchInfo.setWonBy(matchDetails.getWonBy().getTeamName());
        matchInfo.setStatus(matchDetails.getStatus());
        return matchInfo;
    }

    @Override
    public List<Player> getSquad(long matchId, String teamName) {
        long teamId=this.teamRepo.findByTeamNameAndMatch(teamName,matchId);
        List<Long> playersSquad=this.teamSquadRepo.getSquad(teamId);
        List<Player> playerList=new ArrayList<>();
        for(Long playerId:playersSquad){
            Player player=this.playerRepo.findById(playerId).get();
            playerList.add(player);
        }
        if(playerList.size()>0)
            return playerList;
        else
            return null;
    }
    @Override
    public List<Player> getPlayin11(long matchId, String teamName) {
        long teamId=this.teamRepo.findByTeamNameAndMatch(teamName,matchId);
        List<Long> playersIdList=this.teamSquadRepo.getPlaying11(teamId);
        List<Player> playing11=new ArrayList<>();
        for(Long playerId:playersIdList)
        {
            Player player=this.playerRepo.findById(playerId).get();
            playing11.add(player);
        }
        return playing11;
    }

    @Override
    public Player getPlayerBasedOnRole(long matchId, String teamName, String role) {
        long teamId=this.teamRepo.findByTeamNameAndMatch(teamName,matchId);
        Player player=null;
        Team team=this.teamRepo.findById(teamId).get();
        if(role.equalsIgnoreCase("C"))
            player=team.getCaptainId();
        else if(role.equalsIgnoreCase("Wk"))
            player=team.getWicketKeeperId();
        else
            throw new HttpMessageNotReadableException("Bad Url");
        return player;
    }
}
