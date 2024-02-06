package nikguscode.com.crmbot.view.boards;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class Board {
    protected void initialize(InlineKeyboardMarkup boardMarkup) {
        List<List<InlineKeyboardButton>> board = new ArrayList<>();

        for (InlineKeyboardButton currentButton : setButtons()) {
            var row = new ArrayList<InlineKeyboardButton>();
            row.add(currentButton);
            board.add(row);
        }

        boardMarkup.setKeyboard(board);
    }

    protected ArrayList<InlineKeyboardButton> setButtons() {
        return null;
    }

    public InlineKeyboardMarkup create() {
        var boardMarkup = new InlineKeyboardMarkup();
        initialize(boardMarkup);
        return boardMarkup;
    }
}
