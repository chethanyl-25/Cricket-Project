package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.DTOs.output.ScoreSummary;
import com.cric.scorer.EntityServices.*;
import com.cric.scorer.PersonaServices.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Formatter;

@Service
public class ViewerServiceImpl implements ViewerService {
    @Autowired
    private ScoreDetailsService scoreDetailsService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchDetailsService matchDetailsService;
    @Autowired
    private WicketService wicketService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamSquadService teamSquadService;

    @Override
    public ScoreSummary getScoreSummary(long matchId, String teamName) {
        long teamId=this.teamService.findTeamIdByTeamNameAndMatchId(teamName,matchId);
        int totalRuns=this.scoreDetailsService.getTotalRunsScoredByTeam(matchId,teamId);
        int totalWickets=this.scoreDetailsService.getTotalWicketsOfTeam(matchId,teamId);
        int extras=this.scoreDetailsService.getExtrasOfTeam(matchId,teamId);
        int currentOver=this.scoreDetailsService.getCurrentOver(matchId,teamId);
        int currentBallNo=this.scoreDetailsService.getCurrentBallNo(matchId,teamId,currentOver);
        ScoreSummary scoreSummary=new ScoreSummary();
        scoreSummary.setTeamName(teamName);
        scoreSummary.setExtras(extras);
        scoreSummary.setTotalRuns(totalRuns+extras);
        scoreSummary.setTotalWickets(totalWickets);
        scoreSummary.setCurrentOver(currentOver);
        scoreSummary.setCurrentBallNo(currentBallNo);
        double ballValue=  ((float) currentBallNo/(6.0));
        double currentRunRate=((float)totalRuns/(float)(currentOver+ballValue));
        BigDecimal currentRunRateBigDecimal=new BigDecimal(currentRunRate).setScale(2, RoundingMode.HALF_DOWN);
        scoreSummary.setCurrentRunRate(currentRunRateBigDecimal.doubleValue());
        return scoreSummary;
    }
}
