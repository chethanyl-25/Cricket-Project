package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.DTOs.input.Toss;
import com.cric.scorer.DTOs.input.UpdateResult;
import com.cric.scorer.DTOs.input.UpdateScore;
import com.cric.scorer.DTOs.input.WicketTaken;
import com.cric.scorer.EntityServices.*;
import com.cric.scorer.PersonaServices.CommonService;
import com.cric.scorer.PersonaServices.ScorerService;
import com.cric.scorer.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScorerServiceImpl implements ScorerService {
    @Autowired
    private MatchDetailsService matchDetailsService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamSquadService teamSquadService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ScoreDetailsService scoreDetailsService;
    @Autowired
    private WicketService wicketService;
    @Override
    public void selectPlaying11(long matchId, String teamName, List<Player> playerList) {
        long teamId=this.teamService.findByTeamNameAndMatch(teamName,matchId);
        Team team=this.teamService.findById(teamId);
        TeamSquad teamSquad=new TeamSquad();
        teamSquad.setTeam(team);
        teamSquad.setPlaying(true);
        for(Player player : playerList)
        {
            teamSquad.setPlayer(player);
            this.teamSquadService.save(teamSquad);
        }
    }
    @Override
    public void setCaptaionAndWicketKeeper(long matchId, String teamName, List<Player> playerList) {
        long teamId=this.teamService.findByTeamNameAndMatch(teamName,matchId);
        Team team=this.teamService.findById(teamId);
        Player captain= playerList.get(0);
        Player wicketKeeper= playerList.get(1);
        team.setCaptainId(captain);
        team.setWicketKeeperId(wicketKeeper);
        this.teamService.save(team);
    }
    @Override
    public void updateTossAndUmpire(long matchId, Toss toss) {
        long teamId=this.teamService.findByTeamNameAndMatch(toss.getTossWon(),matchId);
        Team team=this.teamService.findById(teamId);
        MatchDetails matchDetails=this.matchDetailsService.findById(matchId);
        matchDetails.setTossWon(team);
        matchDetails.setTossSelection(toss.getTossSelection());
        matchDetails.setUmpires(toss.getUmpires());
        matchDetails.setStatus("ongoing");
        this.matchDetailsService.save(matchDetails);
    }

    @Override
    public void updateScore(long matchId, UpdateScore updateScore) {
        Wicket wicket=null;
        ScoreDetails scoreDetails=new ScoreDetails();
        scoreDetails.setEvent(updateScore.getEvent());
        scoreDetails.setOvers(updateScore.getOvers());
        scoreDetails.setRuns(updateScore.getRuns());
        scoreDetails.setBallNo(updateScore.getBallNo());
        long bowlingTeamId=this.teamService.findByTeamNameAndMatch(updateScore.getBowlingTeamName(), matchId);
        long battingTeamId=this.teamService.findByTeamNameAndMatch(updateScore.getBattingTeamName(), matchId);
        Team battingTeam=this.teamService.findById(battingTeamId);
        Team bowlingTeam=this.teamService.findById(bowlingTeamId);
        Player striker=this.playerService.findById(updateScore.getStrikerId());
        Player nonStriker=this.playerService.findById(updateScore.getNonStrikerId());
        Player bowler=this.playerService.findById(updateScore.getBowlerId());
        MatchDetails matchDetails=this.matchDetailsService.findById(matchId);
        scoreDetails.setBowler(bowler);
        scoreDetails.setStriker(striker);
        scoreDetails.setNonStriker(nonStriker);
        scoreDetails.setBattingTeam(battingTeam);
        scoreDetails.setBowlingTeam(bowlingTeam);
        scoreDetails.setMatch(matchDetails);
        if(updateScore.getWicketTaken()!=null)
        {
            WicketTaken wicketTaken=updateScore.getWicketTaken();
            wicket=new Wicket();
            Player batsman=this.playerService.findById(wicketTaken.getBatsmanId());
            Player takenBy=this.playerService.findById(wicketTaken.getTakenBy());
            wicket.setWicketType(wicketTaken.getWicketType());
            wicket.setBlower(bowler);
            wicket.setBatsman(batsman);
            wicket.setTakenBy(takenBy);
            wicket.setMatchDetails(matchDetails);
            wicket=this.wicketService.save(wicket);
        }
        scoreDetails.setWicket(wicket);
        this.scoreDetailsService.save(scoreDetails);
    }

    @Override
    public void updateResult(long matchId, UpdateResult updateResult) {
        MatchDetails matchDetails=this.matchDetailsService.findById(matchId);
        long wonTeamId=this.teamService.findTeamIdByTeamNameAndMatchId(updateResult.getTeamWon(), matchId);
        Team wonTeam=this.teamService.findById(wonTeamId);
        Player manOfTheMatch=this.playerService.findById(updateResult.getManOfTheMatch());
        matchDetails.setWonBy(wonTeam);
        matchDetails.setManOfTheMatch(manOfTheMatch);
        matchDetails.setResult(updateResult.getResult());
        matchDetails.setStatus("Completed");
        this.matchDetailsService.save(matchDetails);
    }
}
