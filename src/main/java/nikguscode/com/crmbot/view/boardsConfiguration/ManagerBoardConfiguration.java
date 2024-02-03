package nikguscode.com.crmbot.view.boardsConfiguration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "buttons.properties", encoding = "UTF-8")
@Getter
public class ManagerBoardConfiguration {
    @Value("${manager-btn.start}")
    private String start;
    @Value("${manager-btn.finish}")
    private String finish;
    @Value("${manager-btn.payment}")
    private String payout;

    @Value("${manager-cb.start}")
    private String startCallback;
    @Value("${manager-cb.finish}")
    private String finishCallback;
    @Value("${manager-cb.payment}")
    private String payoutCallback;
}
