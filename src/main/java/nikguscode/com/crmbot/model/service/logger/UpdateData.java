package nikguscode.com.crmbot.model.service.logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import nikguscode.com.crmbot.model.service.enums.SenderType;
import nikguscode.com.crmbot.model.service.enums.TelegramType;

@Getter
@Builder
@JsonIgnoreProperties(value = {"dataType"})
public final class UpdateData {
    private final String time;
    private final SenderType senderType;
    private final TelegramType dataType;
    private final Long telegramUserId;
    private final Integer messageId;
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String text;
    private final String callbackId;
    private final String callback;
}
