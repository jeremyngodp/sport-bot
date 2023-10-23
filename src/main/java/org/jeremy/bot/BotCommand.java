package org.jeremy.bot;

public enum BotCommand {

    START("/start"),
    LALIGA("/laliga"),
    PREM("/prem");

    public final String value;
    BotCommand(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
    public static BotCommand enumOf(String commandText) {
        for (BotCommand enumItem : BotCommand.values()) {
            if (commandText.equals(enumItem.getValue())) {
                return enumItem;
            }
        }

        throw new RuntimeException("Invalid Bot Command");
    }
}