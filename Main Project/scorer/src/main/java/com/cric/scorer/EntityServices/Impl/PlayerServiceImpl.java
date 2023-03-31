package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.Repository.PlayerRepo;
import com.cric.scorer.EntityServices.PlayerService;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public Player save(Player player) {
        return this.playerRepo.save(player);
    }

    @Override
    public List<Player> findByNameContaining(String name) {
        return this.playerRepo.findByNameContaining(name);
    }

    @Override
    public Player findById(long id) {
        Player player = this.playerRepo.findById(id);
        if (player != null)
            return player;
        else
            return null;
    }

    @Override
    public void deleteById(long id) {
        this.playerRepo.deleteById(id);
    }

    @Override
    public boolean updatePlayer(Player player) {
        Player player1 = this.findById(player.getPlayerId());
        if (player1 == null) {
            return false;
        } else {
            this.playerRepo.save(player);
            return true;
        }
    }
}
