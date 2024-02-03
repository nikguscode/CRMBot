package nikguscode.com.crmbot.view.boardsConfiguration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "buttons.properties", encoding = "UTF-8")
@Getter
public class PaymentBoardConfiguration {
    @Value("${amount-board-btn.over-than-hundred}")
    private String amountOverThanHundred;
    @Value("${amount-board-btn.less-than-hundred}")
    private String amountLessThanHundred;
    @Value("${type-board-btn.commission}")
    private String paymentCommission;
    @Value("${type-board-btn.deposit}")
    private String paymentDeposit;

    @Value("${amount-board-cb.over-than-hundred}")
    private String callbackOverThanHundred;
    @Value("${amount-board-cb.less-than-hundred}")
    private String callbackLessThanHundred;
    @Value("${type-board-cb.commission}")
    private String callbackCommission;
    @Value("${type-board-cb.deposit}")
    private String callbackDeposit;
}
