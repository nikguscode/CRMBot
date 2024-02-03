package nikguscode.com.crmbot.model.service.extractors;

import nikguscode.com.crmbot.model.service.logger.JsonSerializer;
import nikguscode.com.crmbot.model.service.logger.UpdateData;
import nikguscode.com.crmbot.model.service.enums.SenderType;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.InaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class CallbackExtractor implements Extractor {
    @Autowired
    private JsonSerializer serializer;
//    @Autowired
//    private UpdateData data;

    public void extract(String time, Update update, SenderType senderType, TelegramType telegramType) {
        String callbackId = update.getCallbackQuery().getId();
        Long userId = update.getCallbackQuery().getFrom().getId();
        Integer messageId = getMessageId(update);
        String callback = update.getCallbackQuery().getData();
        String userName = update.getCallbackQuery().getFrom().getUserName();
        String firstName = update.getCallbackQuery().getFrom().getFirstName();
        String lastName = update.getCallbackQuery().getFrom().getLastName();

        UpdateData data = UpdateData.builder()
                .time(time)
                .senderType(senderType)
                .dataType(telegramType)
                .callbackId(callbackId)
                .telegramUserId(userId)
                .messageId(messageId)
                .callback(callback)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        serializer.serializeToJsonFormat(data);
    }

    public Integer getMessageId(Update update) {
        Integer messageId = null;
        MaybeInaccessibleMessage message = update.getCallbackQuery().getMessage();

        if (message instanceof Message) {
            message = update.getCallbackQuery().getMessage();
            messageId = ((Message) message).getMessageId();
        } else if (message instanceof InaccessibleMessage) {
            message = update.getCallbackQuery().getMessage();
            messageId = ((InaccessibleMessage) message).getMessageId();
        }

        return messageId;
    }
}
