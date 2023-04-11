package com.cric.scorer.PersonaServices;

import com.cric.scorer.DTOs.output.MatchInfo;
import com.cric.scorer.entity.Player;

import java.util.List;

public interface CommonService {
    public MatchInfo getMatchDetails(long id);
    public List<Player> getSquad(long matchId, String teamName);
    public List<Player> getPlayin11(long matchId, String teamName);
    public Player getPlayerBasedOnRole(long matchId, String teamName, String role);

    List<Player> getRemainingPlayers(long matchId, String teamName);
}
