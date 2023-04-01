package com.cric.scorer.Repository;

import com.cric.scorer.entity.TeamSquad;
import com.cric.scorer.entity.TeamSquadId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamSquadRepo extends JpaRepository<TeamSquad, TeamSquadId> {
    @Query(value = "SELECT team_squad.player_id FROM team_squad WHERE team_squad.team_id= :teamId",nativeQuery = true)
    public List<Long> getSquad(@Param("teamId") long teamId);

    @Query(value = "select team_squad.player_id FROM team_squad WHERE team_squad.team_id= :teamId and is_playing=1",nativeQuery = true)
    public List<Long> getPlaying11(@Param("teamId") long teamId);
}
