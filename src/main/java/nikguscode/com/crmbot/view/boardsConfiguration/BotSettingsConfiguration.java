package nikguscode.com.crmbot.view.boardsConfiguration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "buttons.properties", encoding = "UTF-8")
@Getter
public class BotSettingsConfiguration {
    @Value("${bot-settings-btn.logs-management}")
    private String logsManagement;
    @Value("${bot-settings-btn.bot-access}")
    private String access;
    @Value("${bot-settings-btn.payment}")
    private String payment;

    @Value("${bot-settings-cb.logs-management}")
    private String logsManagementCallback;
    @Value("${bot-settings-cb.bot-access}")
    private String accessCallback;
    @Value("${bot-settings-cb.payment}")
    private String paymentCallback;
}
