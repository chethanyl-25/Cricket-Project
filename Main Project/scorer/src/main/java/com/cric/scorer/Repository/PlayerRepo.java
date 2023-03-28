package com.cric.scorer.Repository;

import com.cric.scorer.DTOs.output.Players;
import com.cric.scorer.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
    public List<Players> findByNameContaining(String name);
}
