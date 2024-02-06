package nikguscode.com.crmbot.view.boards;

import nikguscode.com.crmbot.view.boardsConfiguration.AdministratorBoardConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdministratorBoard extends Board {
    @Autowired
    private AdministratorBoardConfiguration configuration;

    @Override
    protected void initialize(InlineKeyboardMarkup boardMarkup) {
        List<List<InlineKeyboardButton>> board = new ArrayList<>();
        List<InlineKeyboardButton> setButtons = setButtons();

        var firstRow = new ArrayList<InlineKeyboardButton>();
        for (int i = 0; i < 3; i++) firstRow.add(setButtons.removeFirst());
        board.add(firstRow);

        for (InlineKeyboardButton currentButton : setButtons) {
            var row = new ArrayList<InlineKeyboardButton>();
            row.add(currentButton);
            board.add(row);
        }

        boardMarkup.setKeyboard(board);
    }

    @Override
    protected ArrayList<InlineKeyboardButton> setButtons() {
        return new ArrayList<>(List.of(
                InlineKeyboardButton.builder()
                        .text(configuration.getBotStatistics())
                        .callbackData(configuration.getBotStatisticsCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getReport())
                        .callbackData(configuration.getReportCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getEditReport())
                        .callbackData(configuration.getEditReportCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getManagerList())
                        .callbackData(configuration.getManagerListCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getBotSettings())
                        .callbackData(configuration.getBotSettingsCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getPersonalSettings())
                        .callbackData(configuration.getPersonalSettingsCallback()).build()
        ));
    }
}