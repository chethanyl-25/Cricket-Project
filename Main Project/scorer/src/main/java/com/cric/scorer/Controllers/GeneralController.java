package com.cric.scorer.Controllers;

import com.cric.scorer.DTOs.output.MatchInfo;
import com.cric.scorer.PersonaServices.GeneralServices;
import com.cric.scorer.entity.MatchDetails;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GeneralController {
    @Autowired
    private GeneralServices generalServices;
    @GetMapping("/getMatchDetails/{matchId}")
    public ResponseEntity<MatchInfo> getMatchDetails(@PathVariable(name = "matchId") int id)
    {
        MatchInfo matchInfo=this.generalServices.getMatchDetails(id);
        if(matchInfo!=null)
            return ResponseEntity.ok(matchInfo);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
