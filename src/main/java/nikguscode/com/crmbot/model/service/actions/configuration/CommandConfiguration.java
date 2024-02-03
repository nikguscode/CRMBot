package nikguscode.com.crmbot.model.service.actions.configuration;

import lombok.Getter;
import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.model.service.actions.commands.StartCommand;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@Getter
public class CommandConfiguration {
    private final HashMap<String, Sender> commandMap;

    public CommandConfiguration(StartCommand startCommand) {
        commandMap = new HashMap<>();
        commandMap.put("/start", startCommand);
    }
}
