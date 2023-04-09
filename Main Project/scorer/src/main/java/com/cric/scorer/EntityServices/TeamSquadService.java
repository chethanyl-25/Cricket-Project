package com.cric.scorer.EntityServices;

import com.cric.scorer.entity.TeamSquad;

import java.util.List;

public interface TeamSquadService {
    public TeamSquad save(TeamSquad teamSquad);

    List<Long> getSquad(long teamId);

    List<Long> getPlaying11(long teamId);
}
