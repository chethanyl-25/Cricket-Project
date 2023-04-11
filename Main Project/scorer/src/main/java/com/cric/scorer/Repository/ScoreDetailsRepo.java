package com.cric.scorer.Repository;

import com.cric.scorer.entity.ScoreDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDetailsRepo extends JpaRepository<ScoreDetails,Long> {
    @Query(value = "SELECT sum(score_details.runs) " +
            "FROM score_details " +
            "where score_details.match_id= :matchId and score_details.batting_team_id= :teamId " +
            "and (score_details.event='normal' or score_details.event='wicket')",nativeQuery = true )
    int getTotalRunsScoredByTeam(@Param("matchId") long matchId,@Param("teamId") long teamId);

    @Query(value = "SELECT COUNT(score_details.wicket_id) " +
            "FROM score_details" +
            " where score_details.match_id= :matchId and score_details.batting_team_id= :teamId" +
            " and score_details.event='wicket'",nativeQuery = true)
    int getTotalWicketsOfTeam(@Param("matchId") long matchId,@Param("teamId") long teamId);

    @Query(value = "select (sum(score_details.runs)+COUNT(score_details.event)) " +
            "from score_details " +
            "WHERE score_details.match_id= :matchId and score_details.batting_team_id= :teamId " +
            "and (score_details.event='wide' or score_details.event='noBall')",nativeQuery = true)
    int getExtrasOfTeam(@Param("matchId") long matchId,@Param("teamId") long teamId);

    @Query(value = "SELECT max(score_details.overs) " +
            "FROM score_details " +
            "where score_details.match_id= :matchId and score_details.batting_team_id= :teamId",nativeQuery = true)
    int getCurrentOver(@Param("matchId") long matchId,@Param("teamId") long teamId);

    @Query(value = "SELECT max(score_details.ball_no) " +
            "FROM score_details where score_details.match_id= :matchId " +
            "and score_details.batting_team_id= :teamId and score_details.overs= :currentOver",nativeQuery = true)
    int getCurrentBallNo(@Param("matchId") long matchId,@Param("teamId") long teamId,
                         @Param("currentOver") int currentOver);
}
