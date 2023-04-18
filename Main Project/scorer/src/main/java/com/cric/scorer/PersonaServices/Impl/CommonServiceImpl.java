package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.DTOs.output.BatsmanScore;
import com.cric.scorer.DTOs.output.MatchInfo;
import com.cric.scorer.DTOs.output.WicketDetails;
import com.cric.scorer.EntityServices.*;
import com.cric.scorer.PersonaServices.CommonService;
import com.cric.scorer.entity.MatchDetails;
import com.cric.scorer.entity.Player;
import com.cric.scorer.entity.Team;
import com.cric.scorer.entity.Wicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private MatchDetailsService matchDetailsService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamSquadService teamSquadService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private WicketService wicketService;
    @Autowired
    private  ScoreDetailsService scoreDetailsService;
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
        matchInfo.setUmpires(matchDetails.getUmpires());
        matchInfo.setTossSelection(matchDetails.getTossSelection());
        matchInfo.setResult(matchDetails.getResult());
        return matchInfo;
    }

    @Override
    public List<Player> getSquad(long matchId, String teamName) {
        long teamId=this.teamService.findTeamIdByTeamNameAndMatchId(teamName,matchId);
        List<Long> playersSquad=this.teamSquadService.getSquad(teamId);
        List<Player> playerList =new ArrayList<>();
        for(Long playerId:playersSquad){
            Player player =this.playerService.findById(playerId);
            playerList.add(player);
        }
        if(playerList.size()>0)
            return playerList;
        else
            return null;
    }
    @Override
    public List<Player> getPlayin11(long matchId, String teamName) {
        long teamId=this.teamService.findTeamIdByTeamNameAndMatchId(teamName,matchId);
        List<Long> playersIdList=this.teamSquadService.getPlaying11(teamId);
        List<Player> playing11=new ArrayList<>();
        for(Long playerId:playersIdList)
        {
            Player player =this.playerService.findById(playerId);
            playing11.add(player);
        }
        return playing11;
    }

    @Override
    public Player getPlayerBasedOnRole(long matchId, String teamName, String role) {
        long teamId=this.teamService.findTeamIdByTeamNameAndMatchId(teamName,matchId);
        Player player =null;
        Team team=this.teamService.findById(teamId);
        if(role.equalsIgnoreCase("C"))
            player =team.getCaptainId();
        else if(role.equalsIgnoreCase("Wk"))
            player =team.getWicketKeeperId();
        else
            throw new HttpMessageNotReadableException("Bad Url");
        return player;
    }

    @Override
    public List<Player> getRemainingPlayers(long matchId, String teamName) {
        List<Long> wicketsFallen=this.wicketService.WicketsGone(matchId);
        long teamId=this.teamService.findTeamIdByTeamNameAndMatchId(teamName,matchId);
        List<Long> remainingPlayerId=this.teamSquadService.getPlaying11(teamId);
        List<Player> remainingPlayers=new ArrayList<>();
        Player player;
        for(long playerId:remainingPlayerId)
        {
            if(!wicketsFallen.contains(playerId))
            {
                player=this.playerService.findById(playerId);
                remainingPlayers.add(player);
            }
        }
       return remainingPlayers;
    }

    @Override
    public List<BatsmanScore> getBattingStatsOfTeam(long matchId, String teamName) {
        long teamId=this.teamService.findTeamIdByTeamNameAndMatchId(teamName,matchId);
        List<Long> playedBatsmenId=this.scoreDetailsService.getPlayedBatsmenId(matchId,teamId);
        List<BatsmanScore> battingStats=new ArrayList<>();
        for(Long playerId:playedBatsmenId)
        {
            BatsmanScore batsmanScore=this.getIndividualBatsmanScore(matchId,teamId,playerId);
            battingStats.add(batsmanScore);
            this.getWicketDetails(matchId,playerId);
        }
        return battingStats;
    }

    @Override
    public BatsmanScore getIndividualBatsmanScore(long matchId, long teamId, long playerId) {
        BatsmanScore batsmanScore=this.scoreDetailsService.getIndividualBatsmanScore(matchId,teamId,playerId);
        batsmanScore.setPlayerName(this.playerService.findById(playerId).getName());
        return batsmanScore;
    }

    @Override
    public WicketDetails getWicketDetails(long matchId, long playerId) {
        Wicket wicket=this.wicketService.findWicket(matchId,playerId);
        System.out.println(wicket);
        return null;
    }
}
