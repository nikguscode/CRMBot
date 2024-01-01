package nikguscode.com.crmbot.view;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestBoard {

    private InlineKeyboardMarkup testBoard;

    public void createBoard() {
        testBoard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton test = new InlineKeyboardButton();
        test.setText("WebApp");
        test.setCallbackData("webapp");
        test.setUrl("https://t.me/crmasd_bot/auth");

        row.add(test);
        rowList.add(row);
        testBoard.setKeyboard(rowList);
    }

    public InlineKeyboardMarkup getBoard() {
        createBoard();
        return testBoard;
    }

}
