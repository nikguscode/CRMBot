package nikguscode.com.crmbot.model.service.actions.configuration;

import jakarta.inject.Qualifier;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.model.service.actions.callbacks.ManagerPaymentCallback;
import nikguscode.com.crmbot.model.service.actions.commands.StartCommand;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

@Service
@Slf4j
@Getter
public class GeneralConfiguration {
    private final CommandConfiguration command;
    private final CallbackConfiguration callback;

    @Autowired
    public GeneralConfiguration(CommandConfiguration command,
                                CallbackConfiguration callback) {
        this.command = command;
        this.callback = callback;
    }


    public Sender getAction(Update update, TelegramType telegramType) {
        switch (telegramType) {
            case COMMAND:
                return command.getCommandMap().get(update.getMessage().getText());
            case CALLBACK:
                return callback.getCallbackMap().get(update.getCallbackQuery().getData());
            default:
                log.error("Error in ActionsConfiguration");
                return null;
        }
    }
}
