package com.cric.scorer.Controllers;

import com.cric.scorer.Services.PlayerService;
import com.cric.scorer.entity.Player;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Organizer {

    @Autowired
    private PlayerService playerService;

    //This method is used to save a player tuple to player entity
    @RequestMapping(value = "/organizer/addPlayer", method = RequestMethod.POST)
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player player1 = this.playerService.save(player);
        return new ResponseEntity<>(player1,HttpStatus.CREATED);
    }
    //This method is used to fetch details whose player.name contains 'playerName'
    @GetMapping(value = "/organizer/getPlayersDetails/{playerName}")
    public ResponseEntity<List<Player>> getPlayersDetails(@PathVariable(name = "playerName") String name) {
        List<Player> ls = this.playerService.findByNameLike(name);
        if (ls.size() > 0)
            return ResponseEntity.ok(ls);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //To delete a player by their id
    @DeleteMapping(value = "/organizer/deletePlayer")
    public ResponseEntity deletePlayer(@RequestParam("id") int id) {
        Player player = this.playerService.findById(id);
        if (player != null) {
            this.playerService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //To update a player
    //If player not present with given player.id returns NOT_FOUND httpStatusCode
    //If player found then it just updates the tuple in player entity
    @PutMapping(value = "/organizer/updatePlayer")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        boolean updated=this.playerService.updatePlayer(player);
        if(updated)
            return ResponseEntity.ok(player);
        else
            return new ResponseEntity<>(player,HttpStatus.NOT_FOUND);
    }
}
