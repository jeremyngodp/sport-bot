package org.jeremy.bot.utils;

import org.apache.commons.lang3.StringUtils;
import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueStandingResponse;
import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueStandingTeamResponse;

import java.util.List;

public class ResponseFormattingUtils {

    public static String parseStandingResponse(FootballLeagueStandingResponse resp) {
        List<FootballLeagueStandingTeamResponse> standings = resp.getStandings().get(0);

        StringBuilder sb = new StringBuilder();
        sb.append(resp.getName())
                .append(" ")
                .append(resp.getSeason())
                .append("\n")
                .append("```");

        for (var standingItem : standings) {
            sb.append(StringUtils.leftPad(String.valueOf(standingItem.getRank()), 2," "))
                    .append("  ")
                    .append(StringUtils.rightPad(standingItem.getTeam().getName(), 20," "))
                    .append("  ")
                    .append(StringUtils.leftPad(String.valueOf(standingItem.getPoints()), 3," "))
                    .append("  ")
                    .append(
                            StringUtils.leftPad(String.valueOf(standingItem.getGoalsDiff()), 3," "))
                    .append("  ")
                    .append(
                            StringUtils.leftPad(String.valueOf(standingItem.getAll().getPlayed()), 3," "))
                    .append("\n");
        }
        sb.append("```");

        return sb.toString();
    }
}
