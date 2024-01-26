package nikguscode.com.crmbot.model.service.logger.telegramDataExtractors;

import nikguscode.com.crmbot.model.service.SenderType;
import nikguscode.com.crmbot.model.service.TelegramType;
import nikguscode.com.crmbot.model.service.logger.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TextExtractor implements Extractor {
    @Autowired
    private JsonSerializer serializer;

    public void extract(String time, Update update, SenderType senderType, TelegramType telegramType) {
        long telegramUserId = update.getMessage().getChatId();
        long telegramDataId = update.getMessage().getMessageId();
        String telegramUserName = update.getMessage().getChat().getUserName();
        String telegramFirstName = update.getMessage().getChat().getFirstName();
        String telegramLastName = update.getMessage().getChat().getLastName();
        String extractedText = update.getMessage().getText();

        serializer.getExtractedData(
                time,
                senderType,
                telegramType,
                telegramUserId,
                telegramDataId,
                telegramUserName,
                telegramFirstName,
                telegramLastName,
                extractedText
        );
    }

}
