package nikguscode.com.crmbot.controller.telegram;

import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.controller.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Controller
@Slf4j
public class BotController extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final MessageManager messageManager;

    @Autowired
    public BotController(BotConfig botConfig,
                         MessageManager messageManager) {
        this.botConfig = botConfig;
        this.messageManager = messageManager;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            sendMessage(messageManager.send(update));
        }

    }

    public void sendMessage(SendMessage sendMessage) {

        try {
            System.out.println(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
