package com.cric.scorer.PersonaServices;

import com.cric.scorer.DTOs.output.ScoreSummary;

public interface ViewerService {
    ScoreSummary getScoreSummary(long matchId, String teamName);
}
