package com.cric.scorer.Controllers;

import com.cric.scorer.Services.PlayerService;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/organizer",method = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class Organizer {

    @Autowired
    private PlayerService playerService;
    
    @PostMapping(value = "/addPlayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player)
    {
        System.out.println(player);
        Player player1=this.playerService.save(player);
        return ResponseEntity.ok(player1);
    }
    @GetMapping(value = "/getPlayersDetails/{playerName}")
    public ResponseEntity<List<Player>> getPlayersDetails(@PathVariable(name = "playerName")String name)
    {
        System.out.println(name);
        List<Player> ls=this.playerService.findByNameLike(name);
        if(ls.size()>0)
            return ResponseEntity.ok(ls);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
