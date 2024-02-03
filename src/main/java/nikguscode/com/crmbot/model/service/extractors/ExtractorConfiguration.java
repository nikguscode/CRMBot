package nikguscode.com.crmbot.model.service.extractors;

import lombok.Getter;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service
@Getter
public class ExtractorConfiguration {
    private final Map<TelegramType, Extractor> mapOfTypes;

    @Autowired
    public ExtractorConfiguration(TextExtractor textExtractor,
                                  CallbackExtractor callbackExtractor) {
        mapOfTypes = new EnumMap<>(TelegramType.class);

        mapOfTypes.putAll(Map.of(
                TelegramType.TEXT, textExtractor,
                TelegramType.COMMAND, textExtractor,
                TelegramType.CALLBACK, callbackExtractor
        ));
    }
}
