package nikguscode.com.crmbot.view.boards;

import nikguscode.com.crmbot.view.boardsConfiguration.RoleSelectionBoardConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleSelectionBoard {
    @Autowired
    private RoleSelectionBoardConfiguration configuration;
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
                        .text(configuration.getManagerBoard())
                        .callbackData(configuration.getManagerBoardCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getAdministratorBoard())
                        .callbackData(configuration.getAdministratorBoardCallback()).build()
        ));
    }

    public InlineKeyboardMarkup create() {
        boardMarkup = new InlineKeyboardMarkup();
        initialize();
        return boardMarkup;
    }
}
