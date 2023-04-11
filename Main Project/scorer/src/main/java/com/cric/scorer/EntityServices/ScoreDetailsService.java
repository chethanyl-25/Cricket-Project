package com.cric.scorer.EntityServices;

import com.cric.scorer.entity.ScoreDetails;

public interface ScoreDetailsService {
    ScoreDetails save(ScoreDetails scoreDetails);

    int getTotalRunsScoredByTeam(long matchId,  long teamId);

    int getTotalWicketsOfTeam(long matchId, long teamId);

    int getExtrasOfTeam(long matchId, long teamId);

    int getCurrentOver(long matchId, long teamId);

    int getCurrentBallNo(long matchId, long teamId, int currentOver);
}
