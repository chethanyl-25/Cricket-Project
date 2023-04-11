package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.EntityServices.ScoreDetailsService;
import com.cric.scorer.Repository.ScoreDetailsRepo;
import com.cric.scorer.entity.ScoreDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
