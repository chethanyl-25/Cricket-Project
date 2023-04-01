package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.EntityServices.TeamSquadService;
import com.cric.scorer.Repository.TeamSquadRepo;
import com.cric.scorer.entity.TeamSquad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamSquadServiceImpl implements TeamSquadService {
    @Autowired
    private TeamSquadRepo teamSquadRepo;

    @Override
    public TeamSquad save(TeamSquad teamSquad) {
        return this.teamSquadRepo.save(teamSquad);
    }

}
