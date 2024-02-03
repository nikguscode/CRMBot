package nikguscode.com.crmbot.view.boards;

import nikguscode.com.crmbot.view.boardsConfiguration.BotSettingsConfiguration;
import nikguscode.com.crmbot.view.boardsConfiguration.ManagerBoardConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotSettingsBoard {
    @Autowired
    private BotSettingsConfiguration configuration;
    private InlineKeyboardMarkup boardMarkup;

    private void initialize() {
        List<List<InlineKeyboardButton>> board = new ArrayList<>();

        for (InlineKeyboardButton currentButton : setButtons()) {
            var row = new ArrayList<InlineKeyboardButton>();
            row.add(currentButton);
            board.add(row);
        }

        boardMarkup.setKeyboard(board);
    }

    private ArrayList<InlineKeyboardButton> setButtons() {
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

    public InlineKeyboardMarkup create() {
        boardMarkup = new InlineKeyboardMarkup();
        initialize();
        return boardMarkup;
    }
}
