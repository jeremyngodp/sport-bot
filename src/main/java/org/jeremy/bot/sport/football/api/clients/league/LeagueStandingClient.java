package org.jeremy.bot.sport.football.api.clients.league;

import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueStandingResponse;

import java.io.IOException;

public interface LeagueStandingClient {
    FootballLeagueStandingResponse getLaLigaStanding() throws IOException, InterruptedException;

    FootballLeagueStandingResponse getPremStanding() throws IOException, InterruptedException;
}
