package com.cric.scorer.Repository;

import com.cric.scorer.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {
    @Query(nativeQuery = true,value = "SELECT team_id FROM team WHERE team.team_name= :teamName and team.match_id= :matchId")
    public long findByTeamNameAndMatch(@Param("teamName") String teamName,@Param("matchId") long matchId);
}
