package com.cric.scorer.Services;

import com.cric.scorer.Repository.PlayerRepo;
import com.cric.scorer.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public Player save(Player player) {
        return this.playerRepo.save(player);
    }

    public List<Player> findByNameLike(String name) {
        return this.playerRepo.findByNameContaining(name);
    }

    public Player findById(long id) {
        Player player = this.playerRepo.findById(id);
        if (player != null)
            return player;
        else
            return null;
    }

    public void deleteById(long id) {
        this.playerRepo.deleteById(id);
    }

    public boolean updatePlayer(Player player) {
        Player player1 = this.findById(player.getPlayerId());
        this.playerRepo.save(player);
        if (player1 == null) {
            return false;
        } else {
            return true;
        }
    }
}
