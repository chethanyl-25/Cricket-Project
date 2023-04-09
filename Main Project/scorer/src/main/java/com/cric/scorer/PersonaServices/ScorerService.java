package com.cric.scorer.PersonaServices;

import com.cric.scorer.DTOs.input.Toss;
import com.cric.scorer.DTOs.input.UpdateResult;
import com.cric.scorer.DTOs.input.UpdateScore;
import com.cric.scorer.entity.Player;

import java.util.List;

public interface ScorerService {
    public void selectPlaying11(long matchId, String teamName, List<Player> playerList);
    public void setCaptaionAndWicketKeeper(long matchId,String teamName,List<Player> playerList);

    void updateTossAndUmpire(long matchId, Toss toss);

    void updateScore(long matchId, UpdateScore updateScore);

    void updateResult(long matchId, UpdateResult updateResult);
}
