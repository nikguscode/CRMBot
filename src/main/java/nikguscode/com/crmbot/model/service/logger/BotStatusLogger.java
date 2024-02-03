package nikguscode.com.crmbot.model.service.logger;

import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.model.service.extractors.BotStatusExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BotStatusLogger {
    @Autowired
    private BotStatusExtractor extractor;

    public void launch() {
        String text = "CRM Bot has started";
        log.info(text);
        extractor.getStatus(text);
    }

    public void shutDownSafely() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            String text = "CRM Bot has terminated without errors";
            log.info(text);
            extractor.getStatus(text);
        }));
    }
}
