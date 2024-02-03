package nikguscode.com.crmbot.model.service.actions.commands;

import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.view.boards.ManagerBoard;
import nikguscode.com.crmbot.view.boards.RoleSelectionBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class StartCommand implements Sender {
//    @Autowired
//    private ManagerBoard board;
    @Autowired
    private RoleSelectionBoard board;

    public SendMessage send(Update update) {
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("Выберите действие")
                .replyMarkup(board.create())
                .build();
    }
}
