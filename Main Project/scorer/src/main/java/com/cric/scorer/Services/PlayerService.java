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

    public Player save(Player player)
    {
        return this.playerRepo.save(player);
    }

    public List<Player> findByNameLike(String name)
    {
        return this.playerRepo.findByNameContaining(name);
    }
}
