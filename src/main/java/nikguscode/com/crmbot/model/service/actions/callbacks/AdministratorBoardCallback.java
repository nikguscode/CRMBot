package nikguscode.com.crmbot.model.service.actions.callbacks;

import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.model.service.extractors.CallbackExtractor;
import nikguscode.com.crmbot.view.boards.AdministratorBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class AdministratorBoardCallback implements Sender {
    private final CallbackExtractor extractor;
    private final AdministratorBoard board;

    @Autowired
    public AdministratorBoardCallback(CallbackExtractor extractor,
                                AdministratorBoard board) {
        this.extractor = extractor;
        this.board = board;
    }

    public EditMessageText send(Update update) {
        return EditMessageText.builder()
                .chatId(update.getCallbackQuery().getMessage().getChatId())
                .messageId(extractor.getMessageId(update))
                .text("Выберите действие")
                .replyMarkup(board.create())
                .build();
    }
}
