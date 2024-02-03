package nikguscode.com.crmbot.model.service.extractors;

import nikguscode.com.crmbot.model.service.enums.SenderType;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public interface Extractor {
    public void extract(String time, Update update, SenderType senderType, TelegramType telegramType);
}
