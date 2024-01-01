package nikguscode.com.crmbot.view;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginBoard {
    private ReplyKeyboardMarkup loginBoard;

    public void createBoard() {
        loginBoard = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton login = new KeyboardButton();

        login.setText("Login");
        login.setWebApp(new WebAppInfo("https://friendly-fudge-f92397.netlify.app/"));

        row.add(login);
        rowList.add(row);
        loginBoard.setKeyboard(rowList);
    }

    public ReplyKeyboardMarkup getBoard() {
        createBoard();
        return loginBoard;
    }
}
