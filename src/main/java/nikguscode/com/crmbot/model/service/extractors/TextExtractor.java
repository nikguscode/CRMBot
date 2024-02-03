package nikguscode.com.crmbot.model.service.extractors;

import nikguscode.com.crmbot.model.service.logger.JsonSerializer;
import nikguscode.com.crmbot.model.service.logger.UpdateData;
import nikguscode.com.crmbot.model.service.enums.SenderType;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TextExtractor implements Extractor {
    @Autowired
    private JsonSerializer serializer;
//    @Autowired
//    private UpdateData data;

    public void extract(String time, Update update, SenderType senderType, TelegramType dataType) {
        Long userId = update.getMessage().getChatId();
        Integer messageId = update.getMessage().getMessageId();
        String userName = update.getMessage().getChat().getUserName();
        String firstName = update.getMessage().getChat().getFirstName();
        String lastName = update.getMessage().getChat().getLastName();
        String extractedText = update.getMessage().getText();

        UpdateData data = UpdateData.builder()
                .time(time)
                .senderType(senderType)
                .dataType(dataType)
                .telegramUserId(userId)
                .messageId(messageId)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .text(extractedText)
                .build();

        serializer.serializeToJsonFormat(data);
    }

}
