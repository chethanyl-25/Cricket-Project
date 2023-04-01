package com.cric.scorer.Controllers;

import com.cric.scorer.PersonaServices.GeneralServices;
import com.cric.scorer.PersonaServices.ScorerService;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ScorerController {
    @Autowired
    private GeneralServices generalServices;
    @Autowired
    private ScorerService scorerService;

    @PutMapping("/scorer/selectPlaying11/{matchId}/{Team}")
    public ResponseEntity<Object> updatePlaying11(@PathVariable("matchId") long matchId,
                                                  @PathVariable("Team") String teamName,
                                                  @RequestBody List<Player> playerList) {
        this.scorerService.selectPlaying11(matchId, teamName, playerList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/scorer/setCAndWK/{matchId}/{Team}")
    public ResponseEntity<Object> setCaptainAndWicketKeeper(@PathVariable("matchId") long matchId,
                                                            @PathVariable("Team") String teamName,
                                                            @RequestBody List<Player> playerList) {
        this.scorerService.setCaptaionAndWicketKeeper(matchId,teamName,playerList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
