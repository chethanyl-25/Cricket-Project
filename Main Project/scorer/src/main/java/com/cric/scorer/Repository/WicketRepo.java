package com.cric.scorer.Repository;

import com.cric.scorer.entity.Wicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WicketRepo extends JpaRepository<Wicket, Long> {
    @Query(value = "SELECT wicket.batsman_id from wicket WHERE match_id= :matchId",nativeQuery = true)
    public List<Long> fallenBatsmen(@Param("matchId") long matchId);
}
