package org.jeremy.bot.sport.football.api.response.league.standing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballLeagueTeamGoalData {
    @JsonProperty("for")
    private int forGoal;

    @JsonProperty("against")
    private int againstGoal;
}
