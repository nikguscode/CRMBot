package nikguscode.com.crmbot.view.boards;

import nikguscode.com.crmbot.view.boardsConfiguration.BotSettingsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotSettingsBoard extends Board {
    @Autowired
    private BotSettingsConfiguration configuration;

    protected ArrayList<InlineKeyboardButton> setButtons() {
        return new ArrayList<>(List.of(
                InlineKeyboardButton.builder()
                        .text(configuration.getLogsManagement())
                        .callbackData(configuration.getLogsManagementCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getAccess())
                        .callbackData(configuration.getAccessCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getPayment())
                        .callbackData(configuration.getPaymentCallback()).build()
        ));
    }
}
