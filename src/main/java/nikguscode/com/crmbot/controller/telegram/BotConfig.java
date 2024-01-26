package nikguscode.com.crmbot.controller.telegram;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@Configuration
@Getter
public class BotConfig {
    @Value("${telegram.bot-name}")
    private String botName;

    @Value("${telegram.bot-token}")
    private String botToken;
}
