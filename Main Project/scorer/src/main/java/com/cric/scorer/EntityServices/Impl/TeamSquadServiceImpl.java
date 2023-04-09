package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.Repository.TeamSquadRepo;
import com.cric.scorer.entity.TeamSquad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamSquadServiceImpl implements com.cric.scorer.EntityServices.TeamSquadService {
    @Autowired
    private TeamSquadRepo teamSquadRepo;

    @Override
    public TeamSquad save(TeamSquad teamSquad) {
        return this.teamSquadRepo.save(teamSquad);
    }

    @Override
    public List<Long> getSquad(long teamId) {
        return this.teamSquadRepo.getSquad(teamId);
    }

    @Override
    public List<Long> getPlaying11(long teamId) {
        return this.teamSquadRepo.getPlaying11(teamId);
    }
}
