package org.jeremy.bot;

import org.apache.commons.lang3.StringUtils;
import org.jeremy.bot.sport.football.api.clients.league.LeagueStandingClient;
import org.jeremy.bot.sport.football.api.clients.league.impl.LeagueStandingClientImpl;
import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueStandingResponse;
import org.jeremy.bot.sport.football.api.response.league.standing.FootballLeagueStandingTeamResponse;
import org.jeremy.bot.utils.ResponseFormattingUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class Bot  extends TelegramLongPollingBot{

    private final LeagueStandingClient leagueStandingClient;
    public Bot() {
        super();
        this.leagueStandingClient = new LeagueStandingClientImpl();
    }
    @Override
    public String getBotUsername() {
        return "jngodp_first_bot";
    }

    @Override
    public String getBotToken() {
        return "6364775510:AAHlEzBLcfxC_lcbLs936cZMvhyTd4UVSqI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        long target = msg.getFrom().getId();
        if (msg.isCommand()) {
            processCommand(target, BotCommand.enumOf(msg.getText()));
        }
    }

    private void processCommand(long target, BotCommand command) {
        try {
            switch (command) {
                case LALIGA -> sendText(target,
                        ResponseFormattingUtils.parseStandingResponse(leagueStandingClient.getLaLigaStanding()));
                case PREM -> sendText(target,
                        ResponseFormattingUtils.parseStandingResponse(leagueStandingClient.getPremStanding()));
                case START -> sendText(target,
                        "Welcome to Jeremy's first telegram bot, So far it can only look for prem and La Liga Standing");
                default -> {}
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void sendText(Long who, String text) {
        SendMessage sm =  SendMessage.builder()
                .chatId(who.toString())
                .text(text)
                .parseMode("MarkdownV2")
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
