package nikguscode.com.crmbot.controller;

import nikguscode.com.crmbot.model.service.actions.configuration.GeneralConfiguration;
import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.model.service.enums.SenderType;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
import nikguscode.com.crmbot.model.service.extractors.Extractor;
import nikguscode.com.crmbot.model.service.extractors.ExtractorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalTime;


@Service
public class TelegramTypeHandler {
    private final ExtractorConfiguration extractorConfiguration;
    private final GeneralConfiguration generalConfiguration;

    @Autowired
    public TelegramTypeHandler(ExtractorConfiguration extractorConfiguration,
                               GeneralConfiguration generalConfiguration) {
        this.extractorConfiguration = extractorConfiguration;
        this.generalConfiguration = generalConfiguration;
    }

    public BotApiMethod<?> getTelegramUpdateAndType(Update update, TelegramType telegramType) {
        selectExtractor(update, telegramType);
        return selectAction(update, telegramType);
    }

    private BotApiMethod<?> selectAction(Update update, TelegramType telegramType) {
        Sender sender = generalConfiguration.getAction(update, telegramType);
        return sender.send(update);
    }

    private void selectExtractor(Update update, TelegramType telegramType) {
        Extractor extractor = extractorConfiguration.getMapOfTypes().get(telegramType);
        String time = LocalTime.now().withNano(0).toString();
        extractor.extract(time, update, SenderType.ADMIN, telegramType);
    }
}
