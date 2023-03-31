package com.cric.scorer.Repository;

import com.cric.scorer.entity.TeamSquad;
import com.cric.scorer.entity.TeamSquadId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamSquadRepo extends JpaRepository<TeamSquad, TeamSquadId> {
}
