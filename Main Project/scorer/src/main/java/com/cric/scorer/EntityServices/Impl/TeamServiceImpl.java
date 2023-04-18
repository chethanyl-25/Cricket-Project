package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.EntityServices.TeamService;
import com.cric.scorer.Repository.TeamRepo;
import com.cric.scorer.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepo teamRepo;
    @Override
    public Team save(Team team) {
        return this.teamRepo.save(team);
    }

    @Override
    public long findTeamIdByTeamNameAndMatchId(String teamName, long matchId) {
        return this.teamRepo.findByTeamNameAndMatch(teamName,matchId);
    }

    @Override
    public Team findById(long id) {
        Optional<Team> teamOptional= this.teamRepo.findById(id);
        return teamOptional.get();
    }

    @Override
    public void deleteById(long teamId) {
        this.teamRepo.deleteById(teamId);
    }

}
