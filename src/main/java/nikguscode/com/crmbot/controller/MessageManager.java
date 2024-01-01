package nikguscode.com.crmbot.controller;

import nikguscode.com.crmbot.view.TestBoard;
import nikguscode.com.crmbot.view.TestingBoar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageManager {

    private TestBoard testBoard;
    private TestingBoar testingBoar;

    @Autowired
    public MessageManager(TestBoard testBoard, TestingBoar testingBoar) {
        this.testBoard = testBoard;
        this.testingBoar = testingBoar;
    }

    public SendMessage send(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(update.getMessage().getChatId());
        msg.setText("WebApp");
        msg.setReplyMarkup(testBoard.getBoard());
        //msg.setReplyMarkup(testingBoar.getBoard());

        return msg;
    }

}
