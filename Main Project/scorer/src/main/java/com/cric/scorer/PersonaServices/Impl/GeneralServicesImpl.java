package com.cric.scorer.PersonaServices.Impl;

import com.cric.scorer.DTOs.output.MatchInfo;
import com.cric.scorer.EntityServices.MatchDetailsService;
import com.cric.scorer.PersonaServices.GeneralServices;
import com.cric.scorer.Repository.MatchDetailsRepo;
import com.cric.scorer.entity.MatchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralServicesImpl implements GeneralServices {
    @Autowired
    private MatchDetailsService matchDetailsService;
    @Override
    public MatchInfo getMatchDetails(long id) {

        MatchDetails matchDetails=this.matchDetailsService.findById(id);
        if (matchDetails==null)
            return null;
        MatchInfo matchInfo=new MatchInfo();
        matchInfo.setMatchId(matchDetails.getMatchId());
        matchInfo.setOvers(matchDetails.getOvers());
        matchInfo.setTeamA(matchDetails.getTeamA().getTeamName());
        matchInfo.setTeamB(matchDetails.getTeamB().getTeamName());
        if(matchDetails.getTossWon()!=null)
            matchInfo.setTossWon(matchDetails.getTossWon().getTeamName());
        if (matchDetails.getManOfTheMatch()!=null)
            matchInfo.setManOfTheMatch(matchDetails.getManOfTheMatch().getName());
        if(matchDetails.getWonBy()!=null)
            matchInfo.setWonBy(matchDetails.getWonBy().getTeamName());
        matchInfo.setStatus(matchDetails.getStatus());
        return matchInfo;
    }
}
