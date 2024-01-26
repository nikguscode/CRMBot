package nikguscode.com.crmbot.model.service.logger.telegramDataExtractors;

import nikguscode.com.crmbot.model.service.SenderType;
import nikguscode.com.crmbot.model.service.TelegramType;
import nikguscode.com.crmbot.model.service.logger.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class CallbackExtractor implements Extractor {
    @Autowired
    private JsonSerializer serializer;

    public void extract(String time, Update update, SenderType senderType, TelegramType telegramType) {
        String callback = update.getCallbackQuery().getData();
//
//        serializer.getExtractedData(
//                time,
//                update,
//                senderType,
//                telegramType,
//
//        );
    }
}
