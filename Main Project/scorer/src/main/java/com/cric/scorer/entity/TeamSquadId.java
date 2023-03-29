package com.cric.scorer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamSquadId implements Serializable {
    private long team;
    private long player;

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj)
    {
        TeamSquad teamSquad=(TeamSquad)obj;
        if(teamSquad.getTeam().equals(this.getTeam()) && teamSquad.getPlayer().equals(this.getPlayer())){
            return true;
    }
        return false;
    }
}
