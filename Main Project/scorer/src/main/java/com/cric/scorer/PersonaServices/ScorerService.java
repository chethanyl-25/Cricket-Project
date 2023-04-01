package com.cric.scorer.PersonaServices;

import com.cric.scorer.entity.Player;

import java.util.List;

public interface ScorerService {
    public void selectPlaying11(long matchId, String teamName, List<Player> playerList);
    public void setCaptaionAndWicketKeeper(long matchId,String teamName,List<Player> playerList);
}
