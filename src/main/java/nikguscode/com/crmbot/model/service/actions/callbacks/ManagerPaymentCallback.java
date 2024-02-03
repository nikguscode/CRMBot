package nikguscode.com.crmbot.model.service.actions.callbacks;

import nikguscode.com.crmbot.model.service.actions.Sender;
import nikguscode.com.crmbot.model.service.extractors.CallbackExtractor;
import nikguscode.com.crmbot.view.boards.PaymentBoard;
import nikguscode.com.crmbot.view.boardsConfiguration.PaymentBoardType;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class ManagerPaymentCallback implements Sender {
    private final CallbackExtractor extractor;
    private final PaymentBoard board;

    public ManagerPaymentCallback(CallbackExtractor extractor,
                                  PaymentBoard board) {
        this.extractor = extractor;
        this.board = board;
    }

    public EditMessageText send(Update update) {
        return EditMessageText.builder()
                .chatId(update.getCallbackQuery().getMessage().getChatId())
                .messageId(extractor.getMessageId(update))
                .text("Выберите сумму платежа")
                .replyMarkup(board.create(PaymentBoardType.AMOUNT))
                .build();
    }
}
