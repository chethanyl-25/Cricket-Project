package com.cric.scorer.PersonaServices;


import com.cric.scorer.DTOs.input.Match;
import com.cric.scorer.DTOs.output.MatchCreated;
import com.cric.scorer.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrganizerService {
    public Player savePlayer(Player player);
    public List<Player> findByNameContaining(String name);

    public MatchCreated createMatch(Match match);
    public Player updatePlayer(Player player);
    public boolean deletePlayer(long id);
    public boolean deleteMatch(long id);

}
