package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.Repository.MatchDetailsRepo;
import com.cric.scorer.entity.MatchDetails;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MatchDetailsServiceImpl implements com.cric.scorer.EntityServices.MatchDetailsService {
    @Autowired
    private MatchDetailsRepo matchDetailsService;
    @Override
    public MatchDetails save(MatchDetails matchDetails) {
        return this.matchDetailsService.save(matchDetails);
    }

    @Override
    public MatchDetails findById(long id) {
//        try {
            Optional<MatchDetails> optionalMatchDetails = this.matchDetailsService.findById(id);
            return optionalMatchDetails.get();
//        }catch (NoSuchElementException e)
//        {
//            return null;
//        }
    }

    @Override
    public boolean deleteById(long id) {
        MatchDetails matchDetails=this.findById(id);
        if(matchDetails==null)
            return false;
        else {
            this.matchDetailsService.deleteById(id);
            return true;
        }
    }
}
