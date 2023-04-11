package com.cric.scorer.Controllers;

import com.cric.scorer.DTOs.input.Toss;
import com.cric.scorer.DTOs.input.UpdateResult;
import com.cric.scorer.DTOs.input.UpdateScore;
import com.cric.scorer.PersonaServices.CommonService;
import com.cric.scorer.PersonaServices.ScorerService;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScorerController {
    @Autowired
    private CommonService commonService;
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
        this.scorerService.setCaptaionAndWicketKeeper(matchId,teamName, playerList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/scorer/toss/{matchId}")
    public ResponseEntity<Object> updateTossAndUmpire(@PathVariable("matchId") long matchId, @RequestBody Toss toss)
    {
        this.scorerService.updateTossAndUmpire(matchId,toss);
        return null;
    }
    @PostMapping("/scorer/updateScore/{matchId}")
    public ResponseEntity<Object> updateScore(@PathVariable(name = "matchId",required = true)long matchId,
                                              @RequestBody UpdateScore updateScore)
    {
        this.scorerService.updateScore(matchId,updateScore);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/scorer/updateResult/{matchId}")
    public ResponseEntity<Object> updateResult(@PathVariable("matchId")long matchId,
                                               @RequestBody UpdateResult updateResult)
    {
        this.scorerService.updateResult(matchId,updateResult);
        return null;
    }
}
