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

    @Query(value = "SELECT * FROM wicket WHERE wicket.match_id= :matchId and wicket.batsman_id= :playerId",nativeQuery = true)
    public Wicket findWicketDetails(@Param("matchId") long matchId,@Param("playerId") long playerId);
}
