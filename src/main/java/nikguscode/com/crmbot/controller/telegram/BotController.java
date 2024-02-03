package nikguscode.com.crmbot.controller.telegram;

import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.model.service.TelegramTypeIdentifier;
import nikguscode.com.crmbot.view.boards.ManagerBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Controller
@Slf4j
public class BotController extends TelegramLongPollingBot {
    private final BotConfiguration botConfiguration;
    private final TelegramTypeIdentifier telegramTypeIdentifier;
    private final ManagerBoard managerBoard;

    @Autowired
    public BotController(BotConfiguration botConfiguration,
                         TelegramTypeIdentifier telegramTypeIdentifier,
                         ManagerBoard managerBoard) {
        this.botConfiguration = botConfiguration;
        this.telegramTypeIdentifier = telegramTypeIdentifier;
        this.managerBoard = managerBoard;
    }

    @Override
    public String getBotUsername() {
        return botConfiguration.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfiguration.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(telegramTypeIdentifier.getActionForTelegramType(update));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
