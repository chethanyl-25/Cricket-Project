package com.cric.scorer.Repository;

import com.cric.scorer.entity.ScoreDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDetailsRepo extends JpaRepository<ScoreDetails,Long> {
}
