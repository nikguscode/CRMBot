package nikguscode.com.crmbot.controller;

import nikguscode.com.crmbot.model.service.SenderType;
import nikguscode.com.crmbot.model.service.TelegramType;
import nikguscode.com.crmbot.model.service.logger.telegramDataExtractors.CallbackExtractor;
import nikguscode.com.crmbot.model.service.logger.telegramDataExtractors.Extractor;
import nikguscode.com.crmbot.model.service.logger.telegramDataExtractors.TextExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalTime;
import java.util.EnumMap;
import java.util.Map;


@Service
public class TelegramTypeHandler {
    private final Map<TelegramType, Extractor> mapOfTypes;

    @Autowired
    public TelegramTypeHandler(TextExtractor textExtractor,
                               CallbackExtractor callbackExtractor) {
        mapOfTypes = new EnumMap<>(TelegramType.class);

        mapOfTypes.putAll(Map.of(
                TelegramType.TEXT, textExtractor,
                TelegramType.CALLBACK, callbackExtractor
        ));
    }

    public void selectExtractor(Update update, TelegramType telegramType) {
        Extractor extractor = mapOfTypes.get(telegramType);
        String time = LocalTime.now().withNano(0).toString();
        extractor.extract(time, update, SenderType.ADMIN, telegramType);
    }
}
