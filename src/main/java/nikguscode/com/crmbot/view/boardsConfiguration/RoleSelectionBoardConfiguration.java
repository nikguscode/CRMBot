package nikguscode.com.crmbot.view.boardsConfiguration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "buttons.properties", encoding = "UTF-8")
@Getter
public class RoleSelectionBoardConfiguration {
    @Value("${manager-board-btn}")
    private String managerBoard;
    @Value("${administrator-board-btn}")
    private String administratorBoard;

    @Value("${manager-board-cb}")
    private String managerBoardCallback;
    @Value("${administrator-board-cb}")
    private String administratorBoardCallback;
}
