package com.cric.scorer.EntityServices;

import com.cric.scorer.entity.Team;

public interface TeamService {

    public Team save(Team team);
    public long findTeamIdByTeamNameAndMatchId(String teamName,long matchId);
    public Team findById(long id);

    void deleteById(long teamId);

}
