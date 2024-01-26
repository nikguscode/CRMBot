package nikguscode.com.crmbot.model.service.logger.telegramDataExtractors;

import nikguscode.com.crmbot.model.service.SenderType;
import nikguscode.com.crmbot.model.service.TelegramType;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public interface Extractor {
    public void extract(String time, Update update, SenderType senderType, TelegramType telegramType);
}
