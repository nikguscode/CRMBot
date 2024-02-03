package nikguscode.com.crmbot.model.service.actions.configuration;

import lombok.Getter;
import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.model.service.actions.callbacks.AdministratorBoardCallback;
import nikguscode.com.crmbot.model.service.actions.callbacks.BotSettingsCallback;
import nikguscode.com.crmbot.model.service.actions.callbacks.ManagerBoardCallback;
import nikguscode.com.crmbot.model.service.actions.callbacks.ManagerPaymentCallback;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@Getter
public class CallbackConfiguration {
    private final HashMap<String, Sender> callbackMap;

    public CallbackConfiguration(ManagerPaymentCallback managerPaymentCallback,
                                 ManagerBoardCallback managerBoardCallback,
                                 AdministratorBoardCallback administratorBoardCallback,
                                 BotSettingsCallback botSettingsCallback) {
        callbackMap = new HashMap<>();
        callbackMap.put("manager_payment", managerPaymentCallback);
        callbackMap.put("manager_board", managerBoardCallback);
        callbackMap.put("administrator_board", administratorBoardCallback);
        callbackMap.put("bot_settings", botSettingsCallback);
    }
}
