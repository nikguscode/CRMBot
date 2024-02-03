package nikguscode.com.crmbot.model.service.extractors;

import nikguscode.com.crmbot.model.service.enums.TelegramType;
import nikguscode.com.crmbot.model.service.logger.JsonSerializer;
import nikguscode.com.crmbot.model.service.logger.UpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class BotStatusExtractor {
    @Autowired
    JsonSerializer serializer;

    public void getStatus(String text) {
        String time = LocalTime.now().withNano(0).toString();

        UpdateData data = UpdateData.builder()
                .time(time)
                .text(text)
                .dataType(TelegramType.SYSTEM)
                .build();

        serializer.serializeToJsonFormat(data);
    }
}
