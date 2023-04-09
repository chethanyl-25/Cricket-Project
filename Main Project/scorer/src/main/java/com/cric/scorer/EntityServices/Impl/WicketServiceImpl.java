package com.cric.scorer.EntityServices.Impl;

import com.cric.scorer.EntityServices.WicketService;
import com.cric.scorer.Repository.WicketRepo;
import com.cric.scorer.entity.Wicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WicketServiceImpl implements WicketService {
    @Autowired
    private WicketRepo wicketRepo;

    @Override
    public Wicket save(Wicket wicket) {
        return this.wicketRepo.save(wicket);
    }

    @Override
    public List<Long> WicketsGone(long matchId) {
        return this.wicketRepo.fallenBatsmen(matchId);
    }
}
