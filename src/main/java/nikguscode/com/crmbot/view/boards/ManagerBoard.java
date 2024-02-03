package nikguscode.com.crmbot.view.boards;

import nikguscode.com.crmbot.view.boardsConfiguration.ManagerBoardConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerBoard {
    @Autowired
    private ManagerBoardConfiguration configuration;
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
        // test ? InlineKeyboardButton.builder().text("Начать смену").callbackData("mng_start_shift").build()
        //                        : InlineKeyboardButton.builder().text("Завершить смену").callbackData("mng_finish_shift").build(),
        return new ArrayList<>(List.of(
                InlineKeyboardButton.builder()
                        .text(configuration.getStart())
                        .callbackData(configuration.getStartCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getFinish())
                        .callbackData(configuration.getFinishCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getPayout())
                        .callbackData(configuration.getPayoutCallback()).build()
        ));
    }

    public InlineKeyboardMarkup create() {
        boardMarkup = new InlineKeyboardMarkup();
        initialize();
        return boardMarkup;
    }
}
