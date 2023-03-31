package com.cric.scorer.EntityServices;

import com.cric.scorer.entity.Player;

import java.util.List;

public interface PlayerService {

    public Player save(Player player);
    public List<Player> findByNameContaining(String name);
    public Player findById(long id);
    public void deleteById(long id);
    public boolean updatePlayer(Player player);
}
