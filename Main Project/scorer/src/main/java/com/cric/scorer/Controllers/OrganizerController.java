package com.cric.scorer.Controllers;

import com.cric.scorer.DTOs.input.Match;
import com.cric.scorer.DTOs.input.UpdateMatch;
import com.cric.scorer.DTOs.output.MatchCreated;
import com.cric.scorer.PersonaServices.CommonService;
import com.cric.scorer.PersonaServices.OrganizerService;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private CommonService commonService;

    //This method is used to save a player tuple to player entity
    @RequestMapping(value = "/organizer/addPlayer", method = RequestMethod.POST)
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player player1 = this.organizerService.savePlayer(player);
        return ResponseEntity.ok(player1);
    }
    //This method is used to fetch details whose player.name contains 'playerName'
    @GetMapping(value = "/organizer/getPlayersDetails/{playerName}")
    public ResponseEntity<List<Player>> getPlayersDetails(@PathVariable(name = "playerName") String name) {
        List<Player> playerList =this.organizerService.findByNameContaining(name);
        if(playerList ==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(playerList);
    }
    //To delete a player by their id
    @DeleteMapping(value = "/organizer/deletePlayer")
    public ResponseEntity deletePlayer(@RequestParam("id") long id) {
        boolean isDeleted=this.organizerService.deletePlayer(id);
        if(isDeleted)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //To update a player
    //If player not present with given player.id returns NOT_FOUND httpStatusCode
    //If player found then it just updates the tuple in player entity
    @PutMapping(value = "/organizer/updatePlayer")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player player1 =this.organizerService.updatePlayer(player);
        if(player1 !=null)
            return ResponseEntity.ok(player1);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/organizer")
    public ResponseEntity<MatchCreated> createNewMatch(@RequestBody Match match)
    {
        MatchCreated matchCreated=this.organizerService.createMatch(match);
        if(matchCreated!=null)
            return new ResponseEntity<>(matchCreated,HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/organizer/{matchId}")
    public ResponseEntity deleteMatch(@PathVariable("matchId")long id)
    {
        if(this.organizerService.deleteMatch(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/organizer/{matchId}/squad/{Team}")
    public ResponseEntity<Object> addTeamSquad(@PathVariable("matchId")long matchId,
                                                @PathVariable("Team")String teamName,
                                                @RequestBody List<Player> playerList){
        if(this.organizerService.addSquad(matchId,teamName, playerList))
        return new ResponseEntity<>("Players added Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Some Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/organizer")
    public ResponseEntity<Object> updateMatch(@RequestBody UpdateMatch updateMatch)
    {
        this.organizerService.updateMatch(updateMatch);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
