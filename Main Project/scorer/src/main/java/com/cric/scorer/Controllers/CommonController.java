package com.cric.scorer.Controllers;

import com.cric.scorer.DTOs.output.MatchInfo;
import com.cric.scorer.PersonaServices.CommonService;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {
    @Autowired
    private CommonService commonService;

    @GetMapping("/getMatchDetails/{matchId}")
    public ResponseEntity<MatchInfo> getMatchDetails(@PathVariable(name = "matchId") int id) {
        MatchInfo matchInfo = this.commonService.getMatchDetails(id);
        if (matchInfo != null)
            return ResponseEntity.ok(matchInfo);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSquad/{matchId}/{Team}")
    public ResponseEntity<List<Player>> getSquad(@PathVariable("matchId") long matchId, @PathVariable("Team") String teamName) {
        List<Player> playerList = this.commonService.getSquad(matchId, teamName);
        if (playerList != null)
            return new ResponseEntity<>(playerList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getPlaying11/{matchId}/{Team}")
    public ResponseEntity<List<Player>> getPlaying11(@PathVariable("matchId") long matchId,
                                                     @PathVariable("Team") String teamName) {
        List<Player> playing11=this.commonService.getPlayin11(matchId,teamName);
        return ResponseEntity.ok(playing11);
    }
    @GetMapping("/get/{matchId}/{Team}/{role}")
    public ResponseEntity<Player> getPlayerByRole(@PathVariable("matchId") long matchId, @PathVariable("Team") String teamName,
                                                  @PathVariable("role")String role)
    {
        Player player =this.commonService.getPlayerBasedOnRole(matchId,teamName,role);
        return ResponseEntity.ok(player);
    }
    @GetMapping("/remainingPlayers/{matchId}/{TeamName}")
    public ResponseEntity<List<Player>> getRemainingPlayers(@PathVariable("matchId")long matchId,
                                                      @PathVariable("TeamName")String teamName)
    {
        List<Player> remainingPlayers=this.commonService.getRemainingPlayers(matchId,teamName);
        if (remainingPlayers.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return ResponseEntity.ok(remainingPlayers);

    }
}
