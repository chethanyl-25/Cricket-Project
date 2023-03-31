package com.cric.scorer.Repository;

import com.cric.scorer.entity.MatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDetailsRepo extends JpaRepository<MatchDetails,Long> {
}
