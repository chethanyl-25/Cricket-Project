package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.DTOs.output.BallsPlayed;
import com.cric.scorer.DTOs.output.BatsmanScore;
import com.cric.scorer.EntityServices.ScoreDetailsService;
import com.cric.scorer.Repository.ScoreDetailsRepo;
import com.cric.scorer.entity.ScoreDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ScoreDetailsServiceImpl implements ScoreDetailsService {
    @Autowired
    private ScoreDetailsRepo scoreDetailsRepo;
    @Override
    public ScoreDetails save(ScoreDetails scoreDetails) {
        return this.scoreDetailsRepo.save(scoreDetails);
    }
    @Override
    public int getTotalRunsScoredByTeam(long matchId, long teamId) {
        return this.scoreDetailsRepo.getTotalRunsScoredByTeam(matchId,teamId);
    }
    @Override
    public int getTotalWicketsOfTeam(long matchId, long teamId) {
        return this.scoreDetailsRepo.getTotalWicketsOfTeam(matchId,teamId);
    }
    @Override
    public int getExtrasOfTeam(long matchId, long teamId) {
        return this.scoreDetailsRepo.getExtrasOfTeam(matchId,teamId);
    }
    @Override
    public int getCurrentOver(long matchId, long teamId) {
        return this.scoreDetailsRepo.getCurrentOver(matchId,teamId);
    }

    @Override
    public int getCurrentBallNo(long matchId, long teamId, int currentOver) {
        return this.scoreDetailsRepo.getCurrentBallNo(matchId,teamId,currentOver);
    }

    @Override
    public List<Long> getPlayedBatsmenId(long matchId, long teamId) {
        return this.scoreDetailsRepo.getPlayedBatsmenId(matchId,teamId);
    }

    @Override
    public BatsmanScore getIndividualBatsmanScore(long matchId, long teamId, long playerId) {
        List<BallsPlayed> ballsPlayed=this.scoreDetailsRepo.getBallDetailsByBatsmen(matchId,teamId,playerId);
        BatsmanScore batsmanScore=new BatsmanScore();
        batsmanScore.setRunsScored(0);
        batsmanScore.setSixes(0);
        batsmanScore.setFours(0);
        batsmanScore.setBallsFaced(ballsPlayed.size());
        int runs;
        for (BallsPlayed iterator:ballsPlayed) {
           runs=iterator.getRuns();
           batsmanScore.setRunsScored(batsmanScore.getRunsScored()+runs);
           if(runs==4)
               batsmanScore.setFours(batsmanScore.getFours()+1);
           if (runs==6)
            batsmanScore.setSixes(batsmanScore.getSixes()+1);
        }
        if(batsmanScore.getBallsFaced()!=0){
        double strikeRate=((double) batsmanScore.getRunsScored()/(double) batsmanScore.getBallsFaced());
        BigDecimal strikeRatePrecision=new BigDecimal(strikeRate).setScale(3, RoundingMode.HALF_DOWN);
        batsmanScore.setStrikeRate(strikeRatePrecision.doubleValue()*100);}
        else
            batsmanScore.setStrikeRate(0.0);
        return batsmanScore;
    }
}
