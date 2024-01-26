package nikguscode.com.crmbot.model.service.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import nikguscode.com.crmbot.model.service.SenderType;
import nikguscode.com.crmbot.model.service.TelegramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Optional;

@Service
public class JsonSerializer {

    private final LinkedHashMap<String, Object> extractedData;
    private final FileLogger fileLogger;

    @Autowired
    public JsonSerializer(FileLogger fileLogger) {
        extractedData = new LinkedHashMap<>();
        this.fileLogger = fileLogger;
    }

    private void serializeToJsonFormat(LinkedHashMap<String, Object> extractedData, TelegramType dataType) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String json = objectMapper.writeValueAsString(extractedData);
            fileLogger.updateLogs(json, dataType);
            extractedData.clear();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void addEntries(String[] keys, Object[] values, int length) {
        for (int currentPair = 0; currentPair < length; currentPair++) {
            extractedData.put(keys[currentPair], Optional.ofNullable(values[currentPair]).orElse("not found"));
        }
    }

    public void getExtractedData(String time, SenderType senderType, String text) {
        String[] keys = {"time", "senderType", "text"};
        Object[] values = {time, senderType, text};

        addEntries(keys, values, keys.length);
        serializeToJsonFormat(extractedData, TelegramType.SYSTEM);
    }

    public void getExtractedData(String time, SenderType senderType, TelegramType dataType,
                                 long telegramUserId, long telegramDataId, String telegramUserName,
                                 String telegramFirstName, String telegramLastName, String text) {
        String[] keys = {"time", "senderType", "dataType", "telegramUserId", "telegramDataId",
                "telegramUserName", "telegramFirstName", "telegramLastName", "text"};

        Object[] values = {time, senderType, dataType, telegramUserId, telegramDataId,
                telegramUserName, telegramFirstName, telegramLastName, text};

        addEntries(keys, values, keys.length);
        serializeToJsonFormat(extractedData, dataType);
    }
}
