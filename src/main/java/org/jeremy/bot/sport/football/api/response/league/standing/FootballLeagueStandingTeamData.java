package org.jeremy.bot.sport.football.api.response.league.standing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballLeagueStandingTeamData {
    private int id;
    private String name;
    private String logo;
}
