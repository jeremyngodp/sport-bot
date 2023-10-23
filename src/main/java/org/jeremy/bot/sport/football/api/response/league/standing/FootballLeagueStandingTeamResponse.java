package org.jeremy.bot.sport.football.api.response.league.standing;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballLeagueStandingTeamResponse {
    private int rank;
    private FootballLeagueStandingTeamData team;
    private int points;
    private int goalsDiff;
    private String group;
    private String form;

    private String status;
    private String description;

    private FootballLeagueTeamPerformance all;

    private FootballLeagueTeamPerformance home;

    private FootballLeagueTeamPerformance away;

    private String update;
}
