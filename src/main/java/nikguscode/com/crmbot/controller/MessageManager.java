package nikguscode.com.crmbot.controller;

import nikguscode.com.crmbot.view.TestBoard;
import nikguscode.com.crmbot.view.LoginBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageManager {
    private final LoginBoard loginBoard;

    @Autowired
    public MessageManager(LoginBoard loginBoard) {
        this.loginBoard = loginBoard;
    }

    public SendMessage send(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(update.getMessage().getChatId());
        msg.setText("WebApp");
        msg.setReplyMarkup(loginBoard.getBoard());

        return msg;
    }
    

}
