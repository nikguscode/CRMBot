package nikguscode.com.crmbot.controller.telegram;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "application.properties", encoding = "UTF-8")
@Configuration
@Getter
public class BotConfiguration {
    @Value("${telegram.bot-name}")
    private String botName;

    @Value("${telegram.bot-token}")
    private String botToken;
}
