package nikguscode.com.crmbot.view.boards;

import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.view.boardsConfiguration.PaymentBoardConfiguration;
import nikguscode.com.crmbot.view.boardsConfiguration.PaymentBoardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class PaymentBoard {
    /*
     *  PaymentBoard содержит две клавиатуры:
     *  - AmountOfPayment вызывается для выбора суммы платежа
     *  - TypeOfPayment вызывается для выбора типа платежа
     *
     *  Первой вызывается AmountOfPayment, предлагающая выбрать сумму платежа, в зависимости от суммы платежа будет выбран...
     *  ...метод зачисления средств. Если сумма >= 100 рублей, то выставляется счёт с реальной оплатой, в противном...
     *  ...случае деньги зачисляются на замороженный счёт менеджера, где решение о их разморозке или удалении принимает...
     *  ...администратор.
     *
     *  Минимальная сумма счёта, которая доступна в Telegram - 100 RUB, поэтому метод платежа был разделён на реальный...
     *  ...и на искусственный, в виде замороженного счёта.
     */

    @Autowired
    private PaymentBoardConfiguration configuration;
    private InlineKeyboardMarkup boardMarkup;

    private void initializeAmountOfPayment() {
        List<List<InlineKeyboardButton>> board = new ArrayList<>();

        for (InlineKeyboardButton currentButton : setAmountOfPaymentButtons()) {
            var row = new ArrayList<InlineKeyboardButton>();
            row.add(currentButton);
            board.add(row);
        }

        boardMarkup.setKeyboard(board);
    }

    private ArrayList<InlineKeyboardButton> setAmountOfPaymentButtons() {
        return new ArrayList<>(List.of(
                InlineKeyboardButton.builder()
                        .text(configuration.getAmountOverThanHundred())
                        .callbackData(configuration.getCallbackOverThanHundred()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getAmountLessThanHundred())
                        .callbackData(configuration.getCallbackLessThanHundred()).build()
        ));
    }

    private void initializeTypeOfPayment() {
        List<List<InlineKeyboardButton>> board = new ArrayList<>();

        for (InlineKeyboardButton currentButton : setTypeOfPaymentButtons()) {
            var row = new ArrayList<InlineKeyboardButton>();
            row.add(currentButton);
            board.add(row);
        }

        boardMarkup.setKeyboard(board);
    }

    private ArrayList<InlineKeyboardButton> setTypeOfPaymentButtons() {
        return new ArrayList<>(List.of(
                InlineKeyboardButton.builder()
                        .text(configuration.getPaymentCommission())
                        .callbackData(configuration.getCallbackCommission()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getPaymentDeposit())
                        .callbackData(configuration.getCallbackDeposit()).build()
        ));
    }

    public InlineKeyboardMarkup create(PaymentBoardType boardType) {
        boardMarkup = new InlineKeyboardMarkup();

        switch (boardType) {
            case AMOUNT:
                initializeAmountOfPayment();
                break;
            case TYPE:
                initializeTypeOfPayment();
                break;
            default:
                log.error("Error, while creating payment board");
        }

        return boardMarkup;
    }
}