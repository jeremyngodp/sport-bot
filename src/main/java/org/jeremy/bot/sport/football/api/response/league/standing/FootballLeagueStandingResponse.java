package org.jeremy.bot.sport.football.api.response.league.standing;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballLeagueStandingResponse {
    private long id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;
    private List<List<FootballLeagueStandingTeamResponse>> standings;
}
