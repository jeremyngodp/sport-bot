package org.jeremy.bot.sport.football.api.clients.league.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jeremy.bot.sport.football.api.clients.league.LeagueStandingClient;
import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueResponseWrapper;
import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueStandingResponse;
import org.jeremy.bot.sport.football.api.response.league.standing.GenericApiResponse;
import org.jeremy.bot.utils.ApplicationPropertiesUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LeagueStandingClientImpl implements LeagueStandingClient {

    private final ObjectMapper om = new ObjectMapper();
    private final String API_KEY_PROP = "rapid.api.key";
    private final String API_HOST_PROP = "rapid.api.host";

    @Override
    public FootballLeagueStandingResponse getLaLigaStanding() throws IOException, InterruptedException {
        String rapidApiHost = ApplicationPropertiesUtils.getAppProperties(API_HOST_PROP);
        String rapidApiKey = ApplicationPropertiesUtils.getAppProperties(API_KEY_PROP);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/standings?season=2023&league=140"))
                .header("X-RapidAPI-Key", rapidApiKey)
                .header("X-RapidAPI-Host", rapidApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        GenericApiResponse<FootballLeagueResponseWrapper> laLigaStandingResp;

        laLigaStandingResp = om.readValue(
                response.body(), new TypeReference<GenericApiResponse<FootballLeagueResponseWrapper>>(){});

        return laLigaStandingResp.getResponse().get(0).getLeague();
    }

    @Override
    public FootballLeagueStandingResponse getPremStanding() throws IOException, InterruptedException {
        String rapidApiHost = ApplicationPropertiesUtils.getAppProperties(API_HOST_PROP);
        String rapidApiKey = ApplicationPropertiesUtils.getAppProperties(API_KEY_PROP);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/standings?season=2023&league=39"))
                .header("X-RapidAPI-Key", rapidApiKey)
                .header("X-RapidAPI-Host", rapidApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        GenericApiResponse<FootballLeagueResponseWrapper> premStandingResp;

        premStandingResp = om.readValue(
                response.body(), new TypeReference<GenericApiResponse<FootballLeagueResponseWrapper>>(){});
        return premStandingResp.getResponse().get(0).getLeague();
    }
}
