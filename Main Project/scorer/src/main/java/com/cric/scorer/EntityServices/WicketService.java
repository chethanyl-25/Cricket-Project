package com.cric.scorer.EntityServices;

import com.cric.scorer.entity.Wicket;

import java.util.List;

public interface WicketService {
    public Wicket save(Wicket wicket);

    List<Long> WicketsGone(long matchId);
}
