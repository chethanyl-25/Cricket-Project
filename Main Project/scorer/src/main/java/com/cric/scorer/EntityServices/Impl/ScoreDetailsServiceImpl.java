package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.EntityServices.ScoreDetailsService;
import com.cric.scorer.Repository.ScoreDetailsRepo;
import com.cric.scorer.entity.ScoreDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreDetailsServiceImpl implements ScoreDetailsService {
    @Autowired
    private ScoreDetailsRepo scoreDetailsRepo;
    @Override
    public ScoreDetails save(ScoreDetails scoreDetails) {
        return this.scoreDetailsRepo.save(scoreDetails);
    }
}
