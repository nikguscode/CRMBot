package nikguscode.com.crmbot.controller.telegram;

import nikguscode.com.crmbot.model.service.logger.BotStatusLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConnector {
    private BotController botController;
    private BotStatusLogger statusLogger;

    @Autowired
    public void setBotConnection(BotController botController,
                                 BotStatusLogger statusLogger) {
        this.botController = botController;
        this.statusLogger = statusLogger;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi bot = new TelegramBotsApi(DefaultBotSession.class);
        bot.registerBot(botController);

        statusLogger.launch();
        statusLogger.shutDownSafely();
    }
}
