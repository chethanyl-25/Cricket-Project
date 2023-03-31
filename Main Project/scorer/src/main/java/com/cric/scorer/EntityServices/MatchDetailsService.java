package com.cric.scorer.EntityServices;

import com.cric.scorer.entity.MatchDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MatchDetailsService {
    public MatchDetails save(MatchDetails matchDetails);
    public MatchDetails findById(long id);
    public boolean deleteById(long id);
}
