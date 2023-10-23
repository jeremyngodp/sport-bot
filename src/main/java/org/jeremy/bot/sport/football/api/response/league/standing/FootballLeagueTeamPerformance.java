package org.jeremy.bot.sport.football.api.response.league.standing;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballLeagueTeamPerformance {
    private int played;
    private int win;
    private int draw;
    private int lose;

    private FootballLeagueTeamGoalData goals;

}
