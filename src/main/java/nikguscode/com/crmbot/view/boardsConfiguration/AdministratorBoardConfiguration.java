package nikguscode.com.crmbot.view.boardsConfiguration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "buttons.properties", encoding = "UTF-8")
@Getter
public class AdministratorBoardConfiguration {
    @Value("${administrator-btn.statistics}")
    private String botStatistics;
    @Value("${administrator-btn.get-report}")
    private String report;
    @Value("${administrator-btn.edit-report}")
    private String editReport;
    @Value("${administrator-btn.manager-list}")
    private String managerList;
    @Value("${administrator-btn.bot-settings}")
    private String botSettings;
    @Value("${administrator-btn.personal-settings}")
    private String personalSettings;

    @Value("${administrator-cb.statistics}")
    private String botStatisticsCallback;
    @Value("${administrator-cb.get-report}")
    private String reportCallback;
    @Value("${administrator-cb.edit-report}")
    private String editReportCallback;
    @Value("${administrator-cb.manager-list}")
    private String managerListCallback;
    @Value("${administrator-cb.bot-settings}")
    private String botSettingsCallback;
    @Value("${administrator-cb.personal-settings}")
    private String personalSettingsCallback;
}
