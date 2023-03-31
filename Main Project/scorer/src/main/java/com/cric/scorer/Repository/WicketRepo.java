package com.cric.scorer.Repository;

import com.cric.scorer.entity.Wicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WicketRepo extends JpaRepository<Wicket, Long> {
}
