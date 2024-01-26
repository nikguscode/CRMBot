package nikguscode.com.crmbot.model.service.logger.telegramDataExtractors;

import nikguscode.com.crmbot.model.service.SenderType;
import nikguscode.com.crmbot.model.service.logger.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class BotStatusExtractor {
    @Autowired
    private JsonSerializer serializer;

    public void getStatus(String text) {
        String time = LocalTime.now().withNano(0).toString();

        serializer.getExtractedData(time, SenderType.BOT_SYSTEM, text);
    }
}
