package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.Repository.TeamRepo;
import com.cric.scorer.EntityServices.TeamService;
import com.cric.scorer.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepo teamRepo;
    @Override
    public Team save(Team team) {
        return this.teamRepo.save(team);
    }
}
