package nikguscode.com.crmbot.view;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
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
        KeyboardButton asd = new KeyboardButton();

        WebAppInfo webAppInfo = new WebAppInfo("https://friendly-fudge-f92397.netlify.app/");

        asd.setText("Login");
        asd.setWebApp(webAppInfo);

        row.add(asd);
        rowList.add(row);
        testBoard.setKeyboard(rowList);
    }

    public ReplyKeyboardMarkup getBoard() {
        createBoard();
        return testBoard;
    }
}
