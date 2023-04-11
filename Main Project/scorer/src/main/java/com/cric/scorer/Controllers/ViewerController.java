package com.cric.scorer.Controllers;

import com.cric.scorer.DTOs.output.ScoreSummary;
import com.cric.scorer.PersonaServices.CommonService;
import com.cric.scorer.PersonaServices.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewerController {
    @Autowired
    private CommonService commonService;
    @Autowired
    private ViewerService viewerService;

    @GetMapping("/viewer/getScoreSummary/{matchId}/{teamName}")
    public ResponseEntity<ScoreSummary> getScoreSummary(@PathVariable(name = "matchId") long matchId,
                                                        @PathVariable(name = "teamName") String teamName){
        ScoreSummary scoreSummary=this.viewerService.getScoreSummary(matchId,teamName);
        return ResponseEntity.ok(scoreSummary);
    }
}
