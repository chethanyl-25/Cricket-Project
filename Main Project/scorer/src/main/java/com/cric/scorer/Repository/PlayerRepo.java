package com.cric.scorer.Repository;

import com.cric.scorer.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
    public List<Player> findByNameContaining(String name);
    public Player findById(long id);
}
