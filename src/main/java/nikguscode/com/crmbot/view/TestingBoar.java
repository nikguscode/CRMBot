package nikguscode.com.crmbot.view;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestingBoar {
    private ReplyKeyboardMarkup testBoard;

    public void createBoard() {
        testBoard = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();


        KeyboardRow row = new KeyboardRow();

        row.add("How are you");

        WebAppInfo webAppInfo = new WebAppInfo();
        webAppInfo.setUrl("https://t.me/crmasd_bot/auth");

        rowList.add(row);
        testBoard.setKeyboard(rowList);
    }

    public ReplyKeyboardMarkup getBoard() {
        createBoard();
        return testBoard;
    }
}
